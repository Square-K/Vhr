package org.javaboy.vhr.service;

import org.javaboy.vhr.mapper.HomeWorkMapper;
import org.javaboy.vhr.model.HomeWork;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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





}
