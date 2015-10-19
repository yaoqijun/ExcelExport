package org.yqj.excel.export.dataBuilder;

import com.google.common.collect.Lists;
import org.yqj.excel.export.model.YExcel;
import org.yqj.excel.export.model.YSheet;

import java.util.List;

/**
 * Created by yaoqijun.
 * Date:2015-10-17
 * Email:yaoqj@terminus.io
 * Descirbe:    数据构建的实现
 */
public class DataBuilderImpl implements DataBuilder{
    @Override
    public YExcel builderExcel(String filename, String sheetName, List<Object> data) {

        //create Sheet
        YSheet sheet = new YSheet(sheetName, data);
        List<YSheet> sheets = Lists.newArrayList(sheet);

        //create excel
        YExcel yExcel = new YExcel(filename, sheets);
        return yExcel;
    }
}
