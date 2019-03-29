package com.macro.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.dao.UmsMemberTagsRelationDao;
import com.macro.mall.dto.UmsMemberDTO;
import com.macro.mall.mapper.UmsAdminMapper;
import com.macro.mall.mapper.UmsMemberLevelMapper;
import com.macro.mall.mapper.UmsMemberMapper;
import com.macro.mall.mapper.UmsMemberTagsMapper;
import com.macro.mall.model.*;
import com.macro.mall.service.UmsMemberService;
import com.macro.mall.vo.UmsMemberVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 会员Service实现类
 * Created by macro on 2018/4/26.
 */
@Service
@Slf4j
public class UmsMemberServiceImpl implements UmsMemberService {

    @Autowired
    private UmsMemberMapper umsMemberMapper;
    @Autowired
    private UmsMemberTagsRelationDao umsMemberTagsRelationDao;
    @Autowired
    private UmsMemberTagsMapper umsMemberTagsMapper;

    @Autowired
    private UmsMemberLevelMapper umsMemberLevelMapper;
    @Autowired
    private UmsAdminMapper umsAdminMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    /**
     * 获取符合条件的会员信息
     *  @param name
     * @param pageSize
     * @param pageNum
     */
    @Override
    public List<UmsMemberVo> list(String name, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        UmsMemberExample umsMemberExample = new UmsMemberExample();
        UmsMemberExample.Criteria criteria  = umsMemberExample.createCriteria();
        if (!StringUtils.isEmpty(name)) {
            criteria.andUsernameLike("%" + name + "%");
            umsMemberExample.or(umsMemberExample.createCriteria().andNicknameLike("%" + name + "%"));
            umsMemberExample.or(umsMemberExample.createCriteria().andPhoneLike("%" + name + "%"));
        }
        List<UmsMember> members = umsMemberMapper.selectByExample(umsMemberExample);
        List<UmsMemberVo> umsMemberVos = new ArrayList<UmsMemberVo>();
        for (UmsMember member : members) {
            UmsMemberVo memberVo = new UmsMemberVo();
            BeanUtils.copyProperties(member,memberVo);
            if (member.getMemberLevelId() != null) {
                UmsMemberLevel memberLevel = umsMemberLevelMapper.selectByPrimaryKey(member.getMemberLevelId());
                if (memberLevel == null){
                    memberVo.setMemberLevel("未设置等级");
                }else{
                    memberVo.setMemberLevel(memberLevel.getName());
                }
            }
            if (member.getUmsAdminId() != null) {
                UmsAdmin admin = umsAdminMapper.selectByPrimaryKey(member.getUmsAdminId());
                if(admin  != null){
                    memberVo.setUmsAdmin(admin.getNickName());
                }
            }
            List<UmsTags> umsTags = umsMemberTagsRelationDao.getTagsList(member.getId());
            if( umsTags != null){
                memberVo.setTagList(umsTags);
            }

            umsMemberVos.add(memberVo);
        }

        return umsMemberVos;
    }

    /**
     * 更新会员信息
     *
     * @param memberId
     * @param memberDTO
     */
    @Override
    @Transactional
    public int update(Long memberId, UmsMemberDTO memberDTO) {
        UmsMember member = umsMemberMapper.selectByPrimaryKey(memberId);
        if (StringUtils.isNotEmpty(memberDTO.getPassword()) && member.getPassword() != memberDTO.getPassword()) {
            //不相等，则密码有修改过。会员密码前端不加密
            memberDTO.setPassword(passwordEncoder.encode(memberDTO.getPassword()));
        }
        BeanUtils.copyProperties(memberDTO,member);
        //验证是否为重复的会员
        boolean b = checkMemberUnique(member);
        if(!b){
            return -1;
        }
        int i = umsMemberMapper.updateByPrimaryKey(member);
        if(i != 1){
            return -1;
        }
        UmsMemberTagsExample memberTagsExample = new UmsMemberTagsExample();
        memberTagsExample.createCriteria().andMemberIdEqualTo(member.getId());
        umsMemberTagsMapper.deleteByExample(memberTagsExample);
        if (memberDTO.getTagIds() != null) {
            memberDTO.getTagIds().forEach(tagsId ->{
                UmsMemberTags memberTags = new UmsMemberTags();
                memberTags.setMemberId(member.getId());
                memberTags.setTagsId(tagsId);
                umsMemberTagsMapper.insertSelective(memberTags);
            });
        }
        return 1;
    }

