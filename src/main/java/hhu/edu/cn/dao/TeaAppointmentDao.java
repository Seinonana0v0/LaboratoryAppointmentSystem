package hhu.edu.cn.dao;

import hhu.edu.cn.domain.Condition;
import hhu.edu.cn.domain.TeaAppointment;
import hhu.edu.cn.utils.SqlProvider;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 操作教师记录表的Dao
 */
@Repository
public interface TeaAppointmentDao {
    /**
     * 按条件查询
     * @param condition
     * @return
     */
    @SelectProvider(type = SqlProvider.class,method = "getSelectForFindByCondition2")
    @Results(id = "TeaAppointmentMap",
            value ={@Result(id = true,column = "id",property = "id"),
            @Result(column = "tea_id",property = "tea_id"),
            @Result(column = "class_name",property = "class_name"),
            @Result(column = "appoint_date",property = "appoint_date"),
            @Result(column = "appoint_time",property = "appoint_time"),
            @Result(column = "tea_id", property = "teacher",one =@One(select = "hhu.edu.cn.dao.TeacherDao.findTeacherById",fetchType = FetchType.LAZY))
            })
    List<TeaAppointment> findByCondition_Tea(Condition condition);
}
