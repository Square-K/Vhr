package org.javaboy.vhr.controller.system.basic;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CourseControllerTest {
    @Autowired
    private CourseController courseController;
    @Test
    void testGetAllCourse() {
        courseController.getAllCourse(1);
        courseController.getAllCourse(2);
        courseController.getAllCourse(10);
        courseController.getAllCourse(11);
        courseController.getAllCourse(100);
        courseController.getAllCourse(1000);
    }

    @Test
    void testGetAllWeekNums() {
        courseController.getAllWeekNums();
    }

    @Test
    void testGetMinWeekNum() {
        courseController.getMinWeekNum();
    }

    @Test
    void testCourseByMinWeekNum() {
        courseController.courseByMinWeekNum();
    }

    @Test
    void testDeleteCourseByWeekNum() {
        courseController.deleteCourseByWeekNum(11);
    }

    @Test
    void testExportData() {
        courseController.exportData(1);
    }
    /**
     * 目前还不知道怎么加载参数
     */
    //    @Test
    //    void testImportData() {
    //        courseController.importData();
    //    }
    //
    //    @Test
    //    void testSaveEditedRows() {
    //        courseController.saveEditedRows();
    //    }
}