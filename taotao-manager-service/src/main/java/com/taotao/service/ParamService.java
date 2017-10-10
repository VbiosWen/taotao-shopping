package com.taotao.service;

import com.taotao.common.pojo.EUDataGridResult;

/**
 * @Author:VbisoWen
 * @Description:
 * @Date:Create in 19:48 2017/10/10
 * @Modified By:
 */
public interface ParamService {

    EUDataGridResult getParamList(int page, int rows);
}
