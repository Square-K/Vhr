package org.javaboy.vhr.mapper;

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
public class InterviewMapperTest {

    @Autowired
    private InterviewMapper interviewMapper;

    @Test
    void testDeleteByPrimaryKey() {
        interviewMapper.deleteByPrimaryKey(154);
    }

    @Test
    void testInsert() {
        interviewMapper.insert(null);
    }

    @Test
    void testInsert2() {
        interviewMapper.insert2(null);
    }

    @Test
    void testInsertSelective() {
        Interview interview = new Interview();
        interview.setName("123");
        interviewMapper.insertSelective(interview);
    }

    @Test
    void testSelectByPrimaryKey() {
        interviewMapper.selectByPrimaryKey(1);
    }

    @Test
    void testUpdateByPrimaryKeySelective() {
        Interview interview = new Interview();
        interview.setId(1);
        interview.setName("张三丰");
        interviewMapper.updateByPrimaryKeySelective(interview);
    }

    @Test
    void testUpdateByPrimaryKey() {
        Interview interview = new Interview("李四","男","长江大学","计算机","本科","2023-07-01","123123311212123212","1231231231","123123","N1","学习能力强","2023-06-01","V","2023-06-12","V","V","V","2023-11-01");
        interview.setId(163);
        interviewMapper.updateByPrimaryKey(interview);
    }

    @Test
    void testGetEmployeeByPage() {
        Interview interview = new Interview();
        interview.setName("");
        interviewMapper.getEmployeeByPage(1,10,interview,null);
    }

    @Test
    void testGetTotal() {
        interviewMapper.getTotal(null,null);
    }

    @Test
    void testMaxWorkID() {
        interviewMapper.maxWorkID();
    }

    @Test
    void testAddEmps() {
        List<Interview> list = new ArrayList<Interview>();
        Interview interview = new Interview("李四","男","长江大学","计算机","本科","2023-07-01","123123311212123212","1231231231","123123","N1","学习能力强","2023-06-01","V","2023-06-12","V","V","V","2023-11-01");
        list.add(interview);
        interviewMapper.addEmps(list);
    }

    @Test
    void testGetEmployeeById() {
        interviewMapper.getEmployeeById(1);
    }

    @Test
    void testGetEmployeeByIdCard() {
        interviewMapper.getEmployeeByIdCard("");
    }

    @Test
    void testGetEmployeeByPhone() {
        interviewMapper.getEmployeeByPhone("");
    }

    //未用到此方法,不清楚传入参数
//    @Test
//    void testGetEmployeeByPageWithSalary() {
//        interviewMapper.getEmployeeByPageWithSalary();
//    }
//
//    @Test
//    void testUpdateEmployeeSalaryById() {
//        interviewMapper.updateEmployeeSalaryById();
//    }
}
