package org.javaboy.vhr.service;

import org.javaboy.vhr.mapper.HomeWorkMapper;
import org.javaboy.vhr.model.HomeWork;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author 郭雯雯
 * @date 2023/12/20
 */
@Service
public class HomeWorkService {

    @Autowired
    HomeWorkMapper homeWorkMapper;
    //打印日志
    public final static Logger logger = LoggerFactory.getLogger(InterviewService.class);

    public List<HomeWork> getHomeWorksByEpNum(Integer epNum){
        return homeWorkMapper.getHomeWorksByEpNum(epNum);
    }

    public Integer getMinEpNum(){
        return homeWorkMapper.getMinEpNum();
    }

    public List<Integer> getAllEpNums(){
        return homeWorkMapper.getAllEpNums();
    }


    public List<String> getLessonNames(){
        return homeWorkMapper.getLessonNames();
    }


    public void saveHomeworks(List<HomeWork> editedRows) {
        for (HomeWork h : editedRows) {
            //修改课程等级
             h.setLeOrder(updateLeOrder(h.getLessonName()));
            boolean b = homeWorkMapper.updateHomework(h);

        }
    }
    //根据课程名设置课程等级
    public Integer updateLeOrder(String lessonName){
        //1.html 2.sql 3.java基础 4.js 5.java高级  6. hibernate7.struts 8.spring 9.ssh整合 10.mybatis  11.springmvc  12.ssm整合 13.bootstrap
        Integer leOrder = 0;
        if ("html".equals(lessonName)){
            leOrder=1;
        } else if ("sql".equals(lessonName)) {
            leOrder=2;
        }else if ("java基础".equals(lessonName)) {
            leOrder=3;
        }else if ("js".equals(lessonName)) {
            leOrder=4;
        }else if ("java高级".equals(lessonName)) {
            leOrder=5;
        }else if ("hibernate".equals(lessonName)) {
            leOrder=6;
        }else if ("struts".equals(lessonName)) {
            leOrder=7;
        }else if ("spring".equals(lessonName)) {
            leOrder=8;
        }else if ("ssh整合".equals(lessonName)) {
            leOrder=9;
        }else if ("mybatis".equals(lessonName)) {
            leOrder=10;
        }else if ("springmvc".equals(lessonName)) {
            leOrder=11;
        }else if ("ssm整合".equals(lessonName)) {
            leOrder=12;
        }else if ("bootstrap".equals(lessonName)) {
            leOrder=13;
        }
        return leOrder;
    }

    public void deleteHomeWorks(Integer[] ids){
        homeWorkMapper.deleteHomeWorks(ids);
    }

    public Integer addHomeWorks(List<HomeWork> list, Integer epNum) {
        for (HomeWork h : list) {
            h.setEpNum(epNum);
            h.setLeOrder(updateLeOrder(h.getLessonName()));
        }
        return homeWorkMapper.addHomeWorks(list);
    }
}
