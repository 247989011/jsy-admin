package com.macro.mall.vo;

import com.macro.mall.model.UmsMember;
import com.macro.mall.model.UmsTags;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@ApiModel("会员Vo")
@Data
public class UmsMemberVo extends UmsMember {

    @ApiModelProperty("会员标签列表")
    private List<UmsTags> tagList;

    @ApiModelProperty("会员等级")
    private String memberLevel;

    @ApiModelProperty("所属业务员")
    private String umsAdmin;

}
