package org.javaboy.vhr.controller.emp;

import org.javaboy.vhr.model.EmployeeExercise;
import org.javaboy.vhr.model.Interview;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class EmpeControllerTest {

    @Autowired
    private EmpeController empeController;

    @Test
    void testGetEmployeeByPage() {
        empeController.getEmployeeByPage("张三");
    }

    @Test
    void testdeleteByPrimaryKey() {
        empeController.deleteByPrimaryKey(170);
    }

    @Test
    void testSearchEmployeesByCriteria() {
        empeController.searchEmployeesByCriteria("22","22","22",3);
    }

    @Test
    void testAddInterview() {
        Interview interview = new Interview("李四","男","长江大学","计算机","本科","2023-07-01","123123311212123212","1231231231","123123","N1","学习能力强","2023-06-01","V","2023-06-12","V","V","V","2023-11-01");
        empeController.addInterview(interview);
    }

    @Test
    void testAddEmployeeExercise() {
        EmployeeExercise employeeExercise = new EmployeeExercise();
        employeeExercise.setStudyProgress("好");
        employeeExercise.setWorkState(0);
        employeeExercise.setStudyAbility("很好");
        employeeExercise.setJapaneseSituation("流利");
        empeController.addEmployeeExercise(employeeExercise);
    }

    @Test
    void testUpdateEmployeeExercise() {
        EmployeeExercise employeeExercise = new EmployeeExercise();
        employeeExercise.setStudyProgress("好");
        employeeExercise.setWorkState(0);
        employeeExercise.setStudyAbility("很好");
        employeeExercise.setJapaneseSituation("流利");
        empeController.updateEmployeeExercise(5,employeeExercise);
    }

    @Test
    void testExportData() {
        empeController.exportData("李四");
    }

    @Test
    void testImportData() {
        empeController.importData(null);
    }
}