package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.mapper.TbItemParamMapper;
import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamExample;
import com.taotao.service.ParamService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author:VbisoWen
 * @Description:
 * @Date:Create in 19:49 2017/10/10
 * @Modified By:
 */
@Service
public class ParamServiceImpl implements ParamService {

    @Resource
    private TbItemParamMapper itemParamMapper;
    @Resource
    private TbItemCatMapper itemCatMapper;


    @Override
    public EUDataGridResult getParamList(int page, int rows) {
        TbItemParamExample example = new TbItemParamExample();
        //分页处理
        PageHelper.startPage(page, rows);
        List<TbItemParam> list = itemParamMapper.selectByExampleWithBLOBs(example);
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总数
        PageInfo<TbItemParam> pageInfo = new PageInfo<TbItemParam>(list);
        result.setTotal((int) pageInfo.getTotal());
        return result;
    }
}
