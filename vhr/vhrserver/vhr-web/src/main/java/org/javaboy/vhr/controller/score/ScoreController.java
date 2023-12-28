package org.javaboy.vhr.controller.score;

import org.javaboy.vhr.model.RespBean;
import org.javaboy.vhr.model.Score;
import org.javaboy.vhr.service.ScoreService;
import org.javaboy.vhr.utils.ScoreUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    @GetMapping("/{epNum}")
    public List<Score> getScoreByEpNum(@PathVariable Integer epNum){
        return scoreService.getScoreByEpNum(epNum);
    }


    @GetMapping("/scoreByMinEpNum")
    public List<Score> scoreByMinEpNum(){
        Integer minEpNum = scoreService.getMinEpNum();
        return getScoreByEpNum(minEpNum);
    }
    /**
     * 获取最小期数
     */
    @GetMapping("/minEpNum")
    public Integer getMinEpNum(){
        return scoreService.getMinEpNum();
    }

    @GetMapping("/allEpNums")
    public List<Integer> getAllEpNums(){
        return scoreService.getAllEpNums();
    }

    /**
     * 获取所有课程名
     */
    @GetMapping("/getLessonNames")
    public List<String> getLessonNames(){
        return scoreService.getLessonNames();
    }

    @PostMapping("/saveEditedRows")
    public ResponseEntity<String> saveEditedRows(@RequestBody List<Score> editedRows) {

        scoreService.saveScore(editedRows);
        // 返回一个成功消息
        return new ResponseEntity<>("保存成功！", HttpStatus.OK);
    }

    @PostMapping("/deleteScore")
    public void deleteScore(@RequestBody Integer[] ids){
        scoreService.deleteScore(ids);
    }

    @GetMapping("/export/{epNum}")
    public ResponseEntity<byte[]> exportData(@PathVariable Integer epNum) {
        List<Score> list = scoreService.getScoreByEpNum(epNum);
        return ScoreUtils.homework2Excel(list);
    }

    @PostMapping("/import/{epNum}")
    public RespBean importData(MultipartFile file,@PathVariable Integer epNum) throws IOException {
        List<Score> list = ScoreUtils.excel2HomeWork(file);
        if (scoreService.addScore(list,epNum) == list.size()) {
            return RespBean.ok("上传成功");
        }
        return RespBean.error("上传失败");
    }
}
