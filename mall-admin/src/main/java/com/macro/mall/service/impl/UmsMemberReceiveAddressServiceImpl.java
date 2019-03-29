package com.macro.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.mapper.UmsMemberReceiveAddressMapper;
import com.macro.mall.model.UmsMemberReceiveAddress;
import com.macro.mall.model.UmsMemberReceiveAddressExample;
import com.macro.mall.service.UmsMemberReceiveAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 用户地址管理Service实现类
 * Created by ruiwu.xu on 2019/01/23.
 */
@Service
public class UmsMemberReceiveAddressServiceImpl implements UmsMemberReceiveAddressService {
    @Autowired
    private UmsMemberReceiveAddressMapper addressMapper;

    @Override
    public int add(UmsMemberReceiveAddress address) {
        return addressMapper.insert(address);
    }

    @Override
    public int delete(Long id) {
        return addressMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Long id, UmsMemberReceiveAddress address) {
        address.setId(null);
        UmsMemberReceiveAddressExample example = new UmsMemberReceiveAddressExample();
        example.createCriteria().andIdEqualTo(id);
        return addressMapper.updateByExampleSelective(address,example);
    }

    @Override
    public List<UmsMemberReceiveAddress> list(Long memberId) {
        UmsMemberReceiveAddressExample example = new UmsMemberReceiveAddressExample();
        example.createCriteria().andMemberIdEqualTo(memberId);
        return addressMapper.selectByExample(example);
    }

    @Override
    public UmsMemberReceiveAddress getItem(Long id) {
        UmsMemberReceiveAddressExample example = new UmsMemberReceiveAddressExample();
        example.createCriteria().andIdEqualTo(id);
        List<UmsMemberReceiveAddress> addressList = addressMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(addressList)){
            return addressList.get(0);
        }
        return null;
    }

    /**
     * 分页查询系统所有的收货地址
     *
     * @param keyword
     */
    @Override
    public List<UmsMemberReceiveAddress> page(String keyword, Integer pageSize,Integer pageNum) {
        //设置分页
        PageHelper.startPage(pageNum, pageSize);
        //处理查询关键字
        StringBuffer keywordHandle = new StringBuffer();
        keywordHandle.append("%").append(keyword).append("%");
        //设置查询条件
        UmsMemberReceiveAddressExample addressExample = new UmsMemberReceiveAddressExample();
        UmsMemberReceiveAddressExample.Criteria criteria1 = addressExample.createCriteria();
        UmsMemberReceiveAddressExample.Criteria criteria2 = addressExample.createCriteria();
        criteria1.andFirstNameLike(keywordHandle.toString());
        addressExample.or(criteria2.andLastNameLike(keywordHandle.toString()));
        //返回查询结果
        return addressMapper.selectByExample(addressExample);
    }
}
