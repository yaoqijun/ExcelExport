package org.yqj.excel.export.dataConvert;

import com.google.common.collect.Lists;
import org.yqj.excel.export.model.Column;
import org.yqj.excel.export.model.YCell;
import org.yqj.excel.export.model.YColumn;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by yaoqijun.
 * Date:2015-10-17
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
public class AnalyseObjectImpl implements AnalyseObject {

    @Override
    public List<YColumn> analyseColumnsFromObject(Object object) {
        List<YColumn> yColumns = Lists.newArrayList();
        Field[] fields = object.getClass().getDeclaredFields();
        for(Field field : fields){
            Column column = field.getAnnotation(Column.class);
            if(column != null){
                field.setAccessible(true);
                yColumns.add(new YColumn(field,column));
            }
        }
        return yColumns;
    }

    @Override
    public List<YCell> analyseObjectData(List<YColumn> yColumns, Object object)  {
        try{
            List<YCell> yCells = Lists.newArrayList();
            for(YColumn yColumn : yColumns){
                yCells.add(new YCell(yColumn.getField().get(object).toString(),null,null));
            }
            return yCells;
        }catch (Exception e){
            return Lists.newArrayList();
        }
    }

    @Override
    public List<YCell> analyseTitle(List<YColumn> yColumns) {
        List<YCell> cells = Lists.newArrayList();
        for(YColumn yColumn : yColumns){
            cells.add(new YCell(yColumn.getColumn().name(),null,null));
        }
        return cells;
    }
}
