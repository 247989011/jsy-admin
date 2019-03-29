package com.macro.mall.dto;

import com.macro.mall.model.UmsTags;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;


@ApiModel("会员的分类标签")
@Data
public class UmsMemberTagsDTO {
    @ApiModelProperty("会员Id")
    private Long memberId;

    @ApiModelProperty("会员的标签列表")
    private List<UmsTags> umsTagsList;
}
