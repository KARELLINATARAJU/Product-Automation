package com.productlistautomation.utils;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExcelUtils {
    public static String getCellData(String filepath,int rowNum,int colNum){
        try{
            FileInputStream fis=new FileInputStream(filepath);
            Workbook workbook= WorkbookFactory.create(fis);
            Sheet sheet=workbook.getSheetAt(0);
            Row row= sheet.getRow(rowNum);
            Cell cell=row.getCell(colNum);
            return cell.getStringCellValue();
        } catch (Exception e) {
            throw new RuntimeException("Failed to read Excel data");
        }
    }
}
