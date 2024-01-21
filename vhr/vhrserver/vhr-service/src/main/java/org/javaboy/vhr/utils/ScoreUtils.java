package org.javaboy.vhr.utils;

import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.javaboy.vhr.model.Score;
import org.javaboy.vhr.model.Student;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author 张睿
 * @date 2023/12/28
 */
public class ScoreUtils {
    public static ResponseEntity<byte[]> homework2Excel(List<Student> list) {
        //1. 创建一个 Excel 文档
        HSSFWorkbook workbook = new HSSFWorkbook();
        //2. 创建文档摘要
        workbook.createInformationProperties();
        //3. 获取并配置文档信息
        DocumentSummaryInformation docInfo = workbook.getDocumentSummaryInformation();
        //文档类别
        docInfo.setCategory("实训表");
        //文档管理员
        docInfo.setManager("seiryo");
        //设置公司信息
        docInfo.setCompany("www.seiryo-wh.com");
        //4. 获取文档摘要信息
        SummaryInformation summInfo = workbook.getSummaryInformation();
        //文档标题
        summInfo.setTitle("实训成绩表");
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

        HSSFSheet sheet = workbook.createSheet("实训成绩表");
        //设置列的宽度
        for(int i = 0; i < 29; i++){
            sheet.setColumnWidth(i, 12 * 256);
        }
        //6. 创建标题行
        HSSFRow r0 = sheet.createRow(0);
        HSSFCell c0 = r0.createCell(0);
        c0.setCellValue("姓名/课程");
        c0.setCellStyle(headerStyle);
        HSSFCell c1 = r0.createCell(1);
        c1.setCellStyle(headerStyle);
        c1.setCellValue("HTML笔试");
        HSSFCell c2 = r0.createCell(2);
        c2.setCellStyle(headerStyle);
        c2.setCellValue("HTML机试");
        HSSFCell c3 = r0.createCell(3);
        c3.setCellStyle(headerStyle);
        c3.setCellValue("SQL笔试");
        HSSFCell c4 = r0.createCell(4);
        c4.setCellStyle(headerStyle);
        c4.setCellValue("SQL机试");
        HSSFCell c5 = r0.createCell(5);
        c5.setCellStyle(headerStyle);
        c5.setCellValue("Java基础笔试");
        HSSFCell c6 = r0.createCell(6);
        c6.setCellStyle(headerStyle);
        c6.setCellValue("Java基础机试");
        HSSFCell c7 = r0.createCell(7);
        c7.setCellStyle(headerStyle);
        c7.setCellValue("js笔试");
        HSSFCell c8 = r0.createCell(8);
        c8.setCellStyle(headerStyle);
        c8.setCellValue("js机试");
        HSSFCell c9 = r0.createCell(9);
        c9.setCellStyle(headerStyle);
        c9.setCellValue("Java高级笔试");
        HSSFCell c10 = r0.createCell(10);
        c10.setCellStyle(headerStyle);
        c10.setCellValue("Java高级机试");
        HSSFCell c11 = r0.createCell(11);
        c11.setCellStyle(headerStyle);
        c11.setCellValue("Hibernate笔试");
        HSSFCell c12 = r0.createCell(12);
        c12.setCellStyle(headerStyle);
        c12.setCellValue("Hibernate机试");
        HSSFCell c13 = r0.createCell(13);
        c13.setCellStyle(headerStyle);
        c13.setCellValue("Struts笔试");
        HSSFCell c14 = r0.createCell(14);
        c14.setCellStyle(headerStyle);
        c14.setCellValue("Struts机试");
        HSSFCell c15 = r0.createCell(15);
        c15.setCellStyle(headerStyle);
        c15.setCellValue("Spring笔试");
        HSSFCell c16 = r0.createCell(16);
        c16.setCellStyle(headerStyle);
        c16.setCellValue("Spring机试");
        HSSFCell c17 = r0.createCell(17);
        c17.setCellStyle(headerStyle);
        c17.setCellValue("SSH整合笔试");
        HSSFCell c18 = r0.createCell(18);
        c18.setCellStyle(headerStyle);
        c18.setCellValue("SSH整合机试");
        HSSFCell c19 = r0.createCell(19);
        c19.setCellStyle(headerStyle);
        c19.setCellValue("Mybatis笔试");
        HSSFCell c20 = r0.createCell(20);
        c20.setCellStyle(headerStyle);
        c20.setCellValue("Mybatis机试");
        HSSFCell c21 = r0.createCell(21);
        c21.setCellStyle(headerStyle);
        c21.setCellValue("SpringMVC笔试");
        HSSFCell c22 = r0.createCell(22);
        c22.setCellStyle(headerStyle);
        c22.setCellValue("SpringMVC机试");
        HSSFCell c23 = r0.createCell(23);
        c23.setCellStyle(headerStyle);
        c23.setCellValue("SSM整合笔试");
        HSSFCell c24 = r0.createCell(24);
        c24.setCellStyle(headerStyle);
        c24.setCellValue("SSM整合机试");
        HSSFCell c25 = r0.createCell(25);
        c25.setCellStyle(headerStyle);
        c25.setCellValue("Bootstrap笔试");
        HSSFCell c26 = r0.createCell(26);
        c26.setCellStyle(headerStyle);
        c26.setCellValue("Bootstrap机试");
        HSSFCell c27 = r0.createCell(27);
        c27.setCellStyle(headerStyle);
        c27.setCellValue("总分");
        HSSFCell c28 = r0.createCell(28);
        c28.setCellStyle(headerStyle);
        c28.setCellValue("平均分");
        HSSFCell c29 = r0.createCell(29);
        c29.setCellStyle(headerStyle);
        c29.setCellValue("期数");

        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            HSSFRow row = sheet.createRow(i + 1);
            HSSFCell cell0 = row.createCell(0);
            cell0.setCellValue(student.getName());
            List<Score> scoreList = student.getScores();
            int a = 1;
            for (Score score : scoreList) {
                row.createCell(a++).setCellValue(score.getScore());
            }
            List<Double> sumAndAvg = student.getSumAndAvg();
            row.createCell(27).setCellValue(sumAndAvg.get(0));
            row.createCell(28).setCellValue(sumAndAvg.get(1));
            row.createCell(29).setCellValue(student.getPeriod());

        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        HttpHeaders headers = new HttpHeaders();
        try {
            headers.setContentDispositionFormData("attachment",
                    new String("实训成绩表.xls".getBytes("UTF-8"), "ISO-8859-1"));
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            workbook.write(baos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<byte[]>(baos.toByteArray(), headers, HttpStatus.CREATED);
    }

    public static List<Student> excel2HomeWork(MultipartFile file) {
        List<Student> studentList = new ArrayList<>();
        try {
            HSSFWorkbook workbook = new HSSFWorkbook(file.getInputStream());
            int numberOfSheets = workbook.getNumberOfSheets();

            for (int i = 0; i < numberOfSheets; i++) {
                HSSFSheet sheet = workbook.getSheetAt(i);
                int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();

                for (int j = 1; j < physicalNumberOfRows; j++) {
                    HSSFRow row = sheet.getRow(j);

                    if (row != null) {
                        Student student = new Student();

                        List<Score> scoreList = new ArrayList<>();

                        // 生成较长的随机整数作为sid
                        student.setSid(UUID.randomUUID().hashCode());

                        HSSFCell nameCell = row.getCell(0);
                        if (nameCell != null) {
                            student.setName(nameCell.getStringCellValue());
                        }

                        String[] lessonNames = {"HTML笔试", "HTML机试", "SQL笔试", "SQL机试", "Java基础笔试",
                                "Java基础机试", "js笔试", "js机试", "Java高级笔试", "Java高级机试",
                                "Hibernate笔试", "Hibernate机试", "Struts笔试", "Struts机试",
                                "Spring笔试", "Spring机试", "SSH整合笔试", "SSH整合机试",
                                "Mybatis笔试", "Mybatis机试", "SpringMVC笔试", "SpringMVC机试",
                                "SSM整合笔试", "SSM整合机试", "Bootstrap笔试", "Bootstrap机试"};

                        // 在循环中为每个Score对象设置scoreName属性
                        for (int k = 1; k < 27; k++) {
                            HSSFCell scoreCell = row.getCell(k);
                            if (scoreCell != null) {
                                Score score = new Score();
                                score.setLessonOrder(k);
                                score.setScore((int) scoreCell.getNumericCellValue());

                                // 根据 lessonOrder 获取课程名称
                                if (k >= 1 && k <= lessonNames.length) {
                                    String lessonName = lessonNames[k - 1];
                                    score.setLessonName(lessonName);
                                }

                                scoreList.add(score);
                            }
                        }

                        HSSFCell sumCell = row.getCell(27);
                        HSSFCell avgCell = row.getCell(28);
                        HSSFCell periodCell = row.getCell(29);

                        if (sumCell != null && avgCell != null && periodCell != null) {
                            List<Double> sumAndAvg = new ArrayList<>();
                            sumAndAvg.add(sumCell.getNumericCellValue());
                            sumAndAvg.add(avgCell.getNumericCellValue());
                            student.setSumAndAvg(sumAndAvg);

                            student.setPeriod((int) periodCell.getNumericCellValue());
                        }

                        student.setScores(scoreList);
                        studentList.add(student);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return studentList;
    }

}
