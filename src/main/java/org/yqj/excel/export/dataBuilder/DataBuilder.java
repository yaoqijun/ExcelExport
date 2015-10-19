package org.yqj.excel.export.dataBuilder;

import org.yqj.excel.export.model.YExcel;

import java.util.List;

/**
 * Created by yaoqijun.
 * Date:2015-10-17
 * Email:yaoqj@terminus.io
 * Descirbe:    Excel 数据构建
 */
public interface DataBuilder {

    /**
     * 构建单页的Excel 信息的导出
     * @param filename  excel 名称
     * @param sheetName 单元表名称
     * @param data  数据内容
     * @return
     */
    YExcel builderExcel(String filename, String sheetName, List<Object> data);

}
