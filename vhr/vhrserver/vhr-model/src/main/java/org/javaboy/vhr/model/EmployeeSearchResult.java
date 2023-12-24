package org.javaboy.vhr.model;

import java.io.Serializable;

public class EmployeeSearchResult implements Serializable {
    private Integer id;

    private String name;

    private String gender;

    private String school;

    private String japanese;

    private Integer age;

    private Integer interviewStatus;

    private Double salary;

    private Double averageScore;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getJapanese() {
        return japanese;
    }

    public void setJapanese(String japanese) {
        this.japanese = japanese;
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

    public EmployeeSearchResult(Integer id, String name, String gender, String school, String japanese, Integer age, Integer interviewStatus, Double salary, Double averageScore) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.school = school;
        this.japanese = japanese;
        this.age = age;
        this.interviewStatus = interviewStatus;
        this.salary = salary;
        this.averageScore = averageScore;
    }
}