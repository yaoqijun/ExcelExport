package org.yqj.excel.export.dataConvert;

import lombok.Getter;
import lombok.Setter;
import org.yqj.excel.export.model.YCell;
import org.yqj.excel.export.model.YCellArray;

import java.util.List;

/**
 * Created by yaoqijun.
 * Date:2015-10-17
 * Email:yaoqj@terminus.io
 * Descirbe: 通过对CellArrayManager 的信息的管理方式
 */
public class YCellArrayManager {

    @Getter @Setter
    private YCellArray yCellArray;

    @Getter @Setter
    private int x;  //当前的height 的位置

    @Getter @Setter
    private int y;  //当前的Width 的位置

    public YCellArrayManager(){
        yCellArray = new YCellArray();
        x = 1;
        y = 1;
    }

    /**
     * 添加对应的CellList， 默认换行
     * @param yCellList
     */
    public void addRow(List<YCell> yCellList){
        for (YCell yCell : yCellList){
            this.yCellArray.setYCell(x,y,yCell);
            y++;
        }
        x++; y=1;
    }

    public void addColumn(){
        //  然并卵用
        return;
    }

    public void addCellByPos(YCell yCell , int x , int y){
        if(yCell==null){
            return;
        }
        yCellArray.setYCell(x,y,yCell);
    }

    public void setPos(int x, int y){
        this.x = x;
        this.y = y;
    }

    public YCell getCellByPos(int x, int y){
        return yCellArray.getYCell(x,y);
    }

    public void setYCellArray(YCellArray yCellArray){
        this.yCellArray = yCellArray;
    }

    public YCellArray getYCellArray(){
        return yCellArray;
    }

}
