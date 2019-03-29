package com.macro.mall.common.service;

import com.macro.mall.common.dto.FdfsFileDto;
import com.macro.mall.common.model.FdfsFilenameMapper;

/**
 * FdfsFileService
 * Created by ruiwu.xu on 2018/01/02.
 */
public interface FdfsFileService {
    /**
     *增加文件映射关系
     * @param fdfsFilenameMapper
     * @return
     */
    int add(FdfsFilenameMapper  fdfsFilenameMapper);

    /**
     *
     * @param fdfsFileDto
     * @return
     */
    FdfsFilenameMapper search(FdfsFileDto  fdfsFileDto);
}
