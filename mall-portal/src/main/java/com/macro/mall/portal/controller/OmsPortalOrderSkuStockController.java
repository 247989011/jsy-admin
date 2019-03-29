package com.macro.mall.portal.controller;

import com.macro.mall.portal.domain.CommonResult;
import com.macro.mall.portal.domain.MemberDetails;
import com.macro.mall.portal.vo.PmsPortalProductDetailVo;
import com.macro.mall.portal.service.OmsPortalSkuStockService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.security.Principal;
import java.util.List;

/**
 * sku库存Controller
 * Created by ruiwu.xu on 2019/02/24.
 */
@Api(tags = "订单模块-sku商品添加", description = "sku商品添加:OmsPortalOrderSkuStockController",position = 38)
@Controller
@RequestMapping("/order/sku")
public class OmsPortalOrderSkuStockController {
    @Autowired
    private OmsPortalSkuStockService skuStockService;

    @ApiOperation("根据商品名称、商品Sku编号、商品货号进行模糊搜索")
    @ApiResponses({@ApiResponse(code = 201, response = PmsPortalProductDetailVo.class,
            message="状态200的data格式说明：data返回值为列表")})
    @RequestMapping(value = "/detail/page", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult pageProduct(@RequestParam(value = "keyword",required = false) String keyword,
                                   Principal principal,
                                   @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                   @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        Long memberId = ((MemberDetails) ((UsernamePasswordAuthenticationToken) principal).getPrincipal()).
                getUmsMember().getId();
        List<PmsPortalProductDetailVo> portalProductDetailDtoList = skuStockService.
                pageProductDetail(memberId, keyword, pageSize, pageNum);
        return new CommonResult().pageSuccess(portalProductDetailDtoList);
    }

    @ApiOperation("通过sku方式增加订单商品")
    @ApiIgnore
    @RequestMapping(value ="/order/item/add",method = RequestMethod.POST)
    @ResponseBody
    public Object addOrderProductBySku(@RequestBody OmsOrder order, @RequestBody List<PmsSkuStock> skuStockList){
        int count = skuStockService.addOrderProductBySku(order,skuStockList);
        if(count>0){
            return new CommonResult().success(count);
        }else{
            return new CommonResult().failed();
        }
    }

    @ApiOperation("根据商品编号及编号模糊搜索sku库存及其对应的商品信息")
    @ApiIgnore
    @ApiResponses({@ApiResponse(code = 201, response = PmsSkuStock.class,
            message="状态200的data格式说明：data返回值为列表")})
    @RequestMapping(value = "list/{pid}", method = RequestMethod.GET)
    @ResponseBody
    @Deprecated
    public CommonResult getList(@PathVariable Long pid, @RequestParam(value = "keyword",required = false) String keyword) {
        List<PmsSkuStock> skuStockList = skuStockService.getList(pid, keyword);
        return new CommonResult().success(skuStockList);
    }
}
