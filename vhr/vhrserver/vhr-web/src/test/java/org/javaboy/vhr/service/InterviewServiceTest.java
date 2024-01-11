package org.javaboy.vhr.service;

import org.javaboy.vhr.model.Interview;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class InterviewServiceTest {

    @Autowired
    private InterviewService interviewService;

    @Test
    void testGetEmployeeByPage() {
        Interview interview = new Interview();
        interview.setName("");
        interviewService.getEmployeeByPage(1,10,interview,null);
    }

    @Test
    void testAddEmp() {
        Interview interview = new Interview();
        interview.setName("张三丰");
        interview.setIdCard("123456789012345678");
        interviewService.addEmp(interview);
    }

    @Test
    void testAddEmp2() {
        Interview interview = new Interview();
        interview.setName("张三丰");
        interview.setIdCard("123456789012345678");
        interviewService.addEmp(interview);
    }

    @Test
    void testMaxWorkID() {
        interviewService.maxWorkID();
    }

    @Test
    void testDeleteEmpByEid() {
        interviewService.deleteEmpByEid(155);
    }

    @Test
    void testUpdateEmp() {
        Interview interview = new Interview();
        interview.setId(1);
        interview.setName("张三丰");
        interviewService.updateEmp(interview);
    }

    @Test
    void testAddEmps() {
        List<Interview> list = new ArrayList<Interview>();
        Interview interview = new Interview("李四","男","长江大学","计算机","本科","2023-07-01","123123311212123212","1231231231","123123","N1","学习能力强","2023-06-01","V","2023-06-12","V","V","V","2023-11-01");
        list.add(interview);
        interviewService.addEmps(list);
    }

    //没用到此方法
//    @Test
//    void testGetEmployeeByPageWithSalary() {
//        interviewService.getEmployeeByPageWithSalary();
//    }
//
//    @Test
//    void testUpdateEmployeeSalaryById() {
//        interviewService.updateEmployeeSalaryById();
//    }

    @Test
    void testGetEmployeeById() {
        interviewService.getEmployeeById(1);
    }
}
