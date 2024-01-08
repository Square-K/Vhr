package org.javaboy.vhr.controller.emp;

import org.javaboy.vhr.model.Interview;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.text.ParseException;


@SpringBootTest
@RunWith(SpringRunner.class)
class EmpBasicControllerTest {

    @Autowired
    private EmpBasicController empBasicController;

    @Test
    void testGetEmployeeByPage() throws ParseException {
        Interview interview = new Interview();
        interview.setName("");
        empBasicController.getEmployeeByPage(1,10,interview,null);
    }

    @Test
    void testAddEmp() {
        Interview interview = new Interview();
        interview.setName("张三丰");
        empBasicController.addEmp(interview);
    }

    @Test
    void testDeleteEmpByEid() {
        empBasicController.deleteEmpByEid(0);
    }

    @Test
    void testUpdateEmp() {
        Interview interview = new Interview();
        interview.setId(1);
        interview.setName("张三丰");
        empBasicController.updateEmp(interview);
    }

    @Test
    void testGetAllNations() {
        empBasicController.getAllNations();
    }

    @Test
    void testGetAllPoliticsstatus() {
        empBasicController.getAllPoliticsstatus();
    }

    @Test
    void testGetAllJobLevels() {
        empBasicController.getAllJobLevels();
    }

    @Test
    void testGetAllPositions() {
        empBasicController.getAllPositions();
    }

    @Test
    void testMaxWorkID() {
        empBasicController.maxWorkID();
    }

    @Test
    void testGetAllDepartments() {
        empBasicController.getAllDepartments();
    }

    @Test
    void testExportData() {
        empBasicController.exportData();
    }

    //不知道改如何传参
//    @Test
//    void testImportData() throws IOException {
//        empBasicController.importData(null);
//    }
}