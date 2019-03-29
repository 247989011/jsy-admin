package com.macro.mall.mapper;

import com.macro.mall.model.LmsDomainDictionary;
import com.macro.mall.model.LmsDomainDictionaryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LmsDomainDictionaryMapper {
    int countByExample(LmsDomainDictionaryExample example);

    int deleteByExample(LmsDomainDictionaryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LmsDomainDictionary record);

    int insertSelective(LmsDomainDictionary record);

    List<LmsDomainDictionary> selectByExample(LmsDomainDictionaryExample example);

    LmsDomainDictionary selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LmsDomainDictionary record, @Param("example") LmsDomainDictionaryExample example);

    int updateByExample(@Param("record") LmsDomainDictionary record, @Param("example") LmsDomainDictionaryExample example);

    int updateByPrimaryKeySelective(LmsDomainDictionary record);

    int updateByPrimaryKey(LmsDomainDictionary record);
}