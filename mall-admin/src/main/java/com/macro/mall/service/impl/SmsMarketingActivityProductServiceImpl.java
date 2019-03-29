package com.macro.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.dto.SmsMarketingActivityProductRelationDTO;
import com.macro.mall.mapper.PmsProductMapper;
import com.macro.mall.mapper.SmsMarketingActivityProductRelationMapper;
import com.macro.mall.model.PmsProduct;
import com.macro.mall.model.SmsMarketingActivityProductRelation;
import com.macro.mall.model.SmsMarketingActivityProductRelationExample;
import com.macro.mall.service.SmsMarketingActivityProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 营销活动关联商品Service实现类
 * Created by ruiwu.xu on 2018/11/16.
 */
@Service
public class SmsMarketingActivityProductServiceImpl implements SmsMarketingActivityProductService {

    @Autowired
    private SmsMarketingActivityProductRelationMapper smsMarketingActivityProductRelationMapper;
    @Autowired
    private PmsProductMapper  pmsProductMapper;

    /**
     * 添加营销活动活动关的联商品
     *
     * @param marketingActivityProductRelationList
     */
    @Override
    public int batchAdd(List<SmsMarketingActivityProductRelation> marketingActivityProductRelationList) {
        int result = -1;
        for (int i = 0; i < marketingActivityProductRelationList.size(); i++){
            SmsMarketingActivityProductRelation smsMarketingActivityProductRelation =
                    marketingActivityProductRelationList.get(i);
            result = smsMarketingActivityProductRelationMapper.insert(smsMarketingActivityProductRelation);
            if (result <= 0){
                return  -1;
            }
        }
        return 0;
    }

    /**
     * 删除营销活动关联的商品
     *
     * @param ids
     */
    @Override
    public int batchDelete(List<Long> ids) {
        int result = -1;
        for(int i = 0; i < ids.size(); i++){
            result = smsMarketingActivityProductRelationMapper.deleteByPrimaryKey(ids.get(i));
            if (result <= 0){
                return  -1;
            }
        }
        return 0;
    }

    /**
     * 查询营销活动的关联商品
     *
     * @param activityId
     */
    @Override
    public List<SmsMarketingActivityProductRelationDTO> page(Long activityId, Integer  pageNum, Integer pageSize){
        //设置分页查询
        PageHelper.startPage(pageNum, pageSize);

        //查询活动关联到的商品
        SmsMarketingActivityProductRelationExample  example = new SmsMarketingActivityProductRelationExample();
        example.createCriteria().andActivityIdEqualTo(activityId);
        List<SmsMarketingActivityProductRelation> marketingActivityProductRelationList =
                smsMarketingActivityProductRelationMapper.selectByExample(example);

        //查询商品信息
        List<SmsMarketingActivityProductRelationDTO>  marketingActivityProductRelationDTOList =
                new ArrayList<SmsMarketingActivityProductRelationDTO>();

        //设置查询结果
        for (SmsMarketingActivityProductRelation e : marketingActivityProductRelationList) {
            SmsMarketingActivityProductRelationDTO marketingActivityProductRelationDTO =
                    new SmsMarketingActivityProductRelationDTO();
            BeanUtils.copyProperties(e, marketingActivityProductRelationDTO);
            PmsProduct pmsProduct = pmsProductMapper.selectByPrimaryKey(e.getProductId());
            marketingActivityProductRelationDTO.setPmsProduct(pmsProduct);
            marketingActivityProductRelationDTOList.add(marketingActivityProductRelationDTO);
        }

        //返回查询结果
        return marketingActivityProductRelationDTOList;
    }
}
