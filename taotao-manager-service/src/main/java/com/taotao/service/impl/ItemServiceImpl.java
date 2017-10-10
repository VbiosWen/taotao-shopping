package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.util.IDUtils;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Author:VbisoWen
 * @Description: 商品管理service
 * @Date:Create in 22:58 2017/9/30
 * @Modified By:
 */

@Service
public class ItemServiceImpl implements ItemService {

    @Resource
    private TbItemMapper itemMapper;
    @Resource
    private TbItemDescMapper itemDescMapper;

    @Override
    public TbItem getItemById(long id) {
        TbItemExample example = new TbItemExample();

        TbItemExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        List<TbItem> tbItems = itemMapper.selectByExample(example);
        if (tbItems != null && tbItems.size() > 0) {
            return tbItems.get(0);
        }

        return null;
    }

    @Override
    public EUDataGridResult getItemList(int page, int rows) {

        TbItemExample example = new TbItemExample();
        //分页处理
        PageHelper.startPage(page, rows);
        List<TbItem> list = itemMapper.selectByExample(example);
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总数
        PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(list);
        result.setTotal((int) pageInfo.getTotal());
        return result;
    }

    @Override
    public void savaItem(TbItem item, String desc, String itemParams) throws Exception {
        Date date = new Date();
        long id = IDUtils.genItemId();
        item.setId(id);
        item.setStatus((byte) 1);
        item.setCreated(date);
        item.setUpdated(date);
        item.setUpdated(date);
        itemMapper.insert(item);
        //添加商品描述
        TbItemDesc tbItemDesc = new TbItemDesc();
        tbItemDesc.setItemId(id);
        tbItemDesc.setItemDesc(desc);
        tbItemDesc.setCreated(date);
        tbItemDesc.setUpdated(date);
        itemDescMapper.insert(tbItemDesc);
    }
}
