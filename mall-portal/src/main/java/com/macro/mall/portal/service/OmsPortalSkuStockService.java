package com.macro.mall.portal.service;

import com.macro.mall.model.OmsOrder;
import com.macro.mall.model.PmsSkuStock;
import com.macro.mall.portal.dto.OmsPortalSkuDto;
import com.macro.mall.portal.vo.PmsPortalProductDetailVo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * sku商品库存管理Service
 * Created by macro on 2018/4/27.
 */
public interface OmsPortalSkuStockService {
    /**
     * 根据产品id和skuCode模糊搜索sku信息
     */
    List<PmsSkuStock> getList(Long pid, String keyword);

    /**
     * 根据商品名称、商品Sku编号、商品货号进行模糊搜索
     */
    List<PmsPortalProductDetailVo> pageProductDetail(Long memberId, String keyword, Integer pageSize, Integer pageNum);

    /**
     * 根据产品id和skuCode模糊搜索sku，及对应的商品信息
     */
    List<OmsPortalSkuDto> getSkuAndProductList(Long pid, String keyword);

    /**
     * 批量更新商品库存信息
     */
    @Transactional
    int update(Long pid, List<PmsSkuStock> skuStockList);

    /**
     * 通过SKU为订单增加商品信息
     */
    @Transactional
    int addOrderProductBySku(OmsOrder omsOrder, List<PmsSkuStock> skuStockList);
}
