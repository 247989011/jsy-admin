package com.macro.mall.portal.controller;

import com.luhuiguo.fastdfs.domain.StorePath;
import com.luhuiguo.fastdfs.service.FastFileStorageClient;
import com.macro.mall.common.model.FdfsFilenameMapper;
import com.macro.mall.portal.domain.CommonResult;
import com.macro.mall.portal.dto.FdfsFileDto;
import com.macro.mall.portal.service.FdfsFileService;
import com.xiaoleilu.hutool.io.FileUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 文件/图片管理
 * Created by macro on 2018/4/26.
 */
@Controller
@Api(tags = "存储模块-fastDfs文件存储管理", description = "fastDfs文件存储管理:FastdfsController", position = 100)
@RequestMapping("/mall/file")
@Slf4j
public class FastdfsController {

    @Autowired
    private FastFileStorageClient fastFileStorageClient;

    @Autowired
    private FdfsFileService fdfsFileService;

    @ApiOperation(value = "文件/图片批量上传")
    @ApiResponses({@ApiResponse(code = 201, response = FdfsFileDto.class,
            message = "状态200的data格式说明：data返回值为列表")})
    @RequestMapping(value = "/batch/upload", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult batchUpload(@RequestParam("file") MultipartFile[] files) {

        //定义返回值
        List<FdfsFileDto> fdfsFileDtoList = new ArrayList<FdfsFileDto>();

        if (files == null || files.length == 0) {
            log.warn("无文件需要上传");
            return new CommonResult().success(null);
        }

        for (MultipartFile file : files) {
            String fileExt = FileUtil.extName(file.getOriginalFilename());
            FdfsFileDto fdfsFileDto = new FdfsFileDto();
            try {
                StorePath storePath = fastFileStorageClient.uploadFile(file.getBytes(), fileExt);
                fdfsFileDto.setFdfsFullName(storePath.getFullPath());
                fdfsFileDto.setFdfsGroup(storePath.getGroup());
                fdfsFileDto.setOriginName(file.getOriginalFilename());
                fdfsFileDto.setFileContext(null);

                FdfsFilenameMapper fdfsFilenameMapper = new FdfsFilenameMapper();
                fdfsFilenameMapper.setFdfsFullPathName(storePath.getFullPath());
                fdfsFilenameMapper.setOriginFileName(file.getOriginalFilename());
                fdfsFilenameMapper.setFdfsGroup(storePath.getGroup());
                fdfsFilenameMapper.setLastCreateId("fdfs");
                fdfsFilenameMapper.setLastCreateTime(new Date());
                fdfsFilenameMapper.setLastUpdateId("fdfs");
                fdfsFilenameMapper.setLastUpdateTime(new Date());
                int cnt = fdfsFileService.add(fdfsFilenameMapper);
                if (cnt < 0) {
                    return new CommonResult().failed();
                }
                fdfsFileDtoList.add(fdfsFileDto);
                log.debug("fullPathName = {}", storePath.getFullPath());
            } catch (IOException e) {
                log.error("文件上传异常{}", e);
                throw new RuntimeException(e);
            }
        }
        log.debug("文件上传成功 ");
        return new CommonResult().success(fdfsFileDtoList);
    }

    @ApiOperation(value = "文件/图片上传")
    @ApiResponses({@ApiResponse(code = 201, response = FdfsFileDto.class,
            message = "状态200的data格式说明：data返回值为对象")})
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult upload(@RequestParam("file") MultipartFile file) {
        String fileExt = FileUtil.extName(file.getOriginalFilename());
        FdfsFileDto fdfsFileDto = new FdfsFileDto();
        try {
            StorePath storePath = fastFileStorageClient.uploadFile(file.getBytes(), fileExt);
            fdfsFileDto.setFdfsFullName(storePath.getFullPath());
            fdfsFileDto.setFdfsGroup(storePath.getGroup());
            fdfsFileDto.setOriginName(file.getOriginalFilename());
            fdfsFileDto.setFileContext(null);

            FdfsFilenameMapper fdfsFilenameMapper = new FdfsFilenameMapper();
            fdfsFilenameMapper.setFdfsFullPathName(storePath.getFullPath());
            fdfsFilenameMapper.setOriginFileName(file.getOriginalFilename());
            fdfsFilenameMapper.setFdfsGroup(storePath.getGroup());
            fdfsFilenameMapper.setLastCreateId("fdfs");
            fdfsFilenameMapper.setLastCreateTime(new Date());
            fdfsFilenameMapper.setLastUpdateId("fdfs");
            fdfsFilenameMapper.setLastUpdateTime(new Date());
            fdfsFileService.add(fdfsFilenameMapper);

            log.debug("fullPathName = {}", storePath.getFullPath());
        } catch (IOException e) {
            log.error("文件上传异常{}", e);
            throw new RuntimeException(e);
        }
        log.debug("文件上传成功 ");
        return new CommonResult().success(fdfsFileDto);
    }

    @ApiOperation(value = "文件/图片下载,前台展示")
    @RequestMapping(value = "/readImage", method = RequestMethod.GET)
    public void readImage(HttpServletRequest request, HttpServletResponse response,
                          @RequestParam("imagePath") String imagePath) {
        response.setContentType("image/" + imagePath.substring(imagePath.lastIndexOf(".") + 1)); // 设置返回的文件类型
        response.setCharacterEncoding("utf-8");
        //String imagePath = request.getParameter("imagePath");// 图片绝对路径
        // 最多分割出2个字符串
        int maxSplit = 2;
        String[] fdfsFullPathNameStrArray = imagePath.split("/", maxSplit);
        String realImagePath = imagePath.replace(fdfsFullPathNameStrArray[0] + "/", "");
        log.debug("组别信息{}，全路径{}", fdfsFullPathNameStrArray[0], imagePath);
        byte[] bytes = fastFileStorageClient.downloadFile("group1", realImagePath);

        try {
            InputStream ins = new ByteArrayInputStream(bytes);
//            File file = new File("D:/test.png");
//            FileOutputStream fos = new FileOutputStream(file);
//            fos.write(bytes);
//            fos.flush();
//            fos.close();
            OutputStream temps = response.getOutputStream();
            temps.write(bytes);
            temps.flush();

            log.debug("读到的缓存大小:{}", response.getBufferSize());
            temps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ApiOperation(value = "文件/图片下载")
    @ApiIgnore
    @ApiResponses({@ApiResponse(code = 201, response = FdfsFileDto.class,
            message = "状态200的data格式说明：data返回值为对象")})
    @RequestMapping(value = "/v2/download", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult downloadV2(@RequestParam("fdfsFullPathName") String fdfsFullPathName) {

        // 最多分割出2个字符串
        int maxSplit = 2;
        String[] fdfsFullPathNameStrArray = fdfsFullPathName.split("/", maxSplit);
        log.debug("组别信息{}，全路径{}", fdfsFullPathNameStrArray[0], fdfsFullPathName);

        FdfsFileDto fdfsFileDto = new FdfsFileDto();
        byte[] fileContext = fastFileStorageClient.downloadFile(fdfsFullPathNameStrArray[0],
                fdfsFullPathName.replace(fdfsFullPathNameStrArray[0] + "/", ""));
        fdfsFileDto.setFdfsFullName(fdfsFullPathName);
        fdfsFileDto.setFdfsGroup(fdfsFullPathNameStrArray[0]);
        fdfsFileDto.setFileContext(fileContext);
        FdfsFilenameMapper fdfsFilenameMapper = fdfsFileService.search(fdfsFileDto);
        fdfsFileDto.setOriginName(fdfsFilenameMapper.getOriginFileName());
        return new CommonResult().success(fileContext);
    }

    @ApiOperation(value = "文件/图片下载")
    @ApiIgnore
    @ApiResponses({@ApiResponse(code = 201, response = FdfsFileDto.class,
            message = "状态200的data格式说明：data返回值为对象")})
    @RequestMapping(value = "/v1/download", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult download(@RequestParam("fdsGroup") String fdsGroup, @RequestParam("fdfsFullPathName") String fdfsFullPathName) {
        FdfsFileDto fdfsFileDto = new FdfsFileDto();
        byte[] fileContext = fastFileStorageClient.downloadFile(fdsGroup, fdfsFullPathName);
        fdfsFileDto.setFdfsFullName(fdfsFullPathName);
        fdfsFileDto.setFdfsGroup(fdsGroup);
        fdfsFileDto.setFileContext(fileContext);
        FdfsFilenameMapper fdfsFilenameMapper = fdfsFileService.search(fdfsFileDto);
        fdfsFileDto.setOriginName(fdfsFilenameMapper.getOriginFileName());
        return new CommonResult().success(fileContext);
    }

}
