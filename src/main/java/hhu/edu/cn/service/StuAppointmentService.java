package hhu.edu.cn.service;

import hhu.edu.cn.domain.Condition;
import hhu.edu.cn.domain.StuAppointment;
import org.springframework.stereotype.Service;

import java.util.List;



public interface StuAppointmentService {


    List<StuAppointment> findByCondition_Stu(Condition condition,int page,int size);

    void setStatusNotReport(String dataTable,int id);

    void setStatusReported(String dataTable, int id);

    List<StuAppointment> findCountByDateAndTime(String dataTable,String appoint_date,String appoint_time);

    void addNewStuAppointment(String dataTable,int stu_id,String appoint_date,String appoint_time);

    void cancelAppointment(String dataTable,int aid);
}
