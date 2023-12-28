package org.javaboy.vhr.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.javaboy.vhr.model.Course;
import org.javaboy.vhr.model.HomeWork;

import java.util.List;
@Mapper
public interface CourseMapper {
    //根据周数获取所有课程信息
    List<Course> getAllCourse(Integer weekNum);
    //获取周数
    List<Integer> getAllWeekNums();
    //获取最小周数
    Integer getMinWeekNum();
    //根据周数删除课程表
    boolean deleteCourseByWeekNum(Integer weekNum);
    //添加课程数据
    Integer addCourse(@Param("list") List<Course> list);
    //根据id更新课程名
    boolean updateCourse(Course course);
}
