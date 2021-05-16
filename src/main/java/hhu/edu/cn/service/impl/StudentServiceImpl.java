package hhu.edu.cn.service.impl;

import hhu.edu.cn.dao.StudentDao;
import hhu.edu.cn.domain.Student;
import hhu.edu.cn.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    /**
     * 重置学生密码
     * @param id
     * @return
     */
    @Override
    public int ResetStuPassword(int id) {
       return studentDao.ResetStuPassword(id);
    }

    @Override
    public Student studentLogin(Student loginStudent) {
        try {
            return studentDao.studentLogin(loginStudent);
        } catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Student findStudentById(int id) {
        return studentDao.findStudentById(id);
    }

    @Override
    public int changePasswordById(int id, String newPassword) {
        return studentDao.changePasswordById(id,newPassword);
    }
}
