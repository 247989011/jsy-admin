package com.macro.mall.mapper;

import com.macro.mall.model.PaymsPayTemplate;
import com.macro.mall.model.PaymsPayTemplateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PaymsPayTemplateMapper {
    int countByExample(PaymsPayTemplateExample example);

    int deleteByExample(PaymsPayTemplateExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PaymsPayTemplate record);

    int insertSelective(PaymsPayTemplate record);

    List<PaymsPayTemplate> selectByExample(PaymsPayTemplateExample example);

    PaymsPayTemplate selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PaymsPayTemplate record, @Param("example") PaymsPayTemplateExample example);

    int updateByExample(@Param("record") PaymsPayTemplate record, @Param("example") PaymsPayTemplateExample example);

    int updateByPrimaryKeySelective(PaymsPayTemplate record);

    int updateByPrimaryKey(PaymsPayTemplate record);
}