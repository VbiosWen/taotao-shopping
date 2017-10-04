package com.taotao.service;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.pojo.TbItem;

/**
 * @Author:VbisoWen
 * @Description:
 * @Date:Create in 22:57 2017/9/30
 * @Modified By:
 */
public interface ItemService {

    TbItem getItemById(long id);

    EUDataGridResult getItemList(int page, int rows);
}