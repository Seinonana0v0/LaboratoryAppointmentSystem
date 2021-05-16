package hhu.edu.cn.service.impl;

import com.github.pagehelper.PageHelper;
import hhu.edu.cn.dao.StuAppointmentDao;
import hhu.edu.cn.domain.Condition;
import hhu.edu.cn.domain.StuAppointment;
import hhu.edu.cn.service.StuAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StuAppointmentServiceImpl implements StuAppointmentService {
    @Autowired
    private StuAppointmentDao stuAppointmentDao;


    /**
     * 按表单条件分页查询
     * @param condition
     * @param page
     * @param size
     * @return
     */
    @Override
    public List<StuAppointment> findByCondition_Stu(Condition condition,int page,int size) {
        PageHelper.startPage(page,size);
        return stuAppointmentDao.findByCondition_Stu(condition);
    }

    /**
     * 修改状态为未上报
     * @param id
     * @param dataTable
     */
    @Override
    public void setStatusNotReport(String dataTable,int id) {
        stuAppointmentDao.setStatusNotReport(dataTable,id);
    }

    @Override
    public void setStatusReported(String dataTable, int id) {
        stuAppointmentDao.setStatusReported(dataTable,id);
    }

    /**
     * 查询要预约日期和时间段的已预约人数
     * @param dataTable
     * @param appoint_date
     * @param appoint_time
     * @return
     */
    @Override
    public List<StuAppointment> findCountByDateAndTime(String dataTable, String appoint_date, String appoint_time) {
        return stuAppointmentDao.findCountByDateAndTime(dataTable,appoint_date,appoint_time);
    }

    @Override
    public void addNewStuAppointment(String dataTable, int stu_id, String appoint_date, String appoint_time) {
        stuAppointmentDao.addNewStuAppointment(dataTable,stu_id,appoint_date,appoint_time);
    }

    @Override
    public void cancelAppointment(String dataTable, int aid) {
        stuAppointmentDao.cancelAppointment(dataTable,aid);
    }

}



