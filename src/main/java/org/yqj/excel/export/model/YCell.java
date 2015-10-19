package org.yqj.excel.export.model;

import lombok.Data;

/**
 * Created by yaoqijun.
 * Date:2015-10-17
 * Email:yaoqj@terminus.io
 * Descirbe:导出表格的单位元素
 */
@Data
public class YCell {

    private String value;   //表格对应的值

    private String type;    //表哥类型

    private String style;   //表格的样式

    public YCell(){}

    public YCell(String value, String type, String style){
        this.value = value;
        this.type = type;
        this.style = style;
    }
}
