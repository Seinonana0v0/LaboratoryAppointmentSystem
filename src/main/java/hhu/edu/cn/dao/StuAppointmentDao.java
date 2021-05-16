package hhu.edu.cn.dao;

import hhu.edu.cn.domain.Condition;
import hhu.edu.cn.domain.StuAppointment;
import hhu.edu.cn.utils.SqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

/**
 * 操作学生记录表的Dao
 */
@Repository
public interface StuAppointmentDao {
    /**
     * 按表单条件条件查询
     *
     * @param condition
     * @return
     */
    @SelectProvider(type = SqlProvider.class, method = "getSelectForFindByCondition")
    @Results(id = "StuAppointmentMap",
            value = {
                    @Result(id = true, column = "id", property = "id"),
                    @Result(column = "stu_id", property = "stu_id"),
                    @Result(column = "appoint_date", property = "appoint_date"),
                    @Result(column = "appoint_time", property = "appoint_time"),
                    @Result(column = "status", property = "status"),
                    @Result(column = "stu_id", property = "student", one = @One(select = "hhu.edu.cn.dao.StudentDao.findStudentById", fetchType = FetchType.LAZY))
            })
    List<StuAppointment> findByCondition_Stu(Condition condition);


    /**
     * 修改状态为未上报
     *
     * @param dataTable
     * @param id
     */
    @UpdateProvider(type = SqlProvider.class, method = "getUpdateForStatusNotReport")
    void setStatusNotReport(String dataTable, int id);

    @UpdateProvider(type = SqlProvider.class,method = "getUpdateForStatusReported")
    void setStatusReported(String dataTable, int id);

    /**
     * 查询要预约的日期和事件段已预约的人数
     *
     * @param dataTable
     * @param appoint_date
     * @param appoint_time
     * @return
     */
    @SelectProvider(type = SqlProvider.class, method = "getSelectForFindCountByDateAndTime")
    @ResultMap("StuAppointmentMap")
    List<StuAppointment> findCountByDateAndTime(String dataTable, String appoint_date, String appoint_time);

    /**
     * 新增预约
     * @param dataTable
     * @param stu_id
     * @param appoint_date
     * @param appoint_time
     */
    @InsertProvider(type = SqlProvider.class,method = "getInsertForAddNewStuAppointment")
    void addNewStuAppointment(String dataTable,int stu_id,String appoint_date,String appoint_time);

    /**
     * 取消预约
     * @param dataTable
     * @param aid
     */
    @DeleteProvider(type = SqlProvider.class,method = "getDeleteForCancelAppointment")
    void cancelAppointment(String dataTable,int aid);
}
