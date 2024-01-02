package org.javaboy.vhr.mapper;

import org.javaboy.vhr.model.EmployeeExerciseSearchResult;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import org.javaboy.vhr.model.EmployeeExercise;


public interface EmployeeExerciseMapper {

    List<EmployeeExerciseSearchResult> searchEmployee(String name);

    int deleteByPrimaryKey(Integer id);

    List<EmployeeExerciseSearchResult> searchEmployeesByCriteria(
            @Param("japaneseSituation") String japaneseSituation,
            @Param("studyAbility") String studyAbility,
            @Param("studyProgress") String studyProgress,
            @Param("workState") Integer workState
    );

    int insertSelective(EmployeeExercise record);

}
