package org.javaboy.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.javaboy.vhr.model.Interview;

import java.util.Date;
import java.util.List;

public interface InterviewMapper {

    int deleteByPrimaryKey(Integer id);//2

    int insert(Interview record);//4

    int insertSelective(Interview record);//5

    Interview selectByPrimaryKey(Integer id);//1

    int updateByPrimaryKeySelective(Interview record);//6

    int updateByPrimaryKey(Interview record);//7

    List<Interview> getEmployeeByPage(@Param("page") Integer page, @Param("size") Integer size, @Param("emp") Interview interview,@Param("beginDateScope") Date[] beginDateScope);

    Long getTotal(@Param("emp") Interview employee,@Param("beginDateScope") Date[] beginDateScope);

    Integer maxWorkID();

    Integer addEmps(@Param("list") List<Interview> list);//3

    Interview getEmployeeById(Integer id);

    Interview getEmployeeByIdCard(String idCard);

    List<Interview> getEmployeeByPageWithSalary(@Param("page") Integer page, @Param("size") Integer size);

    Integer updateEmployeeSalaryById(@Param("eid") Integer eid, @Param("sid") Integer sid);
}