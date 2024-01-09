package org.javaboy.vhr.service;

import org.javaboy.vhr.mapper.InterviewMapper;
import org.javaboy.vhr.mapper.InterviewMapper;
import org.javaboy.vhr.model.Interview;
import org.javaboy.vhr.model.MailConstants;
import org.javaboy.vhr.model.MailSendLog;
import org.javaboy.vhr.model.RespPageBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * carry
 */
@Service
public class InterviewService {
    @Autowired
    InterviewMapper interviewMapper;
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    MailSendLogService mailSendLogService;
    public final static Logger logger = LoggerFactory.getLogger(InterviewService.class);
    SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
    SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
    DecimalFormat decimalFormat = new DecimalFormat("##.00");

    public RespPageBean getEmployeeByPage(Integer page, Integer size, Interview employee, Date[] beginDateScope) {
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        List<Interview> data = interviewMapper.getEmployeeByPage(page, size, employee, beginDateScope);
        Long total = interviewMapper.getTotal(employee, beginDateScope);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }

    public Integer addEmp(Interview employee) {
        int result = interviewMapper.insertSelective(employee);
        if (result == 1) {
            Interview emp = interviewMapper.getEmployeeByIdCard(employee.getIdCard());
            //生成消息的唯一id
            String msgId = UUID.randomUUID().toString();
            MailSendLog mailSendLog = new MailSendLog();
            mailSendLog.setMsgId(msgId);
            mailSendLog.setCreateTime(new Date());
            mailSendLog.setExchange(MailConstants.MAIL_EXCHANGE_NAME);
            mailSendLog.setRouteKey(MailConstants.MAIL_ROUTING_KEY_NAME);
            mailSendLog.setEmpId(emp.getId());
            mailSendLog.setTryTime(new Date(System.currentTimeMillis() + 1000 * 60 * MailConstants.MSG_TIMEOUT));
            mailSendLogService.insert(mailSendLog);
            rabbitTemplate.convertAndSend(MailConstants.MAIL_EXCHANGE_NAME, MailConstants.MAIL_ROUTING_KEY_NAME, emp, new CorrelationData(msgId));
        }
        return result;
    }

    public Interview addEmp2(Interview employee) {
        int result = interviewMapper.insertSelective(employee);
        if (result == 1) {
            Interview emp = interviewMapper.getEmployeeByPhone(employee.getPhone());
            // 生成消息的唯一id
            String msgId = UUID.randomUUID().toString();
            MailSendLog mailSendLog = new MailSendLog();
            mailSendLog.setMsgId(msgId);
            mailSendLog.setCreateTime(new Date());
            mailSendLog.setExchange(MailConstants.MAIL_EXCHANGE_NAME);
            mailSendLog.setRouteKey(MailConstants.MAIL_ROUTING_KEY_NAME);
            mailSendLog.setEmpId(emp.getId());
            mailSendLog.setTryTime(new Date(System.currentTimeMillis() + 1000 * 60 * MailConstants.MSG_TIMEOUT));
            mailSendLogService.insert(mailSendLog);
            rabbitTemplate.convertAndSend(MailConstants.MAIL_EXCHANGE_NAME, MailConstants.MAIL_ROUTING_KEY_NAME, emp, new CorrelationData(msgId));

            // 返回插入的面试信息对象
            return emp;
        }
        return null; // 或者抛出异常，表示插入失败
    }


    public Integer maxWorkID() {
        return interviewMapper.maxWorkID();
    }

    public Integer deleteEmpByEid(Integer id) {
        return interviewMapper.deleteByPrimaryKey(id);
    }

    public Integer updateEmp(Interview employee) {
        return interviewMapper.updateByPrimaryKeySelective(employee);
    }

    public Integer addEmps(List<Interview> list) {
        return interviewMapper.addEmps(list);
    }

    public RespPageBean getEmployeeByPageWithSalary(Integer page, Integer size) {
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        List<Interview> list = interviewMapper.getEmployeeByPageWithSalary(page, size);
        RespPageBean respPageBean = new RespPageBean();
        respPageBean.setData(list);
        respPageBean.setTotal(interviewMapper.getTotal(null, null));
        return respPageBean;
    }

    public Integer updateEmployeeSalaryById(Integer eid, Integer sid) {
        return interviewMapper.updateEmployeeSalaryById(eid, sid);
    }

    public Interview getEmployeeById(Integer empId) {
        return interviewMapper.getEmployeeById(empId);
    }
}
