package com.macro.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.dto.SmsMarketingActivityProductCategoryRelationDTO;
import com.macro.mall.mapper.PmsProductCategoryMapper;
import com.macro.mall.mapper.SmsMarketingActivityProductCategoryRelationMapper;
import com.macro.mall.model.PmsProductCategory;
import com.macro.mall.model.SmsMarketingActivityProductCategoryRelation;
import com.macro.mall.model.SmsMarketingActivityProductCategoryRelationExample;
import com.macro.mall.service.SmsMarketingActivityProductCategoryService;
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
public class SmsMarketingActivityProductCategoryServiceImpl implements SmsMarketingActivityProductCategoryService {

    @Autowired
    private SmsMarketingActivityProductCategoryRelationMapper  smsMarketingActivityProductCategoryRelationMapper;

    @Autowired
    private PmsProductCategoryMapper pmsProductCategoryMapper;

    /**
     * 添加营销活动关联的商品分类
     *
     * @param marketingActivityProductCategoryRelationList
     */
    @Override
    public int batchAdd(List<SmsMarketingActivityProductCategoryRelation> marketingActivityProductCategoryRelationList) {
        int result = -1;
        for (int i = 0; i < marketingActivityProductCategoryRelationList.size(); i++){
            SmsMarketingActivityProductCategoryRelation marketingActivityProductCategoryRelation =
                    marketingActivityProductCategoryRelationList.get(i);
            result = smsMarketingActivityProductCategoryRelationMapper.insert(marketingActivityProductCategoryRelation);
            if (result <= 0){
                return  -1;
            }
        }
        return 0;
    }

    /**
     * 删除某营销活动的关联商品分类
     *
     * @param ids
     */
    @Override
    public int batchDelete(List<Long> ids) {
        int result = -1;
        for(int i = 0; i < ids.size(); i++){
            result = smsMarketingActivityProductCategoryRelationMapper.deleteByPrimaryKey(ids.get(i));
            if (result <= 0){
                return  -1;
            }
        }
        return 0;
    }

    /**
     * 查询营销活动关联的商品分类
     *
     * @param activityId
     */
    @Override
    public List<SmsMarketingActivityProductCategoryRelationDTO> page(Long activityId, Integer  pageNum, Integer pageSize) {
        //设置分页查询
        PageHelper.startPage(pageNum, pageSize);

        //查询活动关联到的商品分类
        SmsMarketingActivityProductCategoryRelationExample  example = new SmsMarketingActivityProductCategoryRelationExample();
        example.createCriteria().andActivityIdEqualTo(activityId);
        List<SmsMarketingActivityProductCategoryRelation> marketingActivityProductCategoryRelationList =
                smsMarketingActivityProductCategoryRelationMapper.selectByExample(example);

        //设置返回值
        List<SmsMarketingActivityProductCategoryRelationDTO>  marketingActivityProductCategoryRelationDTOList =
                new ArrayList<SmsMarketingActivityProductCategoryRelationDTO>();

        //查询商品分类的详细信息
        for (SmsMarketingActivityProductCategoryRelation e : marketingActivityProductCategoryRelationList) {
            SmsMarketingActivityProductCategoryRelationDTO marketingActivityProductCategoryRelationDTO =
                    new SmsMarketingActivityProductCategoryRelationDTO();
            BeanUtils.copyProperties(e, marketingActivityProductCategoryRelationDTO);
            PmsProductCategory pmsProductCategory = pmsProductCategoryMapper.selectByPrimaryKey(e.getProductCategoryId());
            marketingActivityProductCategoryRelationDTO.setProductCategory(pmsProductCategory);
            marketingActivityProductCategoryRelationDTOList.add(marketingActivityProductCategoryRelationDTO);
        }

        return  marketingActivityProductCategoryRelationDTOList;
    }
}
