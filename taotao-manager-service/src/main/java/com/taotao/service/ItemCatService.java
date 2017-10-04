package com.taotao.service;

import com.taotao.common.pojo.TreeNode;

import java.util.List;

/**
 * @Author:VbisoWen
 * @Description:
 * @Date:Create in 18:20 2017/10/3
 * @Modified By:
 */
public interface ItemCatService {

    public List<TreeNode> getItemCatList(long parentId);
}
