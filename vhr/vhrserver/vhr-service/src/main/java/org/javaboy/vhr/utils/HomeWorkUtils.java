package org.javaboy.vhr.utils;

import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.javaboy.vhr.model.HomeWork;
import org.javaboy.vhr.model.Interview;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 郭雯雯
 * @date 2023/12/24
 */
public class HomeWorkUtils {
    public static ResponseEntity<byte[]> homework2Excel(List<HomeWork> list) {
        //1. 创建一个 Excel 文档
        HSSFWorkbook workbook = new HSSFWorkbook();
        //2. 创建文档摘要
        workbook.createInformationProperties();
        //3. 获取并配置文档信息
        DocumentSummaryInformation docInfo = workbook.getDocumentSummaryInformation();
        //文档类别
        docInfo.setCategory("作业表");
        //文档管理员
        docInfo.setManager("seiryo");
        //设置公司信息
        docInfo.setCompany("www.seiryo-wh.com");
        //4. 获取文档摘要信息
        SummaryInformation summInfo = workbook.getSummaryInformation();
        //文档标题
        summInfo.setTitle("作业信息表");
        //文档作者
        summInfo.setAuthor("seiryo");
        // 文档备注
        summInfo.setComments("本文档由 seiryo 提供");
        //创建标题行的样式
        HSSFCellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.YELLOW.index);
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        HSSFCellStyle dateCellStyle = workbook.createCellStyle();
       // dateCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));
        HSSFDataFormat dataFormat = workbook.createDataFormat();
        dateCellStyle.setDataFormat(dataFormat.getFormat("yyyy-mm-dd"));

        HSSFSheet sheet = workbook.createSheet("作业信息表");
        //设置列的宽度
        sheet.setColumnWidth(0, 12 * 256);
        sheet.setColumnWidth(1, 12 * 256);
        sheet.setColumnWidth(2, 12 * 256);
        sheet.setColumnWidth(3, 12 * 256);
        sheet.setColumnWidth(4, 12 * 256);
        //6. 创建标题行
        HSSFRow r0 = sheet.createRow(0);
        HSSFCell c0 = r0.createCell(0);
        c0.setCellValue("日期");
        c0.setCellStyle(headerStyle);
        HSSFCell c1 = r0.createCell(1);
        c1.setCellStyle(headerStyle);
        c1.setCellValue("课程名");
        HSSFCell c2 = r0.createCell(2);
        c2.setCellStyle(headerStyle);
        c2.setCellValue("章节");
        HSSFCell c3 = r0.createCell(3);
        c3.setCellStyle(headerStyle);
        c3.setCellValue("姓名");
        HSSFCell c4 = r0.createCell(4);
        c4.setCellStyle(headerStyle);
        c4.setCellValue("状态");
//        HSSFCell c5 = r0.createCell(5);
//        c5.setCellStyle(headerStyle);
//        c5.setCellValue("状态");
        for (int i = 0; i < list.size(); i++) {
            HomeWork h = list.get(i);
            HSSFRow row = sheet.createRow(i + 1);
           // row.createCell(0).setCellValue(h.getId());
            HSSFCell cell0 = row.createCell(0);
            cell0.setCellStyle(dateCellStyle);
            cell0.setCellValue(h.getDay());
            row.createCell(1).setCellValue(h.getLessonName());
            row.createCell(2).setCellValue(h.getSection());
            row.createCell(3).setCellValue(h.getName());
            row.createCell(4).setCellValue(h.getStatus());
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        HttpHeaders headers = new HttpHeaders();
        try {
            headers.setContentDispositionFormData("attachment",
                    new String("作业信息表.xls".getBytes("UTF-8"), "ISO-8859-1"));
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            workbook.write(baos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<byte[]>(baos.toByteArray(), headers, HttpStatus.CREATED);
    }

    public static List<HomeWork> excel2HomeWork(MultipartFile file){
        List<HomeWork> list = new ArrayList<>();
        HomeWork h = null;
        try {
            //1. 创建一个 workbook 对象
            HSSFWorkbook workbook = new HSSFWorkbook(file.getInputStream());
            //2. 获取 workbook 中表单的数量
            int numberOfSheets = workbook.getNumberOfSheets();
            for (int i = 0; i < numberOfSheets; i++) {
                //3. 获取表单
                HSSFSheet sheet = workbook.getSheetAt(i);
                //4. 获取表单中的行数
                int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
                for (int j = 0; j < physicalNumberOfRows; j++) {
                    //5. 跳过标题行
                    if (j == 0) {
                        continue;//跳过标题行
                    }
                    //6. 获取行
                    HSSFRow row = sheet.getRow(j);
                    if (row == null) {
                        continue;//防止数据中间有空行
                    }
                    //7. 获取列数
                    int physicalNumberOfCells = row.getPhysicalNumberOfCells();
                    h = new HomeWork();
                    for (int k = 0; k < physicalNumberOfCells; k++) {
                        HSSFCell cell = row.getCell(k);
                        switch (cell.getCellType()) {
                            case STRING:
                                String cellValue = cell.getStringCellValue();
                                switch (k) {
                                    case 1:
                                        h.setLessonName(cellValue);
                                        break;
                                    case 2:
                                        h.setSection(cellValue);
                                        break;
                                    case 3:
                                        h.setName(cellValue);
                                        break;
                                    case 4:
                                        h.setStatus(cellValue);
                                        break;
                                }
                                break;
                            default: {
                                switch (k) {
                                    case 0:
                                        h.setDay(cell.getDateCellValue());
                                        break;
                                }
                            }
                            break;
                        }
                    }
                    list.add(h);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

}
