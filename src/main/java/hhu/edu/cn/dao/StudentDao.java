package hhu.edu.cn.dao;

import hhu.edu.cn.domain.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 操作学生表的Dao
 */
@Repository
public interface StudentDao {
    /**
     * 按id查询学生
     * @param id
     * @return
     */
    @Select("select * from student where id=#{id}")
    Student findStudentById(int id);

    @Select("select * from student where id=#{id} and stu_password=#{stu_password}")
    Student studentLogin(Student loginStudent);

    @Update("update student set stu_password = 'xs123456' where id=#{id}")
    int ResetStuPassword(int id);

    @Update("update student set stu_password = #{newPassword} where id = #{id}")
    int changePasswordById(@Param("id") int id,@Param("newPassword") String newPassword);
}
