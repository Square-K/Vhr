package org.javaboy.vhr.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.javaboy.vhr.model.Score;

import java.util.List;

/**
 * @author 张睿
 * @date 2023/12/28
 */
@Mapper
public interface ScoreMapper {

    /**
     * 根据期数获取实训成绩列表
     * @param epNum
     * @return 指定期数的实训成绩列表
     */
    List<Score> getScoreByEpNum(Integer epNum);

    Integer getMinEpNum();

    List<Integer> getAllEpNums();

    /**
     * 获取所有课程名
     * @return
     */
    public List<String> getLessonNames();

    //根据id更新Score数据
    public boolean updateScore(Score s);

    public void deleteScore(Integer[] ids);

    Integer addScore(@Param("list") List<Score> list);

}
