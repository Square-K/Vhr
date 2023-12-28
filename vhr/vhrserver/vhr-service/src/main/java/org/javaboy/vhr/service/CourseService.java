package org.javaboy.vhr.service;

import org.javaboy.vhr.mapper.CourseMapper;
import org.javaboy.vhr.model.Course;
import org.javaboy.vhr.model.HomeWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseMapper courseMapper;
    /**
     * 根据周数获取所有课程信息
     * @param weekNum
     * @return List<Course>课程表集合
     */
    public List<Course> getAllCourse(Integer weekNum){
        return courseMapper.getAllCourse(weekNum);
    }

    /**
     * 获取周数
     * @return List<Integer>周数集合
     */
    public List<Integer> getAllWeekNums(){
        return courseMapper.getAllWeekNums();
    }

    /**
     * 获取最小周数
     * @return Integer 最小周数
     */
    public Integer getMinWeekNum(){
       return courseMapper.getMinWeekNum();
    }

    /**
     * 根据周数删除课程表
     * @param weekNum
     * @return boolean类型 判断是否删除
     */
    public boolean deleteCourseByWeekNum(Integer weekNum){
        return courseMapper.deleteCourseByWeekNum(weekNum);
    }

    /**
     * 添加课程
     * @param list
     * @param weekNum
     * @return 加入对象个数
     */
    public Integer addCourse(List<Course> list, Integer weekNum) {
        for (Course c : list) {
            c.setWeekNum(weekNum);
        }
        return courseMapper.addCourse(list);
    }

    /**
     * 更新方法
     * @param courseList
     */
    public void saveCourse(List<Course> courseList) {
        for (Course c : courseList) {
            courseMapper.updateCourse(c);
        }
    }
}
