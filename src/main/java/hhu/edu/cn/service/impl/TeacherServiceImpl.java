package hhu.edu.cn.service.impl;

import hhu.edu.cn.dao.TeacherDao;
import hhu.edu.cn.domain.Tea_Class;
import hhu.edu.cn.domain.Teacher;
import hhu.edu.cn.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherDao teacherDao;

    @Override
    public List<String> showClassNames(int tea_id) {
        Teacher teacher = teacherDao.findTeacherById(tea_id);
        String key = teacher.getTea_name();
        Jedis jedis = new Jedis("localhost",6379);
        List<String> classNames = jedis.lrange(key,0,-1);
        //如果缓存中有,从缓存中获取
        if(classNames!=null&&classNames.size()!=0){
            System.out.println("从缓存查的");
        }
        //如果缓存中没有,将teacher的classes属性转换为classNamesSet,存入缓存
        else{
            List<Tea_Class> classes = teacher.getClasses();
            for (Tea_Class aClass : classes) {
                classNames.add(aClass.getClass_name());
            }
            for (String className : classNames) {
                jedis.rpush(key,className);
            }
            System.out.println("从数据库查的");

        }

        System.out.println(classNames);
        jedis.close();
        return classNames;
    }
}
