package com.taotao.controller;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;
import com.taotao.service.ParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @Author:VbisoWen
 * @Description:
 * @Date:Create in 21:30 2017/10/1
 * @Modified By:
 */
@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ParamService paramService;

    @RequestMapping("/{itemId}")
    @ResponseBody
    public TbItem selectById(@PathVariable Long itemId) {
        TbItem itemById = itemService.getItemById(itemId);
        return itemById;
    }

    @RequestMapping("/list")
    @ResponseBody
    public EUDataGridResult getItemList(Integer page, Integer rows) {
        EUDataGridResult result = itemService.getItemList(page, rows);
        return result;
    }

    @RequestMapping("/save")
    @ResponseBody
    public TaotaoResult save(TbItem item, String desc) throws Exception {
        itemService.savaItem(item, desc, null);
        return TaotaoResult.ok();
    }

    @RequestMapping("/param/list")
    @ResponseBody
    public EUDataGridResult getParamList(Integer page, Integer rows) {
        EUDataGridResult result = paramService.getParamList(page, rows);
        return result;
    }
}
