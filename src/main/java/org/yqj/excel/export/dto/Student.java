package org.yqj.excel.export.dto;

import lombok.Data;
import org.yqj.excel.export.model.Column;

/**
 * Created by yaoqijun.
 * Date:2015-10-17
 * Email:yaoqj@terminus.io
 * Descirbe:    学生信息
 */
@Data
public class Student {

    public Student(){}

    @Column(name = "姓名",type = 1)
    private String name;

    @Column(name = "年龄",type = 1)
    private Integer age;

    @Column(name = "成绩",type = 1)
    private Grade grade;
}
