Excel Export Annotation

通过Excel 一注解的形式导出对应的Excel 表哥内容。

关键：对象形式的数据 与 Excel 表格形式的数据之间的转换方式， 数据的导出可以使用不同的导出工具。


注解方式创建导出Class,   ->    对象数据 转换 导出数据格式    ->    通过工具导出数据内容   ->    定义数据的导出方式

dataBuilder   ->     dataConvert   ->     dataExport

1.0-SNAPSHOT  :      首行列扩展的形式。（转换方法， Array 手动调整， 可插拔，替换的实现方式）
项目结构：
Dto :
model : Excel 表导出实体类 模块
       YCell 单元格
       YExcel Excel 页面
       YSheet Sheet 表格
       YExcelArray  Cell数组

       注解：行级重复性元素， 列级元素的划分  （）
       @Column（name(名称), style(类型)）
              复杂的列合并， Column 嵌套。
              bug: 默认 第一列 不允许被合并（"这个以后再说"）。 Object 默认最大合并的行
       @Columns 多列包含的内容功能（注解默认对象类型）

Dto:    定义导出数据Sheet 不同形式。
              模拟数据内容：默认通过Column实现对Excel 表中列的添加方式。

DataConvert:    数据内容的转换模块。


DataExport:     数据导出模块。（默认当前支持单行的列合并）
                     Export List<data> 默认数据是不会改变的。      获取对应的值的信息内容。
                     data默认Object 类型的数据， 解析对应Field 类型。
                     对应的每个objet 过滤，获取对应的数据内容。

manager:    导出任务管理模块。

dataBuilder:  创建封装对应的数据类型。
       DataBuilder 构建不同类型的Excel内容


2.0-SNAPSHOT  :      通过单元列表可拆分的形式， Excel拆分单元子表的形式，复杂的导出表结构。


