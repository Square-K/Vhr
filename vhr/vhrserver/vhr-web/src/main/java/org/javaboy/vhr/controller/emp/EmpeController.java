package org.javaboy.vhr.controller.emp;

import org.javaboy.vhr.model.EmployeeExercise;
import org.javaboy.vhr.model.EmployeeExerciseSearchResult;
import org.javaboy.vhr.model.RespBean;
import org.javaboy.vhr.service.*;
import org.javaboy.vhr.utils.EmployeeExerciseUtils;
import org.javaboy.vhr.utils.POIUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.javaboy.vhr.model.Interview;
import org.springframework.http.HttpStatus;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
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
    //获取遍历界面信息
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
    //根据id删除员工信息
    @DeleteMapping("/{id}")
    public RespBean deleteByPrimaryKey(@PathVariable Integer id) {
        if (employeeExerciseService.deleteByPrimaryKey(id) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }
    //高级搜索
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
    //添加到interview表
    @PostMapping("/addInterview")
    public RespBean addInterview(@RequestBody Interview interview) {
        try {
            Interview newInterview = interviewService.addEmp2(interview);
            if (newInterview != null && newInterview.getId() != null) {
                // 在成功时将面试信息对象设置到obj字段中
                return RespBean.ok("添加面试信息成功！", newInterview);
            } else {
                return RespBean.error("添加面试信息失败，请重试！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return RespBean.error("添加面试信息失败，请重试！");
        }
    }



    //添加到employee_exercise表
    @PostMapping("/addEmployeeExercise")
    public RespBean addEmployeeExercise(@RequestBody EmployeeExercise employee) {
        try {
            // 检查参数，确保传递了面试信息的id以及其他必要字段
            if (employee.getId() == null || employee.getJapaneseSituation() == null || employee.getStudyAbility() == null || employee.getStudyProgress() == null || employee.getWorkState() == null) {
                return RespBean.error("参数错误，缺少必要字段！");
            }

            // 进行员工信息的插入操作
            boolean success = employeeExerciseService.addEmployee(employee);

            if (success) {
                return RespBean.ok("添加用户成功！");
            } else {
                return RespBean.error("添加用户失败，请重试！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return RespBean.error("添加用户失败，发生异常：" + e.getMessage());
        }
    }
    //更新员工信息
    @PutMapping("/update/{id}")
    public RespBean updateEmployeeExercise(@PathVariable Integer id, @RequestBody EmployeeExercise updatedEmployee) {
        try {
            // 直接使用传入的更新后的员工信息进行更新
            boolean success = employeeExerciseService.updateEmployee(updatedEmployee);

            if (success) {
                return RespBean.ok("更新用户成功！");
            } else {
                return RespBean.error("更新用户失败，请重试！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return RespBean.error("更新用户失败，发生异常：" + e.getMessage());
        }
    }

    //导出文件
    @GetMapping("/total")
    public ResponseEntity<byte[]> exportData(@RequestParam(value = "name", required = false) String employeeName) {
        if (employeeName == null) {

        }
        List<EmployeeExerciseSearchResult> list = employeeExerciseService.searchEmployee(employeeName);
        return EmployeeExerciseUtils.employeeExercise2Excel(list);
    }

    //导入文件
    @PostMapping("/import")
    public RespBean importData(@RequestParam("file") MultipartFile file) {
        try {
            List<EmployeeExerciseSearchResult> importedData = EmployeeExerciseUtils.excel2EmployeeExercise(file);

            for (EmployeeExerciseSearchResult employeeExerciseSearchResult : importedData) {
                Interview interview = new Interview();

                Interview newInterview = interviewService.addEmp2(interview);

                EmployeeExercise employeeExercise = new EmployeeExercise();
                employeeExercise.setId(newInterview.getId());

                employeeExerciseService.addEmployee(employeeExercise);
            }

            return RespBean.ok("上传成功");
        } catch (Exception e) {
            e.printStackTrace();
            return RespBean.error("上传失败：" + e.getMessage());
        }
    }





}







