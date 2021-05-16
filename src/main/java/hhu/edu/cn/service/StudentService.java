package hhu.edu.cn.service;

import hhu.edu.cn.domain.Student;
import org.springframework.stereotype.Service;


public interface StudentService {
    int ResetStuPassword(int id);
    Student studentLogin(Student loginStudent);
    Student findStudentById(int id);
    int changePasswordById(int id,String newPassword);



}
