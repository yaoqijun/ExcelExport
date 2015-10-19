package org.yqj.excel.export.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by yaoqijun.
 * Date:2015-10-17
 * Email:yaoqj@terminus.io
 * Descirbe:excel 数组内容的管理   数组默认[1...n][1...n]
 */
public class YCellArray {

    private static final Integer DEFAULT_ARRAY_SIZE = 200;  //默认行列是200

    private int width;  //表哥的宽度

    private int height; //表格的高度

    @Getter @Setter
    private YCell[][] yCellArray; //导出数组

    public YCellArray(){
        this.width = DEFAULT_ARRAY_SIZE;
        this.height = DEFAULT_ARRAY_SIZE;
        yCellArray = new YCell[height][width];
    }

    public YCellArray(int width, int height){
        this.width = width;
        this.height = height;
        yCellArray = new YCell[height][width];
    }

    public Boolean setYCell(int x, int y, YCell yCell){
        while (x > height) extendHeight();  //扩展高度
        while (y > width) extendWidth();    //扩展宽度
        this.yCellArray[x-1][y-1] = yCell;
        return true;
    }

    public YCell getYCell(int x, int y){
        if(x > height || y > width){
            return null;
        }
        return yCellArray[x-1][y-1];
    }

    /**
     * 扩展对应的高度（默认扩展两倍）
     */
    private void extendHeight(){
        extendArray(this.height * 2, this.width);
    }

    /**
     * 扩展对应的宽度（默认扩展两倍）
     */
    private void extendWidth(){
        extendArray(this.height, this.width * 2);
    }

    /**
     * 重新调整数组的大小
     * @param height    高于当前的大小
     * @param width     宽于当前的大小
     * @return
     */
    private void extendArray(int height, int width){
        if(height < this.height || width < this.width){
            throw new RuntimeException("extend.array.fail");
        }
        this.height = height;
        this.width = width;
        YCell[][] yCells = new YCell[height][width];
        //copy data
        for(int i =0 ;i< yCellArray.length; i++){
            for(int j = 0 ; j< yCellArray[i].length; j++){
                yCells[i][j] = yCellArray[i][j];
            }
        }
        yCellArray = yCells;
    }
}
