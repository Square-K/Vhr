package org.javaboy.vhr.controller.score;

import org.javaboy.vhr.model.Student;
import org.javaboy.vhr.service.ScoreService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class ScoreControllerTest {

    @Autowired
    ScoreController scoreController;

    @Autowired
    ScoreService scoreService;

    @Test
    void getScoreByPeriod() {
        List<Student> list = scoreController.getScoreByPeriod(5);
        if(list.size() == 0){
            System.out.println("null");
        }
        System.out.println(list);
    }

//    @Test
//    void getSumAndAvg() {
//        List<List<Double>> list = scoreController.getSumAndAvg(1);
//        System.out.println(list);
//    }

    @Test
    void scoreByMinPeriod() {
        List<Student> list = scoreController.scoreByMinPeriod();
        System.out.println(list);
    }

    @Test
    void getMinPeriod() {
        scoreController.getMinPeriod();
    }

    @Test
    void getAllPeriod() {
        scoreController.getAllPeriod();
    }

    @Test
    void deleteScore() {
    }
}