package org.javaboy.vhr.model;

import java.io.Serializable;
import java.util.List;

public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer sid;

    private String name;

    private Integer period;

    private List<Score> scores;

    private List<Double> sumAndAvg;

    public Student() {
    }

    public Student(Integer sid, String name, Integer period, List<Score> scores, List<Double> sumAndAvg) {
        this.sid = sid;
        this.name = name;
        this.period = period;
        this.scores = scores;
        this.sumAndAvg = sumAndAvg;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public List<Score> getScores() {
        return scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }

    public List<Double> getSumAndAvg() {
        return sumAndAvg;
    }

    public void setSumAndAvg(List<Double> sumAndAvg) {
        this.sumAndAvg = sumAndAvg;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", period=" + period +
                ", scores=" + scores +
                ", sumAndAvg=" + sumAndAvg +
                '}';
    }

}
