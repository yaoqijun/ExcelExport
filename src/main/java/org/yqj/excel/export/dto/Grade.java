package org.yqj.excel.export.dto;

import lombok.Data;
import org.yqj.excel.export.model.Column;

/**
 * Created by yaoqijun.
 * Date:2015-10-17
 * Email:yaoqj@terminus.io
 * Descirbe:    成绩信息
 */
@Data
public class Grade {

    public Grade(){}

    public Grade(Integer chinese, Integer math, Integer english){
        this.chinese = chinese;
        this.math = math;
        this.english = english;
    }

    @Column(name = "国文",type = 1)
    private Integer chinese;

    @Column(name = "数学",type = 1)
    private Integer math;

    @Column(name = "英语",type = 1)
    private Integer english;

}
