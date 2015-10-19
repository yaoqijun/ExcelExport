package org.yqj.export;

import com.google.common.collect.Lists;
import org.yqj.excel.export.dataBuilder.DataBuilder;
import org.yqj.excel.export.dataBuilder.DataBuilderImpl;
import org.yqj.excel.export.dataConvert.AnalyseObjectImpl;
import org.yqj.excel.export.dataConvert.DataConvert;
import org.yqj.excel.export.dataConvert.DataConvertImpl;
import org.yqj.excel.export.dataExport.DataExport;
import org.yqj.excel.export.dataExport.DataExportImpl;
import org.yqj.excel.export.dto.StudentSimple;
import org.yqj.excel.export.model.YExcel;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

/**
 * Created by yaoqijun.
 * Date:2015-10-17
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
public class ExcelExportTest {

    public static void main(String []args) throws Exception{
        System.out.println("test excel export content");
        DataBuilder dataBuilder = new DataBuilderImpl();
        DataExport dataExport = new DataExportImpl();
        File file = new File("text.xls");

        YExcel yExcel = dataBuilder.builderExcel("test", "test", mockStudents());

        ///数据内容的转换
        DataConvert dataConvert = new DataConvertImpl(new AnalyseObjectImpl());
        yExcel.getSheets().get(0).setYCellArray(dataConvert.dataConvertCellArray(yExcel.getSheets().get(0).getData()));

        dataExport.exportExcelData(yExcel, new FileOutputStream(file));


        System.out.println("test excel export content");
    }

    public static List<Object> mockStudents(){
        List<Object> students = Lists.newArrayList();
        for(int i = 0 ; i < 10 ; i++){
            students.add(new StudentSimple("yaoqijun",100,26));

        }
        return students;
    }
}
