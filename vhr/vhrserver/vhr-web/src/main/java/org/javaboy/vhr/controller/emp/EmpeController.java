package org.javaboy.vhr.controller.emp;

import org.javaboy.vhr.model.EmployeeExercise;
import org.javaboy.vhr.model.RespBean;
import org.javaboy.vhr.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.javaboy.vhr.model.Interview;

import java.util.HashMap;
import java.util.Map;

/**
 * carry
 */
@RestController
@RequestMapping("/employeeExercise")
public class EmpeController {
    @Autowired
    EmployeeExerciseService employeeExerciseService;

    @Autowired
    InterviewService interviewService;

    @GetMapping("/search")
    public Map<String, Object> getEmployeeByPage(@RequestParam(value = "name", required = false) String name) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            resultMap.put("result", employeeExerciseService.searchEmployee(name));
        } catch (Exception e) {
           e.printStackTrace();
        }
        return resultMap;
    }
    @DeleteMapping("/{id}")
    public RespBean deleteByPrimaryKey(@PathVariable Integer id) {
        if (employeeExerciseService.deleteByPrimaryKey(id) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    @GetMapping("/searchByCriteria")
    public Map<String, Object> searchEmployeesByCriteria(
            @RequestParam(value = "japaneseSituation", required = false) String japaneseSituation,
            @RequestParam(value = "studyAbility", required = false) String studyAbility,
            @RequestParam(value = "studyProgress", required = false) String studyProgress,
            @RequestParam(value = "workState", required = false) Integer workState) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            resultMap.put("employees", employeeExerciseService.searchEmployeesByCriteria(
                    japaneseSituation, studyAbility, studyProgress, workState));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultMap;
    }

//    @PostMapping("/addInterview")
//    public RespBean addInterview(@RequestBody Interview interview) {
////        try {
////            // 调用添加单个面试信息的方法
//////            Integer result = interviewService.addEmps(interview);
//////            if (result != null) {
//////                return RespBean.ok("添加面试信息成功！");
//////            } else {
//////                return RespBean.error("添加面试信息失败，请重试！");
//////            }
////        } catch (Exception e) {
////            e.printStackTrace();
////            return RespBean.error("添加面试信息失败，请重试！");
////        }
//    }



    @PostMapping("/addEmployeeExercise")
    public RespBean addEmployeeExercise(@RequestBody EmployeeExercise employee) {
        try {
            boolean success = employeeExerciseService.addEmployee(employee);
            if (success) {
                return RespBean.ok("添加用户成功！");
            } else {
                return RespBean.error("添加用户失败，请重试！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return RespBean.error("添加用户失败，请重试！");
        }
    }


}







