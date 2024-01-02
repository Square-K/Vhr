package org.javaboy.vhr.model;

import java.io.Serializable;

/*
  zzc
 */
public class EmployeeExerciseSearchResult implements Serializable {
    private Integer id;

    private String name;

    private String gender;

    private String school;

    private String speciality;

    private String education;

    private String phone;

    private String weChat;

    private String japaneseSituation;

    private String studyAbility;

    private String studyProgress;

    private Integer workState;

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

    public String getJapaneseSituation() {
        return japaneseSituation;
    }

    public void setJapaneseSituation(String japaneseSituation) {
        this.japaneseSituation = japaneseSituation;
    }

    public String getStudyAbility() {
        return studyAbility;
    }

    public void setStudyAbility(String studyAbility) {
        this.studyAbility = studyAbility;
    }

    public String getStudyProgress() {
        return studyProgress;
    }

    public void setStudyProgress(String studyProgress) {
        this.studyProgress = studyProgress;
    }

    public Integer getWorkState() {
        return workState;
    }

    public void setWorkState(Integer workState) {
        this.workState = workState;
    }



    public EmployeeExerciseSearchResult(Integer id, String name, String gender, String school, String speciality, String education, String phone, String weChat, String japaneseSituation, String studyAbility, String studyProgress, Integer workState) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.school = school;
        this.speciality = speciality;
        this.education = education;
        this.phone = phone;
        this.weChat = weChat;
        this.japaneseSituation = japaneseSituation;
        this.studyAbility = studyAbility;
        this.studyProgress = studyProgress;
        this.workState = workState;
    }
}
