package com.taotao.controller;

import com.taotao.common.pojo.TreeNode;
import com.taotao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author:VbisoWen
 * @Description: 商品分类管理controller
 * @Date:Create in 18:27 2017/10/3
 * @Modified By:
 */
@Controller
@RequestMapping("/item/cat")
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping("/list")
    @ResponseBody
    public List<TreeNode> getItemCatList(@RequestParam(value = "id", defaultValue = "0") Long parentId) {
        List<TreeNode> itemCatList = itemCatService.getItemCatList(parentId);
        return itemCatList;
    }

}
