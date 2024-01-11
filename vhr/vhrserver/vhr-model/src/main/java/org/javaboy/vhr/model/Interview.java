package org.javaboy.vhr.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class Interview implements Serializable {
    private Integer id;

    private String name;

    private String gender;

    public Interview(String name, String gender, String school, String speciality, String education, String graduateDate, String idCard, String phone, String weChat, String japanese, String notes, String test_time1, String result1, String test_time2, String result2, String offer, String agreement, String beginDate) {
    }

    public Interview() {

    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", school=" + school + '\'' +
                ", speciality='" + speciality + '\'' +
                ", education='" + education + '\'' +
                ", graduateDate=" + graduateDate +
                ", idCard='" + idCard + '\'' +
                ", phone=" + phone + '\'' +
                ", weChat='" + weChat + '\'' +
                ", japanese='" + japanese + '\'' +
                ", notes='" + notes + '\'' +
                ", test_time1=" + test_time1 +
                ", result1=" + result1 + '\'' +
                ", test_time2=" + test_time2 +
                ", result2='" + result2 + '\'' +
                ", offer='" + offer + '\'' +
                ", agreement='" + agreement + '\'' +
                ", beginDate='" + beginDate +
                '}';
    }

    private String school;

    private String speciality;

    private String education;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date graduateDate;

    private String idCard;

    private String phone;

    private String weChat;

    private String japanese;

    private String notes;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date test_time1;

    private String result1;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date test_time2;

    private String result2;

    private String offer;

    private String agreement;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date beginDate;

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

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public Date getGraduateDate() {
        return graduateDate;
    }

    public void setGraduateDate(Date graduateDate) {
        this.graduateDate = graduateDate;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWeChat() {
        return weChat;
    }

    public void setWeChat(String weChat) {
        this.weChat = weChat;
    }

    public String getJapanese() {
        return japanese;
    }

    public void setJapanese(String japanese) {
        this.japanese = japanese;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getTest_time1() {
        return test_time1;
    }

    public void setTest_time1(Date test_time1) {
        this.test_time1 = test_time1;
    }

    public String getResult1() {
        return result1;
    }

    public void setResult1(String result1) {
        this.result1 = result1;
    }

    public Date getTest_time2() {
        return test_time2;
    }

    public void setTest_time2(Date test_time2) {
        this.test_time2 = test_time2;
    }

    public String getResult2() {
        return result2;
    }

    public void setResult2(String result2) {
        this.result2 = result2;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public String getAgreement() {
        return agreement;
    }

    public void setAgreement(String agreement) {
        this.agreement = agreement;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

}