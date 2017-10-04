package com.taotao.service.impl;

import com.taotao.common.pojo.TreeNode;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:VbisoWen
 * @Description:
 * @Date:Create in 18:21 2017/10/3
 * @Modified By:
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private TbItemCatMapper itemCatMapper;

    @Override
    public List<TreeNode> getItemCatList(long parentId) {
        TbItemCatExample itemCatExample = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = itemCatExample.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        List<TbItemCat> results = itemCatMapper.selectByExample(itemCatExample);
        List<TreeNode> list = new ArrayList<TreeNode>();
        for (TbItemCat tc : results) {
            TreeNode treeNode = new TreeNode(tc.getId(), tc.getName(), tc.getIsParent() ? "closed" : "open");
            list.add(treeNode);
        }


        return list;
    }
}
