package com.macro.mall.portal.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品模块-商品库存Dto
 * Created by ruiwu.xu on 2019/01/19.
 */
@ApiModel(value= "商品模块-商品库存Dto",description = "商品库存Dto:OmsPortalSkuDto")
@Getter
@Setter
public class OmsPortalSkuDto extends PmsSkuStock {
   // @ApiModelProperty("主键id")
   // private Long id;
    //TODO  下面这种方式不好 建议使用  定义 PmsProduct
    @ApiModelProperty("货号")
    private String productSn;
    @ApiModelProperty("品牌id")
    private Long brandId;
    @ApiModelProperty("品牌名称")
    private String brandName;
    @ApiModelProperty("商品分类id")
    private Long productCategoryId;
    @ApiModelProperty("商品分类名称")
    private String productCategoryName;
    @ApiModelProperty("商品属性分类Id")
    private Long productAttributeCategoryId;
    @ApiModelProperty("运费单模板id")
    private Long feightTemplateId;
    @ApiModelProperty("商品名称")
    private String name;
    @ApiModelProperty("商品标题")
    private String detailTitle;
    @ApiModelProperty("副标题")
    private String subTitle;
    @ApiModelProperty("商品关键字")
    private String keywords;
    @ApiModelProperty("商品描述")
    private String description;
    @ApiModelProperty("商品详细描述")
    private String detailDesc;
    @ApiModelProperty("商品详情网页内容")
    private String detailHtml;
    @ApiModelProperty("移动端网页详情")
    private String detailMobileHtml;
    @ApiModelProperty("商品备注")
    private String note;

    @ApiModelProperty("商品图片OSS存储路径")
    private String pic;
    @ApiModelProperty("画册图片，连产品图片限制为5张，以逗号分割")
    private String albumPics;

    @ApiModelProperty("删除状态：0->未删除；1->已删除")
    private Integer deleteStatus;
    @ApiModelProperty("上架状态：0->下架；1->上架")
    private Integer publishStatus;
    @ApiModelProperty("新品状态:0->不是新品；1->新品")
    private Integer newStatus;
    @ApiModelProperty("推荐状态；0->不推荐；1->推荐")
    private Integer recommandStatus;
    @ApiModelProperty("审核状态：0->未审核；1->审核通过")
    private Integer verifyStatus;
    @ApiModelProperty("是否为预告商品：0->不是；1->是")
    private Integer previewStatus;

    @ApiModelProperty("排序")
    private Integer sort;
    @ApiModelProperty("销量")
    private Integer sale;

    @ApiModelProperty("以逗号分割的产品服务：1->无忧退货；2->快速退款；3->免费包邮")
    private String serviceIds;

    @ApiModelProperty("价格")
    private BigDecimal price;
    @ApiModelProperty("促销价格")
    private BigDecimal promotionPrice;
    @ApiModelProperty("促销开始时间")
    private Date promotionStartTime;
    @ApiModelProperty("促销结束时间")
    private Date promotionEndTime;
    @ApiModelProperty("市场价")
    private BigDecimal originalPrice;

    @ApiModelProperty("活动限购数量")
    private Integer promotionPerLimit;
    @ApiModelProperty("促销类型：0->没有促销使用原价;1->使用促销价；2->使用会员价；3->使用阶梯价格；4->使用满减价格；5->限时购")
    private Integer promotionType;


    @ApiModelProperty("赠送的成长值")
    private Integer giftGrowth;
    @ApiModelProperty("赠送的积分")
    private Integer giftPoint;
    @ApiModelProperty("限制使用的积分数")
    private Integer usePointLimit;

    @ApiModelProperty("库存")
    private Integer stock;
    @ApiModelProperty("库存预警值")
    private Integer lowStock;
    @ApiModelProperty("单位")
    private String unit;
    @ApiModelProperty("商品重量，默认为克")
    private BigDecimal weight;
}


