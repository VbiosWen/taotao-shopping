package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.mapper.TbItemParamMapper;
import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamExample;
import com.taotao.pojo.TbItemParamItem;
import com.taotao.service.ItemParamService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Author:VbisoWen
 * @Description:
 * @Date:Create in 19:49 2017/10/10
 * @Modified By:
 */
@Service
public class ItemParamServiceImpl implements ItemParamService {

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

    /**
     * 查询当前分类中是否有规格参数
     *
     * @param id
     * @return
     */
    @Override
    public TaotaoResult getParamByItemCatId(Long id) {
        TbItemParamExample example = new TbItemParamExample();
        TbItemParamExample.Criteria criteria = example.createCriteria();
        criteria.andItemCatIdEqualTo(id);
        List<TbItemParam> tbItemParams = itemParamMapper.selectByExampleWithBLOBs(example);
        if (tbItemParams != null && tbItemParams.size() > 0) {
            return TaotaoResult.ok(tbItemParams.get(0));
        }

        return TaotaoResult.ok();
    }

    @Override
    public TaotaoResult insertItemParam(TbItemParam itemParam) {

        itemParam.setCreated(new Date());
        itemParam.setUpdated(new Date());
        itemParamMapper.insert(itemParam);
        return TaotaoResult.ok();
    }


}
