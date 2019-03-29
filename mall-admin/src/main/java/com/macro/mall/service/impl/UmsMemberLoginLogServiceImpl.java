package com.macro.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.dto.UmsMemberLoginLogDto;
import com.macro.mall.mapper.UmsMemberLoginLogMapper;
import com.macro.mall.mapper.UmsMemberMapper;
import com.macro.mall.model.UmsMember;
import com.macro.mall.model.UmsMemberExample;
import com.macro.mall.model.UmsMemberLoginLog;
import com.macro.mall.model.UmsMemberLoginLogExample;
import com.macro.mall.service.UmsMemberLoginLogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 会员跟踪日志Service实现类
 * Created by macro on 2018/4/26.
 */
@Service
public class UmsMemberLoginLogServiceImpl implements UmsMemberLoginLogService {
    @Autowired
    private UmsMemberLoginLogMapper umsMemberLoginLogMapper;
    @Autowired
    private UmsMemberMapper umsMemberMapper;

    /**
     * 分页查询会员登录日志
     *
     * @param keyword
     * @param pageSize
     * @param pageNum
     */
    @Override
    public List<UmsMemberLoginLogDto> page(String keyword, Integer pageSize, Integer pageNum) {
        //设置分页
        PageHelper.startPage(pageNum, pageSize);

        //处理查询关键字
        StringBuffer keywordHandle = new StringBuffer();
        keywordHandle.append("%").append(keyword).append("%");

        //定义查询结果返回值
        List<UmsMemberLoginLogDto> umsMemberLoginLogDtoList = new ArrayList<UmsMemberLoginLogDto>();

        UmsMemberExample example = new UmsMemberExample();
        UmsMemberExample.Criteria criteria1 = example.createCriteria();
        UmsMemberExample.Criteria criteria2 = example.createCriteria();
        criteria1.andNicknameLike(keywordHandle.toString());
        example.or(criteria2.andUsernameLike(keywordHandle.toString()));
        List<UmsMember> umsMemberList =  umsMemberMapper.selectByExample(example);
        for (UmsMember e : umsMemberList) {
            UmsMemberLoginLogExample memberLoginLogExample = new UmsMemberLoginLogExample();
            memberLoginLogExample.createCriteria().andMemberIdEqualTo(e.getId());
            List<UmsMemberLoginLog> umsMemberLoginLogList = umsMemberLoginLogMapper.selectByExample(memberLoginLogExample);
            for (UmsMemberLoginLog ee : umsMemberLoginLogList) {
                UmsMemberLoginLogDto  memberLoginLogDto = new UmsMemberLoginLogDto();
                memberLoginLogDto.setMember(e);
                BeanUtils.copyProperties(ee, memberLoginLogDto);
                umsMemberLoginLogDtoList.add(memberLoginLogDto);
            }
        }
        return umsMemberLoginLogDtoList;
    }
}
