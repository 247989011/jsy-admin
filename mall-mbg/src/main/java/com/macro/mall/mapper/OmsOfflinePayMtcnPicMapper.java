package com.macro.mall.mapper;

import com.macro.mall.model.OmsOfflinePayMtcnPic;
import com.macro.mall.model.OmsOfflinePayMtcnPicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OmsOfflinePayMtcnPicMapper {
    int countByExample(OmsOfflinePayMtcnPicExample example);

    int deleteByExample(OmsOfflinePayMtcnPicExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OmsOfflinePayMtcnPic record);

    int insertSelective(OmsOfflinePayMtcnPic record);

    List<OmsOfflinePayMtcnPic> selectByExample(OmsOfflinePayMtcnPicExample example);

    OmsOfflinePayMtcnPic selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OmsOfflinePayMtcnPic record, @Param("example") OmsOfflinePayMtcnPicExample example);

    int updateByExample(@Param("record") OmsOfflinePayMtcnPic record, @Param("example") OmsOfflinePayMtcnPicExample example);

    int updateByPrimaryKeySelective(OmsOfflinePayMtcnPic record);

    int updateByPrimaryKey(OmsOfflinePayMtcnPic record);
}