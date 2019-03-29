package com.macro.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.dto.UmsMemberTraceLogsDto;
import com.macro.mall.mapper.UmsAdminMapper;
import com.macro.mall.mapper.UmsMemberMapper;
import com.macro.mall.mapper.UmsMemberTraceLogsMapper;
import com.macro.mall.model.UmsAdmin;
import com.macro.mall.model.UmsMember;
import com.macro.mall.model.UmsMemberTraceLogs;
import com.macro.mall.model.UmsMemberTraceLogsExample;
import com.macro.mall.service.UmsMemberLogsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 会员跟踪日志Service实现类
 * Created by macro on 2018/4/26.
 */
@Service
public class UmsMemberLogsServiceImpl implements UmsMemberLogsService {
    @Autowired
    private UmsMemberTraceLogsMapper umsMemberTraceLogsMapper;
    @Autowired
    private UmsMemberMapper  umsMemberMapper;
    @Autowired
    private UmsAdminMapper umsAdminMapper;

    /**
     * 获取所有会员跟踪日志(by memberId)
     *
     * @param memberId
     * @param pageSize
     * @param pageNum
     */
    @Override
    public  List<UmsMemberTraceLogsDto> page(Long memberId, Integer pageSize, Integer pageNum) {
        //设置分页查询
        PageHelper.startPage(pageNum, pageSize);
        //返回值初始化
        List<UmsMemberTraceLogsDto> memberTraceLogsDtoList = new ArrayList<UmsMemberTraceLogsDto>();

        UmsMemberTraceLogsExample umsMemberTraceLogsExample = new UmsMemberTraceLogsExample();
        umsMemberTraceLogsExample.createCriteria().andIdEqualTo(memberId);
        List<UmsMemberTraceLogs> umsMemberTraceLogsList = umsMemberTraceLogsMapper.selectByExampleWithBLOBs(umsMemberTraceLogsExample);
        for (UmsMemberTraceLogs e : umsMemberTraceLogsList) {
            UmsMemberTraceLogsDto memberTraceLogsDto = new UmsMemberTraceLogsDto();
            BeanUtils.copyProperties(e, memberTraceLogsDto);
            memberTraceLogsDto.setMemberName(umsMemberMapper.selectByPrimaryKey(e.getMemberId()).getUsername());
            memberTraceLogsDto.setAdminName(umsAdminMapper.selectByPrimaryKey(e.getAdminId()).getUsername());
            memberTraceLogsDtoList.add(memberTraceLogsDto);
        }

        return memberTraceLogsDtoList;
    }

    @Override
    public  UmsMemberTraceLogsDto get(Long id) {
        //定义返回值
        UmsMemberTraceLogsDto memberTraceLogsDto = new UmsMemberTraceLogsDto();
        //查询数据
        UmsMemberTraceLogs umsMemberTraceLogs =  umsMemberTraceLogsMapper.selectByPrimaryKey(id);
        //设置返回结果
        BeanUtils.copyProperties(umsMemberTraceLogs, memberTraceLogsDto);
        UmsMember member = umsMemberMapper.selectByPrimaryKey(umsMemberTraceLogs.getMemberId());
        if(member != null && !member.getUsername().isEmpty()){
            memberTraceLogsDto.setMemberName(member.getUsername());
        }else {
            memberTraceLogsDto.setMemberName("未知客户姓名");
        }
        UmsAdmin admin = umsAdminMapper.selectByPrimaryKey(umsMemberTraceLogs.getAdminId());
        if(admin != null && !admin.getUsername().isEmpty()){
            memberTraceLogsDto.setAdminName(admin.getUsername());
        }else {
            memberTraceLogsDto.setAdminName("未知业务员姓名");
        }

        //返回查询结果
        return memberTraceLogsDto;
    }

