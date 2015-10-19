package org.yqj.export.dto;

import org.yqj.excel.export.dto.Grade;
import org.yqj.excel.export.dto.Student;
import org.yqj.excel.export.model.Column;

import java.lang.reflect.Field;

/**
 * Created by yaoqijun.
 * Date:2015-10-17
 * Email:yaoqj@terminus.io
 * Descirbe:    测试导出注解信息
 */
public class StudentInfoGet {
    public static void main(String []args) throws Exception{
        testFieldUse();
    }

    public static void testFieldUse() throws Exception{
        System.out.println("student test again");
        Object obj1 = mockStudent();
        Object obj2 = mockStudent();
        Field field = obj1.getClass().getDeclaredField("grade");
        field.setAccessible(true);
        Field fieldChinese = field.getType().getDeclaredField("chinese");
        fieldChinese.setAccessible(true);
        System.out.println(fieldChinese.get(new Grade(10,10,10)));
//        System.out.println(field.get(obj1));
//        System.out.print(field.get(obj2));
    }

    public static void testGetAnnotationValue() throws IllegalAccessException{
        System.out.println("student info get");

        Object obj = mockStudent();
        Field[] fields = obj.getClass().getDeclaredFields();
        for(Field field : fields){
            Column annotation = field.getAnnotation(Column.class);
            System.out.println("---------------------------------");
            System.out.println(annotation.name());
            System.out.println(annotation.type());
            field.setAccessible(true);
            System.out.println(field.get(obj));
            System.out.println("---------------------------------");

            if(annotation.type() == 2){
                Field[] fieldsSub = field.getType().getDeclaredFields();
                for(Field fieldSub : fieldsSub){
                    Column annotationSub = fieldSub.getAnnotation(Column.class);
                    System.out.println(annotationSub.name());
                    System.out.println(annotation.type());
                }
            }
        }
    }

    public static Student mockStudent(){
        Grade grade = new Grade();

        Student student = new Student();
        student.setName("姚启俊");
        student.setAge(18);

        grade.setChinese(100);
        grade.setEnglish(100);
        grade.setMath(100);

        student.setGrade(grade);
        return student;
    }
}
