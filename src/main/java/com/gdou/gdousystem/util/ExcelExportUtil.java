package com.gdou.gdousystem.util;

import org.apache.poi.hssf.usermodel.*;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/**
 * @author Meng
 * @date 2019/12/25
 */
public class ExcelExportUtil {

    public static HSSFWorkbook createExcel(Map<String,Object> excelMap){
        HSSFWorkbook workbook = new HSSFWorkbook();
        String sheetName = excelMap.get("sheetName").toString();
        HSSFSheet sheet = workbook.createSheet(sheetName);

        //只考虑一个sheet的情况
        HSSFRow row = sheet.createRow(0);
        //设置列宽，setColumnWidth的第二个参数要乘以256，这个参数的单位是1/256个字符宽度
        sheet.setColumnWidth(1, 12 * 256);
        sheet.setColumnWidth(3, 17 * 256);

        //表头设置为居中加粗
        HSSFCellStyle style = workbook.createCellStyle();
        HSSFFont font = workbook.createFont();
        font.setBoldweight((short) 14);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setFont(font);
        style.setWrapText(true);
        //是否生成序号，序号从1开始
        boolean isSerial = (boolean) excelMap.get("isSerial");
        //获取表头列表
        List<String> headerList = (List<String>) excelMap.get("header");
        HSSFCell cell;

        //生成表头
        int headRow=0;
        if (isSerial){
            //设置第一个列为序号列
            cell = row.createCell(0);
            cell.setCellValue("序号");
            cell.setCellStyle(style);
            headRow = 1;

        }
        for (String header : headerList) {
            cell = row.createCell(headRow);
            cell.setCellValue(header);
            cell.setCellStyle(style);
            headRow++;
        }

        //往Excel中插入数据
        List<List<String>> data = (List<List<String>>) excelMap.get("data");

        int rowNum = 1;
        //需要生成序号
        if (isSerial){
            //表头字段包含序号一列
            int headSize = headerList.size() + 1;
            for (List<String> obj:data){
                HSSFRow currRow = sheet.createRow(rowNum);
                for (int i=1;i<headSize;i++){
                    currRow.createCell(0).setCellValue(rowNum);
                    currRow.createCell(i).setCellValue(obj.get(i-1));
                }
                rowNum++;
            }
            //无需生成序号
        }else{
            int headSize = headerList.size();
            for (List<String> obj:data){
                HSSFRow currRow = sheet.createRow(rowNum);
                for (int i=0;i<headSize;i++){
                    currRow.createCell(i).setCellValue(obj.get(i));
                }
                rowNum++;
            }
        }
        setSizeColumn(sheet);
        return workbook;
    }

    private static void setSizeColumn(HSSFSheet sheet) {
        for (int columnNum = 0; columnNum <= 8; columnNum++) {
            int columnWidth = sheet.getColumnWidth(columnNum) / 256;
            for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {
                HSSFRow currentRow;
                //当前行未被使用过
                if (sheet.getRow(rowNum) == null) {
                    currentRow = sheet.createRow(rowNum);
                } else {
                    currentRow = sheet.getRow(rowNum);
                }

                if (currentRow.getCell(columnNum) != null) {
                    HSSFCell currentCell = currentRow.getCell(columnNum);
                    if (currentCell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
                        int length = currentCell.getStringCellValue().getBytes().length;
                        if (columnWidth < length) {
                            columnWidth = length;
                        }
                    }
                }
            }
            sheet.setColumnWidth(columnNum, columnWidth * 256);
        }
    }

    public static void buildExcelFile(String filename, HSSFWorkbook workbook) throws Exception {
        FileOutputStream fos = new FileOutputStream(filename);
        workbook.write(fos);
        fos.flush();
        fos.close();
    }
    public static void buildExcelDocument(String filename, HSSFWorkbook workbook, HttpServletResponse response) throws Exception {
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "utf-8"));
        OutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        outputStream.flush();
        outputStream.close();
    }
}
