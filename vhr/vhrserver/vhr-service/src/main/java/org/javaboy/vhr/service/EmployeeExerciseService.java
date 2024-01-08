package org.javaboy.vhr.service;

import org.javaboy.vhr.mapper.EmployeeExerciseMapper;
import org.javaboy.vhr.model.EmployeeExerciseSearchResult;
import org.javaboy.vhr.model.Interview;
import org.javaboy.vhr.model.RespPageBean;
import org.springframework.stereotype.Service;
import org.javaboy.vhr.model.EmployeeExercise;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
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
            int result = employeeExerciseMapper.insertSelective(employee);

            return result == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    @Transactional
    public boolean updateEmployee(EmployeeExercise updatedEmployee) {
        try {
            // 直接使用传入的更新后的员工信息
            int result = employeeExerciseMapper.updateByPrimaryKeySelective(updatedEmployee);

            // 检查更新是否成功
            return result == 1;
        } catch (Exception e) {
            e.printStackTrace();
            // 根据需要处理异常或记录日志
            return false;
        }
    }




}