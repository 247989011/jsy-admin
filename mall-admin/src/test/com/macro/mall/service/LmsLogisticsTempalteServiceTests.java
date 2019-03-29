package com.macro.mall.common.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class LmsLogisticsTempalteServiceTests {

    @Autowired
    private LmsLogisticsTemplateService  lmsLogisticsTemplateService;

    @Test
    public void testInsertBatch(){
        List<LmsLogisticsTemplate>  logisticsTemplateList = lmsLogisticsTemplateService.page("111", 5, 1);
        log.debug("logisticsTemplateList={}", logisticsTemplateList.toString());
    }
}
