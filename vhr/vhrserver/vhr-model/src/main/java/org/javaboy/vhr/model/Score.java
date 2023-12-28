package org.javaboy.vhr.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 张睿
 * @date 2023/12/27
 * 实训成绩实体类
 */
public class Score implements Serializable {

    private static final long serialVersionUID = 1L;

    //自增id
    private Integer id;
    //期数
    private Integer epNum;
    //日期@DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date day;
    //课程名
    private String lessonName;
    //姓名
    private String name;
    //成绩
    private String score;
    //课程顺序
    private Integer leOrder;

    public Score() {
    }

    public Score(Integer id, Integer epNum, Date day, String lessonName, String name, String score, Integer leOrder) {
        this.id = id;
        this.epNum = epNum;
        this.day = day;
        this.lessonName = lessonName;
        this.name = name;
        this.score = score;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Integer getLeOrder() {
        return leOrder;
    }

    public void setLeOrder(Integer leOrder) {
        this.leOrder = leOrder;
    }

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", epNum=" + epNum +
                ", day=" + day +
                ", lessonName='" + lessonName + '\'' +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", leOrder=" + leOrder +
                '}';
    }

}
