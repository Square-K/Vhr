package org.javaboy.vhr.controller.homework;

import org.javaboy.vhr.model.HomeWork;
import org.javaboy.vhr.model.Interview;
import org.javaboy.vhr.model.RespBean;
import org.javaboy.vhr.service.HomeWorkService;
import org.javaboy.vhr.utils.HomeWorkUtils;
import org.javaboy.vhr.utils.POIUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author 郭雯雯
 * @date 2023/12/20
 */
@RestController
@RequestMapping("/homework")
public class HomeWorkController {
    @Autowired
    HomeWorkService homeWorkService;

    @GetMapping("/{epNum}")
    public List<HomeWork> getHomeWorksByEpNum(@PathVariable Integer epNum){
        return homeWorkService.getHomeWorksByEpNum(epNum);
    }


    @GetMapping("/homeWorksByMinEpNum")
    public List<HomeWork> homeWorksByMinEpNum(){
        Integer minEpNum = homeWorkService.getMinEpNum();
        return getHomeWorksByEpNum(minEpNum);
    }
    /**
     * 获取最小期数
     */
    @GetMapping("/minEpNum")
    public Integer getMinEpNum(){
        return homeWorkService.getMinEpNum();
    }

    @GetMapping("/allEpNums")
    public List<Integer> getAllEpNums(){
        return homeWorkService.getAllEpNums();
    }

    /**
     * 获取所有课程名
     */
    @GetMapping("/getLessonNames")
    public List<String> getLessonNames(){
        return homeWorkService.getLessonNames();
    }

    @PostMapping("/saveEditedRows")
    public ResponseEntity<String> saveEditedRows(@RequestBody List<HomeWork> editedRows) {

        homeWorkService.saveHomeworks(editedRows);
        // 返回一个成功消息
        return new ResponseEntity<>("保存成功！", HttpStatus.OK);
    }

    @PostMapping("/deleteHomeWorks")
    public void deleteHomeWorks(@RequestBody Integer[] ids){
        homeWorkService.deleteHomeWorks(ids);
    }

    @GetMapping("/export/{epNum}")
    public ResponseEntity<byte[]> exportData(@PathVariable Integer epNum) {
        List<HomeWork> list = homeWorkService.getHomeWorksByEpNum(epNum);
        return HomeWorkUtils.homework2Excel(list);
    }

    @PostMapping("/import/{epNum}")
    public RespBean importData(MultipartFile file,@PathVariable Integer epNum) throws IOException {
        List<HomeWork> list = HomeWorkUtils.excel2HomeWork(file);
        if (homeWorkService.addHomeWorks(list,epNum) == list.size()) {
            return RespBean.ok("上传成功");
        }
        return RespBean.error("上传失败");
    }
}
