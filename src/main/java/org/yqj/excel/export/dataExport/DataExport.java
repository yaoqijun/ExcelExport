package org.yqj.excel.export.dataExport;

import org.yqj.excel.export.model.YExcel;

import java.io.OutputStream;

/**
 * Created by yaoqijun.
 * Date:2015-10-17
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
public interface DataExport {

    /**
     * 将导出的流信息 输入到OutputStream 中
     * @param yCellArray    输出数据
     * @param outputStream  输出文件流
     * @return
     */
    Boolean exportExcelData(YExcel yExcel, OutputStream outputStream);

}
