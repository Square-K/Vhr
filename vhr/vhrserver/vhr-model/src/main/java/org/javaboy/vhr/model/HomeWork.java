package org.javaboy.vhr.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 郭雯雯
 * @date 2023/12/20
 * 作业实体类
 */
public class HomeWork implements Serializable {

    private static final long serialVersionUID = 8683452581122892189L;

    //自增id
    private Integer id;
    //期数
    private Integer epNum;
    //日期
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date day;
    //课程名
    private String lessonName;
    //章节
    private String section;
    //姓名
    private String name;
    //状态
    private Integer status;
    //课程顺序
    private Integer leOrder;

    public HomeWork() {
    }

    public HomeWork(Integer id, Integer epNum, Date day, String lessonName, String section, String name, Integer status, Integer leOrder) {
        this.id = id;
        this.epNum = epNum;
        this.day = day;
        this.lessonName = lessonName;
        this.section = section;
        this.name = name;
        this.status = status;
        this.leOrder = leOrder;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEpNum() {
        return epNum;
    }

    public void setEpNum(Integer epNum) {
        this.epNum = epNum;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getLeOrder() {
        return leOrder;
    }

    public void setLeOrder(Integer leOrder) {
        this.leOrder = leOrder;
    }
}
