package org.javaboy.vhr.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.javaboy.vhr.model.HomeWork;

import java.util.List;

/**
 * @author 郭雯雯
 * @date 2023/12/20
 */
@Mapper
public interface HomeWorkMapper {

    /**
     * 根据期数获取作业列表
     * @param epNum
     * @return 指定期数的作业列表
     */
    List<HomeWork> getHomeWorksByEpNum(Integer epNum);

}