    /**
     * 获取所有会员跟踪日志(by keyword)
     *
     * @param keyword
     * @param pageSize
     * @param pageNum
     */
    @Override
    public List<UmsMemberTraceLogsDto> page(String keyword, Integer pageSize, Integer pageNum) {
        //设置分页查询
        PageHelper.startPage(pageNum, pageSize);

       //返回值初始化
        List<UmsMemberTraceLogsDto> memberTraceLogsDtoList = new ArrayList<UmsMemberTraceLogsDto>();

        //处理模糊查询关键字
        StringBuffer keywordHandle = new StringBuffer();
        keywordHandle.append("%").append(keyword).append("%");

        //日志标题、日志内容查询会员日志
        UmsMemberTraceLogsExample  memberTraceLogsExample = new UmsMemberTraceLogsExample();
        UmsMemberTraceLogsExample.Criteria  memberTraceLogsCriteria1 = memberTraceLogsExample.createCriteria();
        memberTraceLogsCriteria1.andLogTitleLike(keywordHandle.toString());
        List<UmsMemberTraceLogs> memberTraceLogsList = umsMemberTraceLogsMapper.selectByExampleWithBLOBs(memberTraceLogsExample);
        for (UmsMemberTraceLogs e : memberTraceLogsList) {
            UmsMemberTraceLogsDto memberTraceLogsDto = new UmsMemberTraceLogsDto();
            BeanUtils.copyProperties(e, memberTraceLogsDto);
            UmsMember member = umsMemberMapper.selectByPrimaryKey(e.getMemberId());
            if(member != null && !member.getUsername().isEmpty()){
                memberTraceLogsDto.setMemberName(member.getUsername());
            }else{
                memberTraceLogsDto.setMemberName("客户姓名未知");
            }
            UmsAdmin admin = umsAdminMapper.selectByPrimaryKey(e.getAdminId());
            if(admin != null && !admin.getUsername().isEmpty()){
                memberTraceLogsDto.setAdminName(admin.getUsername());
            }else{
                memberTraceLogsDto.setAdminName("业务员姓名未知");
            }
            memberTraceLogsDtoList.add(memberTraceLogsDto);
        }

        //TODO 按客户姓名 和 业务员姓名的模糊查询 暂不实现
        return memberTraceLogsDtoList;
    }

    /**
     * 删除会员跟踪日志
     * @param traceLogsIdList
     * */
    @Override
    @Transactional
    public  int delete(List<Long> traceLogsIdList){
        int result = -1;
        for (int i = 0; i < traceLogsIdList.size(); i++){
            result = umsMemberTraceLogsMapper.deleteByPrimaryKey(traceLogsIdList.get(i));
            if (result < 0){
                return -1;
            }
        }
        return result;
    }

    /**
     * 更新会员跟踪日志
     *
     * @param memberId
     * @param umsMemberTraceLogsList
     */
    @Override
    @Transactional
    public int update(Long memberId, List<UmsMemberTraceLogs> umsMemberTraceLogsList) {
        int result = -1;
        for (int i = 0; i < umsMemberTraceLogsList.size(); i++){
            UmsMemberTraceLogs umsMemberTraceLogs = umsMemberTraceLogsList.get(i);
            result = umsMemberTraceLogsMapper.updateByPrimaryKeySelective(umsMemberTraceLogs);
            if (result < 0){
                return -1;
            }
        }
        return result;
    }


    /**
     * 增加会员跟踪日志(多条)
     *
     * @param memberId
     * @param umsMemberTraceLogsList
     */
    @Override
    @Transactional
    public int add(Long memberId, List<UmsMemberTraceLogs> umsMemberTraceLogsList) {
        int result = -1;
        for (int i = 0; i < umsMemberTraceLogsList.size(); i++){
            UmsMemberTraceLogs umsMemberTraceLogs = umsMemberTraceLogsList.get(i);
            result = umsMemberTraceLogsMapper.insert(umsMemberTraceLogs);
            if (result != 1){
                return -1;
            }
        }
        return 0;
    }

    /**
     * 增加会员跟踪日志(单条)
     *
     * @param memberId
     * @param umsMemberTraceLogs
     */
    @Override
    @Transactional
    public int add(Long memberId,  UmsMemberTraceLogs umsMemberTraceLogs) {
        return umsMemberTraceLogsMapper.insert(umsMemberTraceLogs);
    }

}
