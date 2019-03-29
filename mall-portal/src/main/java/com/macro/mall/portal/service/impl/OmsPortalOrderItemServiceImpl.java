package com.macro.mall.portal.service.impl;

import com.macro.mall.mapper.PmsProductMapper;
import com.macro.mall.mapper.PmsSkuStockMapper;
import com.macro.mall.model.PmsProduct;
import com.macro.mall.model.SmsCoupon;
import com.macro.mall.portal.dao.PortalProductDao;
import com.macro.mall.portal.domain.PromotionProduct;
import com.macro.mall.portal.service.OmsPortalOrderItemService;
import com.macro.mall.portal.service.common.OmsPortalProductCommon;
import com.macro.mall.portal.service.common.OmsPortalPromotionCommon;
import com.macro.mall.portal.vo.PmsPortalProductDetailVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 订单的商品明细Service实现类
 * Created by macro on 2018/4/27.
 */
@Service
@Slf4j
public class OmsPortalOrderItemServiceImpl implements OmsPortalOrderItemService {
    @Autowired
    private PmsSkuStockMapper skuStockMapper;
    @Autowired
    private PmsProductMapper productMapper;
    @Autowired
    private OmsPortalPromotionCommon promotionCommon;
    @Autowired
    private OmsPortalProductCommon productCommon;
    @Autowired
    private PortalProductDao portalProductDao;

    //根据根据商品id及客户ID获取商品详情，包含sku，属性，参与优惠活动，对应客户持有优惠券 信息
    @Override
    public PromotionProduct getProductDetail(Long productId, Long memberId) {
//        //根据商品ID 获取商品详情
//        PmsProduct product = productMapper.selectByPrimaryKey(productId);
//        //设置查询条件
//        Set<PmsProduct> products = new HashSet<>();
//        products.add(product);
//        List<PmsPortalProductDetailVo>  productDetailVoList = productCommon.productDetail(products, memberId);
//        if(productDetailVoList == null  || productDetailVoList.isEmpty()){
//            return null;
//        }
        //获取客户持有的商品的优惠劵信息
        List<SmsCoupon>  couponList =  promotionCommon.searchAppointCoupon(memberId, productId);
        PromotionProduct promotionProduct= portalProductDao.getPromotionProduct(productId);
        promotionProduct.setCouponList(couponList);
        //返回查询结果
        return promotionProduct;
// TODO 调用公共部分
//       定义返回值变量
//        PmsPortalProductDetailVo productDetailVo = new PmsPortalProductDetailVo();
//
//        //商品库获取商品信息
//        PmsProduct product = productMapper.selectByPrimaryKey(productId);
//        if(product == null){
//            return null;
//        }
//        BeanUtils.copyProperties(product, productDetailVo);
//
//        //获取商品的库存信息
//        PmsSkuStockExample skuStockExample1 = new PmsSkuStockExample();
//        skuStockExample1.createCriteria().andProductIdEqualTo(productId);
//        List<PmsSkuStock>  skuStocks = skuStockMapper.selectByExample(skuStockExample1);
//        if (skuStocks == null ||skuStocks.isEmpty()) {
//            log.error("获取商品的库存信息失败");
//            return null;
//        }
//
//        productDetailVo.setSkuStock(skuStocks.get(0));
//
//        //获取该商品客户参与的优惠活动信息(营销活动、优惠劵)
//        //获取客户的单个商品的优惠劵信息
//        List<SmsCoupon> couponList= promotionCommon.searchAppointCoupon(memberId, productId) ;
//        if(couponList != null){
//            productDetailVo.setCouponList(couponList);
//        }
//        //获取客户的单个商品的营销活动信息
//        List<OmsPortalMarketingActivityDo>  marketingActivityDtoList = promotionCommon.searchAppointMarketingActivity(productId);
//        if(marketingActivityDtoList != null){
//            productDetailVo.setMarketingActivityDtoList(marketingActivityDtoList);
//        }
//
//       return productDetailVo;
    }
}
