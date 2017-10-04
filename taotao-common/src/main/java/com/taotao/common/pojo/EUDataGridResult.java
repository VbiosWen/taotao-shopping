package com.taotao.common.pojo;

import java.util.List;

/**
 * @Author:VbisoWen
 * @Description: 分页工具
 * @Date:Create in 18:22 2017/10/2
 * @Modified By:
 */
public class EUDataGridResult {

    private int total;//总记录数
    private List<?> rows;//总数据量

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
