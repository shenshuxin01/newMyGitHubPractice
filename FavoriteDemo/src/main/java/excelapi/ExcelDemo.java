package excelapi;
import org.apache.poi.ss.usermodel.CellCopyPolicy;
 import org.apache.poi.xssf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;

/**
 *"C:\Users\22374\Desktop\FavoriteDemo.jar"
 * 逻辑是根据表格里面sheet1
 * 第一列是时间列
 * 找出最后一行
 * 获取最后一行、第一列的值
 * 然后转成时间格式
 * 然后新增
 *
 */

public class ExcelDemo {

    public static void main(String[] args) throws Exception{
        String fileName = "D:\\我的学习资料\\shell脚本WshShell\\记录我每天.xlsx";
        InputStream inputStream = new FileInputStream(fileName);
        XSSFWorkbook wb = new XSSFWorkbook(inputStream); 

        //获取指定sheet页面
        XSSFSheet sheet1 = wb.getSheetAt(0);
        
        //获取最大行
        int rowNum = sheet1.getLastRowNum();
        XSSFRow lastRow = sheet1.getRow(rowNum);

        //获取表里面最新日期tableDay
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(lastRow.getCell(0).getDateCellValue());
        int tableDay = calendar.get(Calendar.DAY_OF_YEAR);

        if (tableDay == Calendar.getInstance().get(Calendar.DAY_OF_YEAR)){
            return; //今天已经执行过了
        }

        XSSFRow newRow = sheet1.createRow(rowNum + 1);
        newRow.copyRowFrom(lastRow,new CellCopyPolicy());

        newRow.getCell(0).setCellValue(new Date());
        newRow.getCell(1).setCellValue(args[0]);


        FileOutputStream stream = new FileOutputStream(fileName);
        wb.write(stream);
        stream.flush();
        stream.close();

    }
}
