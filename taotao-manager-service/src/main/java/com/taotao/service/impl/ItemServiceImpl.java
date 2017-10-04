package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
}
