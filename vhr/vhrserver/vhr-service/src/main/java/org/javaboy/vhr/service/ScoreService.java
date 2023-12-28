package org.javaboy.vhr.service;

import org.javaboy.vhr.mapper.ScoreMapper;
import org.javaboy.vhr.model.Score;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 张睿
 * @date 2023/12/28
 */
@Service
public class ScoreService {

    @Autowired
    ScoreMapper scoreMapper;
    //打印日志
    public final static Logger logger = LoggerFactory.getLogger(InterviewService.class);

    public List<Score> getScoreByEpNum(Integer epNum){
        return scoreMapper.getScoreByEpNum(epNum);
    }

    public Integer getMinEpNum(){
        return scoreMapper.getMinEpNum();
    }

    public List<Integer> getAllEpNums(){
        return scoreMapper.getAllEpNums();
    }

    public List<String> getLessonNames(){
        return scoreMapper.getLessonNames();
    }

    public void saveScore(List<Score> editedRows) {
        for (Score s : editedRows) {
            //修改课程等级
            s.setLeOrder(updateLeOrder(s.getLessonName()));
            boolean b = scoreMapper.updateScore(s);

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

    public void deleteScore(Integer[] ids){
        scoreMapper.deleteScore(ids);
    }

    public Integer addScore(List<Score> list, Integer epNum) {
        for (Score s : list) {
            s.setEpNum(epNum);
            s.setLeOrder(updateLeOrder(s.getLessonName()));
        }
        return scoreMapper.addScore(list);
    }
}
