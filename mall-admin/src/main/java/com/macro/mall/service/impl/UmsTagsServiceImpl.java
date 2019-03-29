package com.macro.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.dao.UmsMemberTagsRelationDao;
import com.macro.mall.dto.UmsMemberTagsDTO;
import com.macro.mall.mapper.UmsMemberTagsMapper;
import com.macro.mall.mapper.UmsTagsMapper;
import com.macro.mall.model.UmsMemberTags;
import com.macro.mall.model.UmsMemberTagsExample;
import com.macro.mall.model.UmsTags;
import com.macro.mall.model.UmsTagsExample;
import com.macro.mall.service.UmsTagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 会员标签库管理Service实现类
 * Created by ruiwu.xu on 2019/01/08.
 */
@Service
public class UmsTagsServiceImpl implements UmsTagsService {
    @Autowired
    private UmsTagsMapper umsTagsMapper;

    @Autowired
    private UmsMemberTagsMapper umsMemberTagsMapper;

    @Autowired
    private UmsMemberTagsRelationDao umsMemberTagsRelationDao;

    /**
     * 添加分类标签
     *
     * @param umsTags
     */
    @Override
    public int add(UmsTags umsTags) {
        return umsTagsMapper.insert(umsTags);
    }

    /**
     * 修改分类标签
     *
     * @param id
     * @param umsTags
     */
    @Override
    public int update(Long id, UmsTags umsTags) {
        return umsTagsMapper.updateByPrimaryKey(umsTags);
    }

    /**
     * 删除分类标签
     *
     * @param id
     */
    @Override
    public int delete(Long id) {
        return umsTagsMapper.deleteByPrimaryKey(id);
    }

    /**
     * 获取标签库标签列表
     */
    @Override
    public List<UmsTags> list() {
        UmsTagsExample example = null;
        return umsTagsMapper.selectByExample(example);
    }

    /**
     * 根据ID获取标签信息
     *
     * @param id
     */
    @Override
    public UmsTags selectById(long id) {
        return umsTagsMapper.selectByPrimaryKey(id);
    }

    /**
     * 获取标签库标签列表
     */
    @Override
    public List<UmsTags> page(String tagName, Integer pageNum, Integer pageSize) {
        //设置分页查询
        PageHelper.startPage(pageNum, pageSize);
        //处理查询关键字
        StringBuffer tagNameHandle = new StringBuffer();
        tagNameHandle.append("%").append(tagName).append("%");
        //查询符合条件的数据
        UmsTagsExample example = new UmsTagsExample();
        example.createCriteria().andTagNameLike(tagNameHandle.toString());
        //返回符合条件的查询结果
        return umsTagsMapper.selectByExample(example);
    }

    /**
     * 增加会员的分类标签(批量)
     *
     * @param memberId
     * @param listMemberTags 会员分类标签列表
     */
    @Override
    @Transactional
    public int addMemberTagsList(Long memberId, List<UmsMemberTags> listMemberTags) {
        for( int i = 0; i < listMemberTags.size(); i++){
            UmsMemberTags umsMemberTags = listMemberTags.get(i);
            int result = umsMemberTagsMapper.insert(umsMemberTags);
            if (result != 1){
                return -1;
            }
        }
        return 0;
    }

    /**
     * 删除会员的分类标签列表(批量)
     * @param memberId  会员ID
     * @param tagIds   标签ID列表e
     * */
    @Override
    @Transactional
    public int deleteMemberTagsList(Long memberId, List<Long> tagIds){

        for( int i = 0; i < tagIds.size(); i++){
            UmsMemberTagsExample example = new UmsMemberTagsExample();
            UmsMemberTagsExample.Criteria  criteria = example.createCriteria();
            criteria.andTagsIdEqualTo(tagIds.get(i));
            criteria.andMemberIdEqualTo(memberId);
            int result = umsMemberTagsMapper.deleteByExample(example);
            if (result != 1){
                return -1;
            }
        }
        return 0;
    }

    /**
     * 获取会员的分类标签列表
     *
     * @param memberId
     */
    @Override
    public UmsMemberTagsDTO listMemberTags(Long memberId) {
        UmsMemberTagsDTO umsMemberTagsDO = new UmsMemberTagsDTO();
        umsMemberTagsDO.setMemberId(memberId);

        UmsMemberTagsExample  example = new UmsMemberTagsExample();
        example.createCriteria().andIdEqualTo(memberId);
        umsMemberTagsDO.setUmsTagsList( umsMemberTagsRelationDao.getTagsList(memberId));
        return  umsMemberTagsDO;
    }
}
