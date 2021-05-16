package test;

import hhu.edu.cn.dao.StuAppointmentDao;
import hhu.edu.cn.domain.Condition;
import hhu.edu.cn.domain.StuAppointment;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

public class StuAppointmentTest {

    @Test
    public void test2(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        StuAppointmentDao stuAppointmentDao = ac.getBean("stuAppointmentDao",StuAppointmentDao.class);
        Condition condition = new Condition();
        condition.setDataTable("laboratory_stu1");
        condition.setId(1806010101);
        List<StuAppointment> all = stuAppointmentDao.findByCondition_Stu(condition);
        for (StuAppointment stuAppointment : all) {
            System.out.println(stuAppointment);
        }

        }


    @Test
    public void test3(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        StuAppointmentDao stuAppointmentDao = ac.getBean("stuAppointmentDao",StuAppointmentDao.class);
        List<StuAppointment> countByDateAndTime = stuAppointmentDao.findCountByDateAndTime("laboratory_stu1", "2021-05-22", "上午");
        System.out.println(countByDateAndTime);
        System.out.println(countByDateAndTime.size());

    }

    @Test
    public void test4(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        StuAppointmentDao stuAppointmentDao = ac.getBean("stuAppointmentDao",StuAppointmentDao.class);
        stuAppointmentDao.addNewStuAppointment("laboratory_stu1",1806010101,"2021-05-24","上午");
    }

}