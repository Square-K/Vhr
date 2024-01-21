package org.javaboy.vhr.service;

import org.javaboy.vhr.mapper.ScoreMapper;
import org.javaboy.vhr.model.Score;
import org.javaboy.vhr.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 张睿
 * @date 2023/12/28
 */
@Service
public class ScoreService {

    @Autowired
    ScoreMapper scoreMapper;

    /**
     * 根据期数获取实训成绩列表
     * @param period
     * @return
     */
    public List<Student> getScoreByPeriod(Integer period){
        return scoreMapper.getScoreByPeriod(period);
    }

    /**
     * 根据期数获取sid
     * @param period
     * @return
     */
    public List<Integer> getSidByPeriod(Integer period){
        return scoreMapper.getSidByPeriod(period);
    }


    /**
     * 获取总分和平均分
     * @return
     */
    public List<Double> getSumAndAvg(Integer sid){
        List<Double> list = new ArrayList<>();
        list.add(scoreMapper.getSum(sid));
        list.add(scoreMapper.getAvg(sid));
        return list;
    }

    /**
     * 获取最小期数
     */
    public Integer getMinPeriod(){
        return scoreMapper.getMinPeriod();
    }

    /**
     * 获取全部期数
     */
    public List<Integer> getAllPeriod(){
        return scoreMapper.getAllPeriod();
    }

    /**
     * 根据学生id修改成绩
     * @param editedRows
     */
    public boolean saveScore(List<Student> editedRows) {
        int success = 0;
        List<Score> scoreList = new ArrayList<>();
        for (Student student : editedRows) {
            scoreList = student.getScores();
            for (Score score : scoreList) {
                scoreMapper.updateScore(score.getId(), score.getScore());
            }
            success = 1;
        }
        return success == 1;
    }

    /**
     * 删除学生和成绩
     * @param ids
     */
    public boolean deleteScoreAndStudent(Integer[] ids){
        int success = 0;
        scoreMapper.deleteStudent(ids);
        for (Integer a : ids){
            scoreMapper.deleteScore(a);
            success = 1;
        }
        return success == 1;
    }

    /**
     * 上传学生成绩
     * @return
     */
    public void addStudent(Student student) {
        Integer sid = student.getSid();
        String name = student.getName();
        Integer period = student.getPeriod();
        scoreMapper.addStudent(sid, name, period);
    }

    /**
     * 上传学生成绩
     * @return
     */
    public void addScore(List<Score> list) {
        scoreMapper.addScore(list);
    }

}
