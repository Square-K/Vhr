package org.javaboy.vhr.service;

import org.javaboy.vhr.mapper.EmployeeMapper;
import org.javaboy.vhr.model.Employee;
import org.javaboy.vhr.model.EmployeeSearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * carry
 */
@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

    public List<EmployeeSearchResult> searchEmployee(String name) {
        return employeeMapper.searchEmployee(name);
    }

}
