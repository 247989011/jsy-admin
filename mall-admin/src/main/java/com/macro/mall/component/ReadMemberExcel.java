package com.macro.mall.component;

import com.macro.mall.mapper.UmsAdminMapper;
import com.macro.mall.mapper.UmsMemberTagsMapper;
import com.macro.mall.mapper.UmsTagsMapper;
import com.macro.mall.model.UmsAdmin;
import com.macro.mall.model.UmsAdminExample;
import com.macro.mall.model.UmsMember;
import com.macro.mall.util.WDWUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@Slf4j
public class ReadMemberExcel {
    @Autowired
    private UmsAdminMapper umsAdminMapper;
    @Autowired
    private UmsTagsMapper umsTagsMapper;
    @Autowired
    private UmsMemberTagsMapper umsMemberTagsMapper;

    //总行数
    private int totalRows = 0;
    //总条数
    private int totalCells = 0;
    //错误信息接收器
    private String errorMsg;
    //构造方法
    public ReadMemberExcel(){}
    //获取总行数
    public int getTotalRows()  { return totalRows;}
    //获取总列数
    public int getTotalCells() {  return totalCells;}
    //获取错误信息
    public String getErrorInfo() { return errorMsg; }

    /**
     * 验证EXCEL文件
     * @param filePath
     * @return
     */
    public boolean validateExcel(String filePath){
        if (filePath == null || !(WDWUtil.isExcel2003(filePath) || WDWUtil.isExcel2007(filePath))){
            errorMsg = "文件名不是excel格式";
            return false;
        }
        return true;
    }

    /**
     * 读EXCEL文件，获取客户信息集合
     * @param fileName
     * @return
     */
    public List<UmsMember> getExcelInfo(String fileName,MultipartFile Mfile){

        //初始化客户信息的集合
        List<UmsMember> memberList = new ArrayList<>();
        //初始化输入流
        InputStream is = null;
        try{
            //验证文件名是否合格
            if(!validateExcel(fileName)){
                return null;
            }
            //根据文件名判断文件是2003版本还是2007版本
            boolean isExcel2003 = true;
            if(WDWUtil.isExcel2007(fileName)){
                isExcel2003 = false;
            }
            //根据新建的文件实例化输入流
            is = Mfile.getInputStream();
            //根据excel里面的内容读取客户信息
            memberList = getExcelInfo(is, isExcel2003);
            is.close();
        }catch(Exception e){
            e.printStackTrace();
        } finally{
            if(is !=null)
            {
                try{
                    is.close();
                }catch(IOException e){
                    is = null;
                    e.printStackTrace();
                }
            }
        }

        return memberList;
    }

    /**
     * 根据excel里面的内容读取客户信息
     * @param is 输入流
     * @param isExcel2003 excel是2003还是2007版本
     * @return
     * @throws IOException
     */
    private   List<UmsMember> getExcelInfo(InputStream is, boolean isExcel2003){
        List<UmsMember> memberList=null;
        try{
            /** 根据版本选择创建Workbook的方式 */
            Workbook wb = null;
            //当excel是2003时
            if(isExcel2003){
                wb = new HSSFWorkbook(is);
            }
            else{//当excel是2007时
                wb = new XSSFWorkbook(is);
            }
            //读取Excel里面客户的信息
            memberList=readExcelValue(wb);
        } catch (IOException e)  {
            e.printStackTrace();
        }
        return memberList;
    }

    /**
     * 读取Excel里面客户的信息
     * @param wb
     * @return
     */
    private List<UmsMember> readExcelValue(Workbook wb){
        //得到第一个shell
        Sheet sheet=wb.getSheetAt(0);

        //得到Excel的行数
        this.totalRows=sheet.getPhysicalNumberOfRows();

        //得到Excel的列数(前提是有行数)
        if(totalRows>=1 && sheet.getRow(0) != null){
            this.totalCells=sheet.getRow(0).getPhysicalNumberOfCells();
        }

        List<UmsMember> memberList=new ArrayList<UmsMember>();
        UmsMember umsMember;
        //循环Excel行数,从第二行开始。标题不入库
        for(int r=1;r<totalRows;r++){
            Row row = sheet.getRow(r);
            if (row == null) continue;
            umsMember = new UmsMember();

            //循环Excel的列
            for(int c = 0; c <this.totalCells; c++){
                Cell cell = row.getCell(c);
                if (null != cell){
                    if(c==0){//第一列不读
                    }else if(c==1){
                        umsMember.setUsername(cell.getStringCellValue());//账户
                    }else if(c==2){
                        umsMember.setNickname(cell.getStringCellValue());//姓名
                    }else if(c==3){
                        umsMember.setEmail(cell.getStringCellValue());//邮箱
                    }else if(c==4){
                        umsMember.setPhone(cell.getStringCellValue());//手机号码
                    }else if(c==5){
                        //TODO  密码需要加密
                        umsMember.setPassword(cell.getStringCellValue());//系统初始密码
                    } else if(c==6){
                        if (cell.getStringCellValue().contentEquals("男")){
                            umsMember.setGender( 1);//客户姓别
                        }else if (cell.getStringCellValue().contentEquals("女")){
                            umsMember.setGender( 2);//客户姓别
                        }else{
                            umsMember.setGender( 0);//客户姓别 -- 未知
                        }
                    }else if(c==7){
                        try {
                            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
                            umsMember.setBirthday(df.parse(cell.getStringCellValue()));//出生日期
                        }catch (ParseException e){
                            e.printStackTrace();
                        }
                    } else if(c==8){
                        UmsAdminExample example = new UmsAdminExample();
                        String strTemp = "%" + cell.getStringCellValue() +"%";
                        example.createCriteria().andUsernameLike(strTemp);
                        List<UmsAdmin> adminList =  umsAdminMapper.selectByExample(example);
                        if (adminList.size() != 0){
                            umsMember.setUmsAdminId(adminList.get(0).getId());//所属业务员ID
                        }else{
                            Long lvar = 0l;
                            umsMember.setUmsAdminId(lvar);
                        }
                    }else if(c==9){
                        umsMember.setWeixin(cell.getStringCellValue());//微信账号
                    }else if(c==10){
                        umsMember.setQq(cell.getStringCellValue());//QQ账号
                    }else if(c==11){
                        umsMember.setTwitter(cell.getStringCellValue());//Twitter账号
                    }else if(c==12){
                        umsMember.setSkype(cell.getStringCellValue());//Skype账号
                    }else if(c==13){
                        umsMember.setInstagram(cell.getStringCellValue());//Instagram账号
                    }else if(c==14){
                        umsMember.setFacebook(cell.getStringCellValue());//Facebook账号
                    }else if(c==15){
                        umsMember.setWhatsapp(cell.getStringCellValue());//Whatsapp账号
                    }else if(c==16){
                        umsMember.setTumblr(cell.getStringCellValue());//Whatsapp账号
                    }
                }
            }
            umsMember.setStatus(1); //启用
            SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
            umsMember.setCreateTime(new Date());// new Date()为获取当前系统时间
            //添加客户
            memberList.add(umsMember);
        }
        return memberList;
    }

}
