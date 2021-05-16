package test;

import hhu.edu.cn.dao.StudentDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentTest {
    @Test
    public void testReset(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentDao studentDao = ac.getBean("studentDao", StudentDao.class);
        int i = studentDao.ResetStuPassword(1806010100);
        System.out.println(i);
    }
}
