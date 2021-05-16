package hhu.edu.cn.dao;

import hhu.edu.cn.domain.Teacher;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * 操作教师表的Dao
 */
@Repository
public interface TeacherDao {
    /**
     * 按id查询教师
     * @param id
     * @return
     */
    @Select("select * from teacher where id=#{id}")
    Teacher findTeacherById(int id);
}
