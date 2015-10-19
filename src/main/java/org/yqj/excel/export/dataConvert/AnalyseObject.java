package org.yqj.excel.export.dataConvert;

import org.yqj.excel.export.model.YCell;
import org.yqj.excel.export.model.YColumn;

import java.util.List;

/**
 * Created by yaoqijun.
 * Date:2015-10-17
 * Email:yaoqj@terminus.io
 * Descirbe:    解析Object 中对应的Fields 的结构类型
 */
public interface AnalyseObject {

    /**
     * 通过Object 解析对应的YColumn的信息(当前的是 默认不包含列合并)
     * @param object 对象
     * @return
     */
    List<YColumn> analyseColumnsFromObject(Object object);

    /**
     * 解析对应的object 对象的数据内容。
     * @param object
     * @return
     */
    List<YCell> analyseObjectData(List<YColumn> yColumns, Object object);

    /**
     * 解析对应的columns 头部信息
     * @param yColumns
     * @return
     */
    List<YCell> analyseTitle(List<YColumn> yColumns);
}
