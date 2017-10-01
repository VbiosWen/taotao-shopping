package com.taotao.service.impl;

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
}
