package org.javaboy.vhr.model;

import java.io.Serializable;

/**
 * @author 张睿
 * @date 2023/12/27
 * 实训成绩实体类
 */
public class Score implements Serializable {

    private static final long serialVersionUID = 1L;

    //自增id
    private Integer id;

    private Integer sid;

    private String lessonName;

    private Integer score;

    private Integer lessonOrder;

    public Score() {
    }

    public Score(Integer id, Integer sid, String lessonName, Integer score, Integer lessonOrder) {
        this.id = id;
        this.sid = sid;
        this.lessonName = lessonName;
        this.score = score;
        this.lessonOrder = lessonOrder;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getLessonOrder() {
        return lessonOrder;
    }

    public void setLessonOrder(Integer lessonOrder) {
        this.lessonOrder = lessonOrder;
    }

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", sid=" + sid +
                ", lessonName='" + lessonName + '\'' +
                ", score=" + score +
                ", lessonOrder=" + lessonOrder +
                '}';
    }

}
