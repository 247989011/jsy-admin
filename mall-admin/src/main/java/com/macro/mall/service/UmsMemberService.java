package com.macro.mall.service;

import com.macro.mall.dto.UmsMemberDTO;
import com.macro.mall.model.UmsMember;
import com.macro.mall.vo.UmsMemberVo;

import java.util.List;

/**
 * 会员信息Service
 * Created by macro on 2018/4/26.
 */
public interface UmsMemberService {
    /**
     * 获取符合条件的会员信息
     */
    List<UmsMemberVo> list(String name, Integer pageSize, Integer pageNum);

    /**
     * 更新会员信息
     * */
    int update(Long memberId, UmsMemberDTO memberDTO);

    /**
     * 增加会员(批量)
     * */
    int add(List<UmsMember> listMember);

    /**
     * 增加会员(单个)
     * */
    int add(UmsMember member);

    /**
     * 通过客户ID查询客户信息
     *@param id
     * @return
     */
    UmsMemberVo selectUmsMemberVoById(Long id);

    List<UmsMemberVo>  selectUmsMemberVoByAdminId(Long adminId);

    int delete(Long id);
}
