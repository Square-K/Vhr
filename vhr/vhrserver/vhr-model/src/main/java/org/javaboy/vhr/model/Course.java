package org.javaboy.vhr.model;

public class Course {
    //课程id
    private Integer courseId;
    //周数
    private Integer weekNum;
    //课程名称
    private String courseName;
    //课程日期
    private String courseDate;
    //课程星期
    private String week;
    //课程节数
    private String section;
    //get、set方法
    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getWeekNum() {
        return weekNum;
    }

    public void setWeekNum(Integer weekNum) {
        this.weekNum = weekNum;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDate() {
        return courseDate;
    }

    public void setCourseDate(String courseDate) {
        this.courseDate = courseDate;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    //空参、有参构造方法
    public Course() {
    }

    public Course(Integer courseId, Integer courseNum, String courseName, String courseDate, String week, String section) {
        this.courseId = courseId;
        this.weekNum = courseNum;
        this.courseName = courseName;
        this.courseDate = courseDate;
        this.week = week;
        this.section = section;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseNum=" + weekNum +
                ", courseName='" + courseName + '\'' +
                ", courseDate='" + courseDate + '\'' +
                ", week='" + week + '\'' +
                ", section='" + section + '\'' +
                '}';
    }
}
