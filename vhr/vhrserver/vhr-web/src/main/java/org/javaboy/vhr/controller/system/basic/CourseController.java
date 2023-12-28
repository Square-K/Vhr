package org.javaboy.vhr.controller.system.basic;

import cn.hutool.Hutool;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.sun.corba.se.spi.orbutil.fsm.Guard;
import com.sun.net.httpserver.Authenticator;
import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.ibatis.annotations.Result;
import org.apache.poi.ss.usermodel.Row;
import org.javaboy.vhr.model.Course;
import org.javaboy.vhr.model.HomeWork;
import org.javaboy.vhr.model.RespBean;
import org.javaboy.vhr.service.CourseService;
import org.javaboy.vhr.utils.CourseUtils;
import org.javaboy.vhr.utils.HomeWorkUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.naming.spi.DirStateFactory;
import javax.xml.ws.Response;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    CourseService courseService;

    /**
     * 根据周数获取所有的课程并转换成{section:{num:'',time:''},mon{course},tue{}...}格式
     * @param weekNum 周数
     * @return jsonobject对象的集合
     */
    @GetMapping("/courseTable/{weekNum}")
    public List<JSONObject> getAllCourse(@PathVariable Integer weekNum){
        //通过获取课程表方法得到courselist
        List<Course> courseList = courseService.getAllCourse(weekNum);
        //利用hutool创建jsonobject集合
        List<JSONObject>list = CollectionUtil.newArrayList();
        //创建五个jsonobject对象存储固定的节数
        JSONObject jsonObject1 =new JSONObject();
        JSONObject jsonObject2 =new JSONObject();
        JSONObject jsonObject3 =new JSONObject();
        JSONObject jsonObject4 =new JSONObject();
        JSONObject jsonObject5 =new JSONObject();
        //以键值对的形式存储节数
        jsonObject1.set("section",JSONUtil.parseObj("{\"num\":\"第一大节\",\"time\":\"8:00-9:40\"}"));
        jsonObject2.set("section",JSONUtil.parseObj("{\"num\":\"第二大节\",\"time\":\"10:00-11:40\"}"));
        jsonObject3.set("section",JSONUtil.parseObj("{\"num\":\"第三大节\",\"time\":\"14:00-15:40\"}"));
        jsonObject4.set("section",JSONUtil.parseObj("{\"num\":\"第四大节\",\"time\":\"16:00-17:40\"}"));
        jsonObject5.set("section",JSONUtil.parseObj("{\"num\":\"第五大节\",\"time\":\"19:00-20:40\"}"));
        //将对象都加入到jsonobject集合中
        list.add(jsonObject1);
        list.add(jsonObject2);
        list.add(jsonObject3);
        list.add(jsonObject4);
        list.add(jsonObject5);
        //循环courselist集合
        courseList.forEach(course -> {
            //从course对象获取星期和节数
            String week = course.getWeek();
            String section =course.getSection();
            //根据节数储存course对象形式大概为{mon:{course},tue:{course},wes:{course}...}
            switch (section ){
                case "一":
                    setJson(week,course,jsonObject1);
                    break;
                case "二":
                    setJson(week,course,jsonObject2);
                    break;
                case "三":
                    setJson(week,course,jsonObject3);
                    break;
                case "四":
                    setJson(week,course,jsonObject4);
                    break;
                case "五":
                    setJson(week,course,jsonObject5);
                    break;
            }
        });
        //最终list里面的格式为{section:{num:'',time:''},mon:{course},tue:{course}...}这里的course是对象，里面包含id，name等属性，详情见实体类Course
        return list;
    }

    /**
     *
     * @param week 星期
     * @param course 课程对象
     * @param jsonObject json对象
     * @return 返回一个格式为{mon:course}，{tue:course}...的对象
     */
    private JSONObject setJson(String week,Course course,JSONObject jsonObject){
        if("周一".equals(week)){
            jsonObject.set("mon",course);
        }else if("周二".equals(week)){
            jsonObject.set("tue",course);
        }else if("周三".equals(week)){
            jsonObject.set("wes",course);
        }else if("周四".equals(week)){
            jsonObject.set("thu",course);
        }else if("周五".equals(week)){
            jsonObject.set("fri",course);
        }else if("周六".equals(week)){
            jsonObject.set("sat",course);
        }else if("周日".equals(week)){
            jsonObject.set("sun",course);
        }
        JSONObject js = jsonObject;
        return jsonObject;
    }

    /**
     * 查询所有周数
     * @return 返回周数集合 List<Integer>
     */
    @GetMapping("/allWeekNums")
    public List<Integer> getAllWeekNums(){
        return courseService.getAllWeekNums();
    }

    /**
     * 获取最小期数
     */
    @GetMapping("/minWeekNum")
    public Integer getMinWeekNum(){
        return courseService.getMinWeekNum();
    }

    /**
     * 根据最小期数查询所有课程
     * @return 存储格式为josnobject集合的课程表
     */
    @GetMapping("/courseByMinWeekNum")
    public List<JSONObject> courseByMinWeekNum(){
        Integer minWeekNum = courseService.getMinWeekNum();
        return getAllCourse(minWeekNum);
    }

    /**
     * 根据周数删除课程表
     * @param weekNum 周数
     */
    @GetMapping("/deleteCourseByWeekNum/{weekNum}")
    public void deleteCourseByWeekNum(@PathVariable Integer weekNum){
        courseService.deleteCourseByWeekNum(weekNum);
    }

    /**
     * 导出数据
     * @param weekNum 周数
     * @return
     */
    @GetMapping("/export/{weekNum}")
    public ResponseEntity<byte[]> exportData(@PathVariable Integer weekNum) {
        List<Course> list = courseService.getAllCourse(weekNum);
        return CourseUtils.course2Excel(list);
    }

    /**
     * 导入数据
     * @param file
     * @param weekNum
     * @return
     * @throws IOException
     */
    @PostMapping("/import/{weekNum}")
    public RespBean importData(MultipartFile file, @PathVariable Integer weekNum) throws IOException {
        List<Course> list = CourseUtils.excel2Course(file);
        if (courseService.addCourse(list,weekNum) != null) {
            return RespBean.ok("上传成功");
        }
        return RespBean.error("上传失败");
    }


    /**
     * 将row集合变成course对象集合的形式
     * @param editedRows row的集合
     * @return 提示消息
     * editedrow.for循环里的if语句逻辑相同,所以只做第一个的注释
     */
    @PostMapping("/saveEditedRows")
    public void saveEditedRows(@RequestBody JSONObject[] editedRows) {
        //创建一个course集合
        List<Course>courseList = new ArrayList<>();
        //循环这个row的集合
        for(int i =0;i<editedRows.length;i++){
            //获取里面的jsonobjec对象
            JSONObject js=editedRows[i];
                //对对象里的内容进行判断
                if(js.get("mon")!=null){
                    //创建course对象
                    Course mon = new Course();
                    //从jsonobject对象中获取object对象
                    Object obj=js.get("mon");
                    //将object对象转换成string
                    String str=obj.toString();
                    //通过spilt将str分割成string数组
                    String[] courseStr=str.split(",");
                    //循环这个数组
                    for (int j = 0; j < courseStr.length; j++) {
                        //通过spilt方法将数组在分割
                        String[] propStr=courseStr[j].split(":");
                        //j==0的时候就是courseId:""; j==2的时候就是courseName:""
                        if(j == 0){
                            //将数组内容转化成integer，set进course对象里
                            mon.setCourseId(Integer.valueOf(propStr[1]));
                        }else if(j == 2){
                            //将数组内容转换成string，set进course对象里
                            String courseName   = propStr[1].toString().substring(1,propStr[1].length()-1);
                            //String courseName  = new String(propStr[1]).substring(1,propStr[1].length()-1);
                            mon.setCourseName(courseName);
                        }
                    }
                    //将course对象加入list
                    courseList.add(mon);
                }
                if(js.get("tue")!=null){
                    Course tue = new Course();
                    Object obj=js.get("tue");
                    String str=obj.toString();
                    String[] courseStr=str.split(",");
                    for (int j = 0; j < courseStr.length; j++) {
                        String[] propStr=courseStr[j].split(":");
                        if(j == 0){
                            tue.setCourseId(Integer.valueOf(propStr[1]));
                        }else if(j == 2){
                            String courseName  = new String(propStr[1]).substring(1,propStr[1].length()-1);
                            tue.setCourseName(courseName);
                        }
                    }
                    courseList.add(tue);
                }
                if(js.get("wes")!=null){
                    Course wes = new Course();
                    Object obj=js.get("wes");
                    String str=obj.toString();
                    String[] courseStr=str.split(",");
                    for (int j = 0; j < courseStr.length; j++) {
                        String[] propStr=courseStr[j].split(":");
                        if(j == 0){
                            wes.setCourseId(Integer.valueOf(propStr[1]));
                        }else if(j == 2){
                            String courseName  = new String(propStr[1]).substring(1,propStr[1].length()-1);
                            wes.setCourseName(courseName);
                        }
                    }
                    courseList.add(wes);
                }else if(js.get("thu")!=null){
                    Course thu = new Course();
                    Object obj=js.get("thu");
                    String str=obj.toString();
                    String[] courseStr=str.split(",");
                    for (int j = 0; j < courseStr.length; j++) {
                        String[] propStr=courseStr[j].split(":");
                        if(j == 0){
                            thu.setCourseId(Integer.valueOf(propStr[1]));
                        }else if(j == 2){
                            String courseName  = new String(propStr[1]).substring(1,propStr[1].length()-1);
                            thu.setCourseName(courseName);
                        }
                    }
                    courseList.add(thu);
                }
                if(js.get("fri")!=null){
                    Course fri = new Course();
                    Object obj=js.get("fri");
                    String str=obj.toString();
                    String[] courseStr=str.split(",");
                    for (int j = 0; j < courseStr.length; j++) {
                        String[] propStr=courseStr[j].split(":");
                        if(j == 0){
                            fri.setCourseId(Integer.valueOf(propStr[1]));
                        }else if(j == 2){
                            String courseName  = new String(propStr[1]).substring(1,propStr[1].length()-1);
                            fri.setCourseName(courseName);
                        }
                    }
                    courseList.add(fri);
                }
                if(js.get("sat")!=null){
                    Course sat = new Course();
                    Object obj=js.get("sat");
                    String str=obj.toString();
                    String[] courseStr=str.split(",");
                    for (int j = 0; j < courseStr.length; j++) {
                        String[] propStr=courseStr[j].split(":");
                        if(j == 0){
                            sat.setCourseId(Integer.valueOf(propStr[1]));
                        }else if(j == 2){
                            String courseName  = new String(propStr[1]).substring(1,propStr[1].length()-1);
                            sat.setCourseName(courseName);
                        }
                    }
                    courseList.add(sat);
                }
                if(js.get("sun")!=null){
                    Course sun = new Course();
                    Object obj=js.get("sun");
                    String str=obj.toString();
                    String[] courseStr=str.split(",");
                    for (int j = 0; j < courseStr.length; j++) {
                        String[] propStr=courseStr[j].split(":");
                        if(j == 0){
                            sun.setCourseId(Integer.valueOf(propStr[1]));
                        }else if(j == 2){
                            String courseName  = new String(propStr[1]).substring(1,propStr[1].length()-1);
                            sun.setCourseName(courseName);
                        }
                    }
                    courseList.add(sun);
                }

        }
        //调用保存方法
        courseService.saveCourse(courseList);
    }


}