    /**
     * 批量增加会员
     *
     * @param listMember
     */
    @Override
    @Transactional
    public int add(List<UmsMember> listMember) {
        int result = -1;
        for (int i = 0; i < listMember.size(); i++){
            UmsMember umsMember =listMember.get(i);
            if (StringUtils.isEmpty(umsMember.getPassword())) {
                umsMember.setPassword(passwordEncoder.encode("123456"));
            }else{
                umsMember.setPassword(passwordEncoder.encode(umsMember.getPassword()));
            }
            log.info("umsMember = {}", umsMember);
            //验证是否为重复的会员
            boolean b = checkMemberUnique(umsMember);
            if(!b){
                return -1;
            }
            log.debug("开始登记会员信息...");
             //登记新会员信息
            result = umsMemberMapper.insert(umsMember);
            if(result < 0){
                return  -1;
            }
            log.debug("会员登记成功.");
        }

        return listMember.size();
    }

    /**
     * 增加会员(单个)
     *
     * @param member
     */
    @Override
    public int add(UmsMember member) {
        if (StringUtils.isEmpty(member.getPassword())) {
            member.setPassword(passwordEncoder.encode("123456"));
        }else{
            member.setPassword(passwordEncoder.encode(member.getPassword()));
        }
        boolean b = checkMemberUnique(member);
        if(!b){
            return -1;
        }
        //登记会员信息
        return umsMemberMapper.insert(member);
    }

    @Override
    public UmsMemberVo selectUmsMemberVoById(Long id) {
        UmsMember member = umsMemberMapper.selectByPrimaryKey(id);
        List<UmsTags> umsTags = umsMemberTagsRelationDao.getTagsList(id);
        UmsMemberVo memberVo = new UmsMemberVo();
        BeanUtils.copyProperties(member, memberVo);
        memberVo.setTagList(umsTags);

        return memberVo;
    }

    @Override
    public List<UmsMemberVo> selectUmsMemberVoByAdminId(Long adminId) {
        //定义返回值
        List<UmsMemberVo> memberVoList = new ArrayList<UmsMemberVo>();

        //TODO 暂不考虑性能
        UmsMemberExample example = new UmsMemberExample();
        example.createCriteria().andUmsAdminIdEqualTo(adminId);
        List<UmsMember>  memberList = umsMemberMapper.selectByExample(example);
        for (UmsMember e : memberList) {
            UmsMemberVo memberVo = new UmsMemberVo();
            List<UmsTags> umsTags = umsMemberTagsRelationDao.getTagsList(e.getId());
            BeanUtils.copyProperties(e, memberVo);
            memberVo.setTagList(umsTags);
            memberVoList.add(memberVo);
        }

        //返回查询结果
        return memberVoList;
    }

    @Override
    public int delete(Long id) {
        UmsMemberTagsExample memberTagsExample = new UmsMemberTagsExample();
        memberTagsExample.createCriteria()
                .andMemberIdEqualTo(id);
        umsMemberTagsMapper.deleteByExample(memberTagsExample);
        return umsMemberMapper.deleteByPrimaryKey(id);
    }

    //验证会员唯一性
    private boolean checkMemberUnique(UmsMember member){
        UmsMemberExample example = new UmsMemberExample();
        UmsMemberExample.Criteria criteria1 = example.createCriteria();
        UmsMemberExample.Criteria criteria2 = example.createCriteria();

        //需要排除自身
        if (member.getId() != null && member.getId() != 0) {
            criteria1.andIdNotEqualTo(member.getId());
        }
        criteria1.andPhoneEqualTo(member.getPhone());
        example.or(criteria2.andEmailEqualTo(member.getEmail()));
        if (member.getId() != null)
        criteria2.andIdNotEqualTo(member.getId());

        if(umsMemberMapper.countByExample(example) > 0){
            return false;
        }
        return  true;
    }
}
