package org.yqj.excel.export.model;

import lombok.Data;

import java.util.List;

/**
 * Created by yaoqijun.
 * Date:2015-10-17
 * Email:yaoqj@terminus.io
 * Descirbe:    用户导出Excel 相关的属性
 */
@Data
public class YExcel {

    public YExcel(){}

    public YExcel(String fileName, List<YSheet> sheets){
        this.fileName = fileName;
        this.sheets = sheets;
    }

    private String fileName;    //导出Excel 文件名称

    private List<YSheet> sheets;    //导出文件Sheet
}
