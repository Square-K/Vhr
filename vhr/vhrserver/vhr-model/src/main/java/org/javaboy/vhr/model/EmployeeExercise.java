package org.javaboy.vhr.model;

import java.io.Serializable;

public class EmployeeExercise implements Serializable {

    private Integer id;
    private String japaneseSituation;

    private String studyAbility;

    private String studyProgress;

    private Integer workState;

    public EmployeeExercise(Integer id, String japaneseSituation, String studyAbility, String studyProgress, Integer workState) {
        this.id = id;
        this.japaneseSituation = japaneseSituation;
        this.studyAbility = studyAbility;
        this.studyProgress = studyProgress;
        this.workState = workState;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    // 无参构造函数
    public EmployeeExercise() {
    }
}
