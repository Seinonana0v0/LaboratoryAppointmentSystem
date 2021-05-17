package test;

import hhu.edu.cn.dao.TeacherDao;
import hhu.edu.cn.domain.Tea_Class;
import hhu.edu.cn.domain.Teacher;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TeacherTest {

    @Test
    public void testFind(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        TeacherDao teacherDao = ac.getBean("teacherDao", TeacherDao.class);
        Teacher teacher = teacherDao.findTeacherById(2000090102);
        System.out.println(teacher);
        String key = teacher.getTea_name();
        Jedis jedis = new Jedis("localhost",6379);
        Set<String> classNames = jedis.smembers(key);
        if(classNames!=null&&classNames.size()!=0){
            System.out.println("从缓存查的");
            System.out.println(classNames);
        }
        else{
            List<Tea_Class> classes = teacher.getClasses();
            for (Tea_Class aClass : classes) {
                classNames.add(aClass.getClass_name());

            }
            for (String className : classNames) {
                jedis.sadd(key,className);
            }
            System.out.println("从数据库查的");
            System.out.println(classNames);
        }

        jedis.close();
    }
}
