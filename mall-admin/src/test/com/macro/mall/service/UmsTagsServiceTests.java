package com.macro.mall.service;

import com.macro.mall.mapper.UmsTagsMapper;
import com.macro.mall.model.UmsTags;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UmsTagsServiceTests {

    @Autowired
    private UmsTagsMapper umsTagsMapper;

    @Test
    @Transactional
    @Rollback
    public void testInsertBatch(){

        UmsTags umsTags = new UmsTags();
        umsTags.setId(1L);
        umsTags.setTagName("美国大买家");
        umsTags.setLastCreateTime("20190108135000");
        umsTags.setLastCreateId("UmsTagsServiceTests");
        umsTags.setLastUpdateTime("20190108135000");
        umsTags.setLastUpdateId("UmsTagsServiceTests");

        int count = umsTagsMapper.insert(umsTags);
        Assert.assertEquals(1, count);
    }
}
