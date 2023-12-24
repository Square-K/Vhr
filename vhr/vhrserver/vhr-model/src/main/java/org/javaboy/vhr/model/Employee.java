package org.javaboy.vhr.model;

import java.io.Serializable;

public class Employee implements Serializable {
    private Integer id;

    private Integer age;

    private Integer interviewStatus;

    private Double salary;

    private Double averageScore;

    public Employee(Integer id, Integer age, Integer interviewStatus, Double salary, Double averageScore) {
        this.id = id;
        this.age = age;
        this.interviewStatus = interviewStatus;
        this.salary = salary;
        this.averageScore = averageScore;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getInterviewStatus() {
        return interviewStatus;
    }

    public void setInterviewStatus(Integer interviewStatus) {
        this.interviewStatus = interviewStatus;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(Double averageScore) {
        this.averageScore = averageScore;
    }

}