package org.javaboy.vhr.controller.emp;

import org.javaboy.vhr.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * carry
 */
@RestController
@RequestMapping("/employeem")
public class EmpController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/search")
    public Map getEmployeeByPage(@RequestParam(value = "name", required = false) String name) {
        Map<String, Object> resultMap = new HashMap<>();
        try{  resultMap.put("result", employeeService.searchEmployee(name));}
        catch (Exception e){
            System.out.println(e);
        }

        return resultMap;
    }


}
