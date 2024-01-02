package org.javaboy.vhr.service;

import org.javaboy.vhr.mapper.EmployeeExerciseMapper;
import org.javaboy.vhr.model.EmployeeExerciseSearchResult;
import org.springframework.stereotype.Service;
import org.javaboy.vhr.model.EmployeeExercise;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmployeeExerciseService {
    @Resource
    EmployeeExerciseMapper employeeExerciseMapper;

    public List<EmployeeExerciseSearchResult> searchEmployee(String name) {
        return employeeExerciseMapper.searchEmployee(name);
    }

    public Integer deleteByPrimaryKey(Integer id) {
        return employeeExerciseMapper.deleteByPrimaryKey(id);
    }
    public List<EmployeeExerciseSearchResult> searchEmployeesByCriteria(
            String japaneseSituation,
            String studyAbility,
            String studyProgress,
            Integer workState) {
        return employeeExerciseMapper.searchEmployeesByCriteria(
                japaneseSituation,
                studyAbility,
                studyProgress,
                workState
        );
    }
    public boolean addEmployee(EmployeeExercise employee) {
        try {
            // 执行添加员工信息的逻辑
            int result = employeeExerciseMapper.insertSelective(employee);
            // 根据实际需求处理成功与失败的情况，例如记录日志等

            return result == 1; // 返回添加结果
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }



}