package com.macro.mall.mapper;

import com.macro.mall.model.PaymsPayTemplateModeRelation;
import com.macro.mall.model.PaymsPayTemplateModeRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PaymsPayTemplateModeRelationMapper {
    int countByExample(PaymsPayTemplateModeRelationExample example);

    int deleteByExample(PaymsPayTemplateModeRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PaymsPayTemplateModeRelation record);

    int insertSelective(PaymsPayTemplateModeRelation record);

    List<PaymsPayTemplateModeRelation> selectByExample(PaymsPayTemplateModeRelationExample example);

    PaymsPayTemplateModeRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PaymsPayTemplateModeRelation record, @Param("example") PaymsPayTemplateModeRelationExample example);

    int updateByExample(@Param("record") PaymsPayTemplateModeRelation record, @Param("example") PaymsPayTemplateModeRelationExample example);

    int updateByPrimaryKeySelective(PaymsPayTemplateModeRelation record);

    int updateByPrimaryKey(PaymsPayTemplateModeRelation record);
}