package com.mgskj.utils;

import com.mgskj.controller.OperationController;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public class ExcelUtil {
    private static Logger log = LoggerFactory.getLogger(OperationController.class);

    private static final int MAX_ROW_NUM = 60000;

    /**
     * 导出普通Excel
     *
     * @param sheetName sheet名称
     * @param title     标题
     * @param values    内容
     * @param wb        HSSFWorkbook对象
     * @return
     */
    public static HSSFWorkbook getHSSFWorkbook(String sheetName, String[] title, String[][] values, HSSFWorkbook wb) {

        // 第一步，创建一个HSSFWorkbook，对应一个Excel文件
        if (wb == null) {
            wb = new HSSFWorkbook();
        }

        // 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet(sheetName);

        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
        HSSFRow row = sheet.createRow(0);

        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

        // 声明列对象
        HSSFCell cell = null;

        // 创建标题
        setTitle(title, row, style);

        // 创建内容
        for (int i = 0; i < values.length; i++) {
            if (i != 0 && i % MAX_ROW_NUM == 0) {
                sheet = wb.createSheet(sheetName + (i / MAX_ROW_NUM + 1));
                row = sheet.createRow(0);
                setTitle(title, row, style);
            }
            row = sheet.createRow(i % MAX_ROW_NUM + 1);
            for (int j = 0; j < values[i].length; j++) {
                // 将内容按顺序赋给对应的列对象
                row.createCell(j).setCellValue(values[i][j]);
            }
        }
        return wb;
    }

    private static void setTitle(String[] title, HSSFRow row, HSSFCellStyle style) {
        HSSFCell cell;
        for (int i = 0; i < title.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(style);
        }
    }

    /**
     * 导出复杂表头Excel
     *
     * @param sheetName sheet名称
     * @param title     标题
     * @param values    内容
     * @param regions   合并单元格
     * @param wb        HSSFWorkbook对象
     * @return
     */
    @SuppressWarnings("deprecation")
    public static HSSFWorkbook getComplexWorkbook(String sheetName, String[][] title, String[][] values,
                                                  CellRangeAddress[] regions, HSSFWorkbook wb) {

        // 第一步，创建一个HSSFWorkbook，对应一个Excel文件
        if (wb == null) {
            wb = new HSSFWorkbook();
        }

        // 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet(sheetName);

        // 第三步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // 垂直居中

        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
        HSSFRow row;

        // 声明列对象
        HSSFCell cell = null;

        // 创建标题
        setComplexTitle(title, regions, sheet, style);
        // 创建内容
        for (int i = 0; i < values.length; i++) {
            if (i != 0 && i % MAX_ROW_NUM == 0) {
                sheet = wb.createSheet(sheetName + (i / MAX_ROW_NUM + 1));
                setComplexTitle(title, regions, sheet, style);
            }
            row = sheet.createRow(i % MAX_ROW_NUM + title.length);
            for (int j = 0; j < values[i].length; j++) {
                // 将内容按顺序赋给对应的列对象
                row.createCell(j).setCellValue(values[i][j]);
            }
        }
        return wb;
    }

    private static void setComplexTitle(String[][] title, CellRangeAddress[] regions, HSSFSheet sheet, HSSFCellStyle style) {
        HSSFRow row;
        HSSFCell cell;
        for (int i = 0; i < title.length; i++) {
            row = sheet.createRow(i);
            for (int j = 0; j < title[i].length; j++) {
                cell = row.createCell(j);
                cell.setCellValue(title[i][j]);
                cell.setCellStyle(style);
            }
        }
        if (regions != null) {
            for (int k = 0; k < regions.length; k++) {
                sheet.addMergedRegion(regions[k]);
            }
        }
    }

    // 发送响应流方法
    public static void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(), "ISO8859-1");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
