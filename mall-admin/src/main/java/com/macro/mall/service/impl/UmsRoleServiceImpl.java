package com.macro.mall.service.impl;

import com.macro.mall.dao.UmsRolePermissionRelationDao;
import com.macro.mall.mapper.UmsPermissionMapper;
import com.macro.mall.mapper.UmsRoleMapper;
import com.macro.mall.mapper.UmsRolePermissionRelationMapper;
import com.macro.mall.model.*;
import com.macro.mall.service.UmsRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 后台角色管理Service实现类
 * Created by macro on 2018/9/30.
 */
@Service
public class UmsRoleServiceImpl implements UmsRoleService {
    @Autowired
    private UmsRoleMapper roleMapper;
    @Autowired
    private UmsRolePermissionRelationMapper rolePermissionRelationMapper;
    @Autowired
    private UmsRolePermissionRelationDao rolePermissionRelationDao;
    @Autowired
    private UmsPermissionMapper umsPermissionMapper;

    @Override
    public int create(UmsRole role) {
        role.setCreateTime(new Date());
//        role.setStatus(1);
        role.setAdminCount(0);
//        role.setSort(0);
        return roleMapper.insert(role);
    }

    @Override
    public int update(Long id, UmsRole role) {
        role.setId(id);
        return roleMapper.updateByPrimaryKey(role);
    }

    @Override
    public int batchDelete(List<Long> ids) {
        UmsRoleExample example = new UmsRoleExample();
        example.createCriteria().andIdIn(ids);
        return roleMapper.deleteByExample(example);
    }

    @Override
    public List<UmsPermission> getPermissionList(Long roleId) {
        return rolePermissionRelationDao.getPermissionList(roleId);
    }

    @Override
    public int updatePermission(Long roleId, List<Long> permissionIds) {
        //先删除原有关系
        UmsRolePermissionRelationExample example=new UmsRolePermissionRelationExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        rolePermissionRelationMapper.deleteByExample(example);
        //批量插入新关系
        List<UmsRolePermissionRelation> relationList = new ArrayList<>();
        for (Long permissionId : permissionIds) {
            UmsRolePermissionRelation relation = new UmsRolePermissionRelation();
            relation.setRoleId(roleId);
            relation.setPermissionId(permissionId);
            relationList.add(relation);
        }
        return rolePermissionRelationDao.insertList(relationList);
    }

    @Override
    public List<UmsRole> list() {
        return roleMapper.selectByExample(new UmsRoleExample());
    }

    @Override
    public UmsRole get(Long id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delete(Long id) {
        //TODO 删除角色关联的用户，权限表数据
        return roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<UmsPermission> findMenuByRoleId(Long roleId) {
        UmsRolePermissionRelationExample example = new UmsRolePermissionRelationExample();
        example.createCriteria()
                .andRoleIdEqualTo(roleId);
        List<UmsRolePermissionRelation> umsRolePermissionRelations = rolePermissionRelationMapper.selectByExample(example);
        List<Long> ids = new ArrayList<Long>();
        for (UmsRolePermissionRelation rolePermissionRelation : umsRolePermissionRelations) {
            ids.add(rolePermissionRelation.getPermissionId());
        }
        if (ids.isEmpty()) {
            return null;
        }
        UmsPermissionExample permissionExample = new UmsPermissionExample();
        permissionExample.createCriteria()
                .andIdIn(ids);
        List<UmsPermission> permissions = umsPermissionMapper.selectByExample(permissionExample);
        return permissions;
    }
}
