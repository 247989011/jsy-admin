package com.macro.mall.dao;

import com.macro.mall.model.UmsPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 后台用户与角色管理自定义Dao
 * Created by macro on 2018/10/8.
 */
public interface SmsMarketingActivityProductRelationDao {

    /**
     * 获取营销活动
     */
    List<UmsPermission> getPermissionList(@Param("adminId") Long adminId);

}
