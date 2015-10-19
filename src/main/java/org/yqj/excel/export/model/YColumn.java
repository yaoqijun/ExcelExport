package org.yqj.excel.export.model;

import lombok.Data;

import java.lang.reflect.Field;

/**
 * Created by yaoqijun.
 * Date:2015-10-17
 * Email:yaoqj@terminus.io
 * Descirbe:列字段内容
 */
@Data
public class YColumn {

    private Field field;    //obj获取 列信息的值

    private Column column;  //列注解信息

    public YColumn(){}

    public YColumn(Field field, Column column){
        this.field = field;
        this.column = column;
    }
}
