package com.macro.mall.dto;

import com.macro.mall.model.UmsMember;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@ApiModel("接收更新会员信息")
@Data
public class UmsMemberDTO extends UmsMember {

    @ApiModelProperty("标签ids")
    private List<Long> tagIds;

}
