package test;

import hhu.edu.cn.dao.AdminDao;

import hhu.edu.cn.domain.Admin;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;


public class AdminTest {


    @Test
    /**
     * 测试管理员登陆
     */
    public void testAdminLogin(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        AdminDao adminDao = ac.getBean("adminDao", AdminDao.class);
        Admin loginAdmin = new Admin();
        loginAdmin.setAdmin_name("admin1");
        loginAdmin.setAdmin_password("am123456");
        Admin admin = adminDao.adminLogin(loginAdmin);
        System.out.println(admin);



    }

}
