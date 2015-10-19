package org.yqj.excel.export.dataExport;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.yqj.excel.export.model.YCell;
import org.yqj.excel.export.model.YExcel;
import org.yqj.excel.export.model.YSheet;

import java.io.OutputStream;
import java.util.List;

/**
 * Created by yaoqijun.
 * Date:2015-10-17
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
public class DataExportImpl implements DataExport {

    @Override
    public Boolean exportExcelData(YExcel yExcel, OutputStream outputStream) {
        try{
            //导出数据内容
            List<YSheet> sheets = yExcel.getSheets();
            SXSSFWorkbook workbook = new SXSSFWorkbook(200);

            for(YSheet ySheet : sheets){
                createSheet(workbook,ySheet);
            }

            workbook.write(outputStream);
            return Boolean.TRUE;
        }catch (Exception e){
            return Boolean.FALSE;
        }
    }

    /**
     * 创建对应的Sheet 内容
     * @param workbook
     * @param ySheet
     * @return
     */
    private void createSheet(SXSSFWorkbook workbook, YSheet ySheet){

        SXSSFSheet sheet = (SXSSFSheet)workbook.createSheet(ySheet.getSheetName());
        sheet.setRandomAccessWindowSize(200);

        //创建数据内容
        YCell[][] yCellArray = ySheet.getYCellArray().getYCellArray();
        for(int i =0; i<yCellArray.length; i++){
            Row row = sheet.createRow(i);
            for(int j=0; j<yCellArray[i].length; j++){
                if(yCellArray[i][j]!=null) {
                    Cell cell = row.createCell(j);
                    cell.setCellValue(yCellArray[i][j].getValue());
                }
            }
        }
    }
}
