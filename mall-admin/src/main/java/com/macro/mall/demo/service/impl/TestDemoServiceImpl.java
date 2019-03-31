package com.macro.mall.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.demo.mapper.TestDemoMapper;
import com.macro.mall.demo.model.TestDemo;
import com.macro.mall.demo.service.TestDemoService;
import org.springframework.stereotype.Service;

@Service
public class TestDemoServiceImpl
        extends ServiceImpl<TestDemoMapper, TestDemo>
        implements TestDemoService {

}
