package org.javaboy.vhr.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseMapperTest {
    @Autowired
    CourseMapper courseMapper;
    @Test
    void getAllCourse() {
        courseMapper.getAllCourse(1);
    }

    @Test
    void getAllWeekNums() {
        courseMapper.getAllWeekNums();
    }

    @Test
    void getMinWeekNum() {
        courseMapper.getMinWeekNum();
    }

    @Test
    void deleteCourseByWeekNum() {
        courseMapper.deleteCourseByWeekNum(10);
    }

//    @Test
//    void addCourse() {
//        courseMapper.addCourse();
//    }
//
//    @Test
//    void updateCourse() {
//        courseMapper.updateCourse();
//    }
}