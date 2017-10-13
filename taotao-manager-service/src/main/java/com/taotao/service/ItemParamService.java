package com.taotao.service;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItemParam;

/**
 * @Author:VbisoWen
 * @Description:
 * @Date:Create in 19:48 2017/10/10
 * @Modified By:
 */
public interface ItemParamService {

    EUDataGridResult getParamList(int page, int rows);

    TaotaoResult getParamByItemCatId(Long id);

    TaotaoResult insertItemParam(TbItemParam itemParam);

}
