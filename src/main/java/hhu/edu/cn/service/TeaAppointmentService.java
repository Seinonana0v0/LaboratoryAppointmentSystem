package hhu.edu.cn.service;

import hhu.edu.cn.domain.Condition;
import hhu.edu.cn.domain.TeaAppointment;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TeaAppointmentService {

    List<TeaAppointment> findByCondition_Tea(Condition condition,int page,int size);
}
