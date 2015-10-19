package org.yqj.excel.export.dataConvert;

import org.yqj.excel.export.model.YCellArray;

import java.util.List;

/**
 * Created by yaoqijun.
 * Date:2015-10-17
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
public interface DataConvert {

    YCellArray dataConvertCellArray(List<Object> data);

}
