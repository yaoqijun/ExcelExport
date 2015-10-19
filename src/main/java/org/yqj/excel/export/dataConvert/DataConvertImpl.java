package org.yqj.excel.export.dataConvert;

import org.yqj.excel.export.model.YCell;
import org.yqj.excel.export.model.YCellArray;
import org.yqj.excel.export.model.YColumn;

import java.util.List;

/**
 * Created by yaoqijun.
 * Date:2015-10-17
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
public class DataConvertImpl implements DataConvert {

    List<YColumn> yColumns;

    AnalyseObject analyseObject;

    YCellArrayManager yCellArrayManager;

    public DataConvertImpl(AnalyseObject analyseObject){
        this.analyseObject = analyseObject;
        this.yCellArrayManager = new YCellArrayManager();
    }


    @Override
    public YCellArray dataConvertCellArray(List<Object> data) {
        if(data==null || data.size() == 0){
            return yCellArrayManager.getYCellArray();
        }

        //解析内容
        yColumns = analyseObject.analyseColumnsFromObject(data.get(0));    //TODO 默认当前的object 类型相同

        //获取对应的头部内容
        List<YCell> yCells = analyseObject.analyseTitle(yColumns);
        yCellArrayManager.addRow(yCells);

        //获取定义应的Content内容
        for(Object dataObject : data){
            List<YCell> yCellsObject = analyseObject.analyseObjectData(yColumns,dataObject);
            yCellArrayManager.addRow(yCellsObject);
        }

        return yCellArrayManager.getYCellArray();
    }

}
