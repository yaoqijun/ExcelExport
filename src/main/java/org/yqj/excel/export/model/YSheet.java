package org.yqj.excel.export.model;

import lombok.Data;

import java.util.List;

/**
 * Created by yaoqijun.
 * Date:2015-10-17
 * Email:yaoqj@terminus.io
 * Descirbe:    表的数据内容
 */
@Data
public class YSheet {

    public YSheet(){}

    public YSheet(String sheetName, List<Object> data){
        this.sheetName = sheetName;
        this.data = data;
    }

    private String sheetName;

    private YCellArray yCellArray;

    private List<Object> data;
}
