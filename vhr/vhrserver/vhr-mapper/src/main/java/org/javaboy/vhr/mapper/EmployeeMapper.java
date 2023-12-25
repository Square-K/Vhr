package org.javaboy.vhr.mapper;


import org.javaboy.vhr.model.EmployeeSearchResult;

import java.util.List;

public interface EmployeeMapper {

    List<EmployeeSearchResult> searchEmployee(String name);

    int deleteEmpByEid(Integer id);
}