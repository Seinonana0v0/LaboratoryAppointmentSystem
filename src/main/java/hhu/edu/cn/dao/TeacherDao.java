package hhu.edu.cn.dao;

import hhu.edu.cn.domain.Teacher;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;
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
    @Results (id="Tea_ClassMap",value = {
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "tea_name",property = "tea_name"),
            @Result(column = "tea_password",property = "tea_password"),
            @Result(column = "id",property = "classes" ,many = @Many(select = "hhu.edu.cn.dao.Tea_ClassDao.findClassesByTea_id",fetchType = FetchType.LAZY))
            })
    Teacher findTeacherById(int id);
}
