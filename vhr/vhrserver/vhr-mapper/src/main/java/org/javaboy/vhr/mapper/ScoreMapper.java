package org.javaboy.vhr.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.javaboy.vhr.model.Score;
import org.javaboy.vhr.model.Student;

import java.util.List;

/**
 * @author 张睿
 * @date 2023/12/28
 */
@Mapper
public interface ScoreMapper {

    /**
     * 根据期数获取实训成绩列表
     * @param period
     * @return 指定期数的实训成绩列表
     */
    List<Student> getScoreByPeriod(@Param("period") Integer period);

    /**
     * 根据期数获取sid
     * @return
     */
    List<Integer> getSidByPeriod(@Param("period") Integer period);

    /**
     * 获取总分
     * @return
     */
    Double getSum(@Param("sid") Integer sid);

    /**
     * 获取平均分
     * @return
     */
    Double getAvg(@Param("sid") Integer sid);

    /**
     * 获取最小期数
     */
    Integer getMinPeriod();

    /**
     * 获取全部期数
     */
    List<Integer> getAllPeriod();

    /**
     * 根据学生id修改成绩
     * @param score
     */
    void updateScore(@Param("id") Integer id, @Param("score") Integer score);

    /**
     * 删除学生成绩
     * @param sid
     */
    void deleteScore(@Param("id") Integer sid);

    /**
     * 删除学生
     * @param ids
     */
    void deleteStudent(Integer[] ids);

    /**
     * 上传学生
     * @param
     * @return
     */
    void addStudent(@Param("sid") Integer sid, @Param("name") String name, @Param("period") Integer period);

    /**
     * 上传学生成绩
     * @return
     */
    void addScore(@Param("list") List<Score> list);

}
