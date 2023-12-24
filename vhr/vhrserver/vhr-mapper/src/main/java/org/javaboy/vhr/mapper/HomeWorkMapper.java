package org.javaboy.vhr.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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

    Integer getMinEpNum();

    List<Integer> getAllEpNums();

    /**
     * 获取所有课程名
     * @return
     */
    public List<String> getLessonNames();

    //根据id更新homework数据
    public boolean updateHomework(HomeWork h);

    public void deleteHomeWorks(Integer[] ids);

    Integer addHomeWorks(@Param("list") List<HomeWork> list);
}
