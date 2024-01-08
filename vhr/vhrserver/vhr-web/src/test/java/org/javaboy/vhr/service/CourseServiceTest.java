package org.javaboy.vhr.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseServiceTest {
    @Autowired
    CourseService courseService;
    @Test
    void getAllCourse() {
        courseService.getAllCourse(1);
    }

    @Test
    void getAllWeekNums() {
        courseService.getAllWeekNums();
    }

    @Test
    void getMinWeekNum() {
        courseService.getMinWeekNum();
    }

    @Test
    void deleteCourseByWeekNum() {
        courseService.deleteCourseByWeekNum(10);
    }

//    @Test
//    void addCourse() {
//        courseService.addCourse();
//    }
//
//    @Test
//    void saveCourse() {
//        courseService.saveCourse();
//    }
}