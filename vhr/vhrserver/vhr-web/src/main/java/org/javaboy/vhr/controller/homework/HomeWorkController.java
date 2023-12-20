package org.javaboy.vhr.controller.homework;

import org.javaboy.vhr.model.HomeWork;
import org.javaboy.vhr.service.HomeWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 郭雯雯
 * @date 2023/12/20
 */
@RestController
@RequestMapping("")
public class HomeWorkController {
    @Autowired
    HomeWorkService homeWorkService;

    @GetMapping("/")
    public List<HomeWork> getHomeWorksByEpNum(Integer epNum){
        return homeWorkService.getHomeWorksByEpNum(epNum);
    }
}
