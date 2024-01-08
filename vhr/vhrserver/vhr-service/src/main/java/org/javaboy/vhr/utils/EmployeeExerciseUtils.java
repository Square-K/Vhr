package org.javaboy.vhr.utils;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.javaboy.vhr.model.EmployeeExerciseSearchResult;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;


public class EmployeeExerciseUtils {

    public static ResponseEntity<byte[]> employeeExercise2Excel(List<EmployeeExerciseSearchResult> list) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        workbook.createInformationProperties();
        HSSFSheet sheet = workbook.createSheet("员工练习查询结果表");

        // 设置列宽
        for (int i = 0; i < 12; i++) {  // 修改列宽为12
            sheet.setColumnWidth(i, 15 * 256);
        }

        // 创建样式
        HSSFCellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.YELLOW.index);
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        // 创建标题行
        HSSFRow headerRow = sheet.createRow(0);
        String[] headers = {"ID", "姓名", "性别", "学校", "专业", "学历", "电话", "微信", "日语情况", "学习能力", "学习进度", "是否入场"};
        for (int i = 0; i < headers.length; i++) {
            HSSFCell headerCell = headerRow.createCell(i);
            headerCell.setCellValue(headers[i]);
            headerCell.setCellStyle(headerStyle);
        }

        // 填充数据
        for (int i = 0; i < list.size(); i++) {
            EmployeeExerciseSearchResult employee = list.get(i);
            HSSFRow dataRow = sheet.createRow(i + 1);
            dataRow.createCell(0).setCellValue(employee.getId());
            dataRow.createCell(1).setCellValue(employee.getName());
            dataRow.createCell(2).setCellValue(employee.getGender());
            dataRow.createCell(3).setCellValue(employee.getSchool());
            dataRow.createCell(4).setCellValue(employee.getSpeciality());
            dataRow.createCell(5).setCellValue(employee.getEducation());
            dataRow.createCell(6).setCellValue(employee.getPhone());
            dataRow.createCell(7).setCellValue(employee.getWeChat());
            dataRow.createCell(8).setCellValue(employee.getJapaneseSituation());
            dataRow.createCell(9).setCellValue(employee.getStudyAbility());
            dataRow.createCell(10).setCellValue(employee.getStudyProgress());
            dataRow.createCell(11).setCellValue(employee.getWorkState());
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        HttpHeaders responseHeaders = new HttpHeaders();
        try {
            responseHeaders.setContentDispositionFormData("attachment", new String("员工实训表.xls".getBytes("UTF-8"), "ISO-8859-1"));
            responseHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            workbook.write(baos);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(baos.toByteArray(), responseHeaders, HttpStatus.CREATED);
    }

    public static List<EmployeeExerciseSearchResult> excel2EmployeeExercise(MultipartFile file) {
        List<EmployeeExerciseSearchResult> resultList = new ArrayList<>();

        try (InputStream inputStream = file.getInputStream()) {
            HSSFWorkbook workbook = new HSSFWorkbook(inputStream);

            HSSFSheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();

            // 如果有行
            if (rowIterator.hasNext()) {
                // 跳过标题行
                rowIterator.next();
            }

            while (rowIterator.hasNext()) {
                HSSFRow row = (HSSFRow) rowIterator.next();
                EmployeeExerciseSearchResult employee = new EmployeeExerciseSearchResult();

                // 假设 ID 在第一列
                employee.setId((int) row.getCell(0).getNumericCellValue());

                // 假设姓名在第二列
                employee.setName(row.getCell(1).getStringCellValue());

                employee.setGender(row.getCell(2).getStringCellValue());
                employee.setSchool(row.getCell(3).getStringCellValue());
                employee.setSpeciality(row.getCell(4).getStringCellValue());
                employee.setEducation(row.getCell(5).getStringCellValue());
                employee.setPhone(row.getCell(6).getStringCellValue());
                employee.setWeChat(row.getCell(7).getStringCellValue());
                employee.setJapaneseSituation(row.getCell(8).getStringCellValue());
                employee.setStudyAbility(row.getCell(9).getStringCellValue());
                employee.setStudyProgress(row.getCell(10).getStringCellValue());
                employee.setWorkState((int) row.getCell(11).getNumericCellValue());

                resultList.add(employee);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return resultList;
    }
}
