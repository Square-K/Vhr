package org.javaboy.vhr.controller.score;

import org.javaboy.vhr.model.RespBean;
import org.javaboy.vhr.model.Score;
import org.javaboy.vhr.model.Student;
import org.javaboy.vhr.service.ScoreService;
import org.javaboy.vhr.utils.ScoreUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 张睿
 * @date 2023/12/28
 */
@RestController
@RequestMapping("/score")
public class ScoreController {
    @Autowired
    ScoreService scoreService;

    /**
     * 根据期数获取实训成绩列表
     * @param period
     * @return
     */
    @GetMapping("/{period}")
    public List<Student> getScoreByPeriod(@PathVariable Integer period){
        List<Student> list = new ArrayList<>();
        list = scoreService.getScoreByPeriod(period);
        List<Integer> list2 = scoreService.getSidByPeriod(period);
        for (Integer sid : list2){
            for (Student student : list){
                if(student.getSid().equals(sid)){
                    student.setSumAndAvg(scoreService.getSumAndAvg(sid));
                }
            }
        }
        return list;
    }

//    /**
//     * 获取总分和平均分
//     * @return
//     */
//    @GetMapping("/SumAndAvg/{period}")
//    public List<List<Double>> getSumAndAvg(@PathVariable Integer period){
//        List<Integer> list = scoreService.getSidByPeriod(period);
//        List<List<Double>> list2 = new ArrayList<>();
//        for (Integer sid : list){
//            list2.add(scoreService.getSumAndAvg(sid));
//        }
//        return list2;
//    }

    /**
     * 获取最小期数数据
     */
    @GetMapping("/scoreByMinPeriod")
    public List<Student> scoreByMinPeriod(){
        Integer minEpNum = scoreService.getMinPeriod();
        return getScoreByPeriod(minEpNum);
    }

    /**
     * 获取最小期数
     */
    @GetMapping("/minPeriod")
    public Integer getMinPeriod(){
        return scoreService.getMinPeriod();
    }

    /**
     * 获取全部期数
     */
    @GetMapping("/allPeriod")
    public List<Integer> getAllPeriod(){
        return scoreService.getAllPeriod();
    }

    /**
     * 删除学生和成绩
     */
    @PostMapping("/deleteScore")
    public void deleteScore(@RequestBody Integer[] ids){
        scoreService.deleteScoreAndStudent(ids);
    }

    /**
     * 保存修改数据
     */
    @PostMapping("/saveEditedRows")
    public ResponseEntity<String> saveEditedRows(@RequestBody List<Student> editedRows) {
        scoreService.saveScore(editedRows);
        // 返回一个成功消息
        return new ResponseEntity<>("保存成功！", HttpStatus.OK);
    }

    @GetMapping("/export/{period}")
    public ResponseEntity<byte[]> exportData(@PathVariable Integer period) {
        List<Student> list = getScoreByPeriod(period);
        return ScoreUtils.homework2Excel(list);
    }

    @PostMapping("/import")
    public RespBean importData(MultipartFile file) throws IOException {
        List<Student> list = ScoreUtils.excel2HomeWork(file);
        System.out.println(list);
        for(Student student : list){
            scoreService.addStudent(student);
            for(Score score : student.getScores()){
                score.setSid(student.getSid());
            }
            System.out.println(list);
            scoreService.addScore(student.getScores());
        }
        return RespBean.ok("上传成功");
    }

}
