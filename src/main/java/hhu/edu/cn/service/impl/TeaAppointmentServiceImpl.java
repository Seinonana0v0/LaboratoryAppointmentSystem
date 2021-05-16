package hhu.edu.cn.service.impl;

import com.github.pagehelper.PageHelper;
import hhu.edu.cn.dao.TeaAppointmentDao;
import hhu.edu.cn.domain.Condition;
import hhu.edu.cn.domain.TeaAppointment;
import hhu.edu.cn.service.TeaAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeaAppointmentServiceImpl implements TeaAppointmentService {
    @Autowired
    private TeaAppointmentDao teaAppointmentDao;

    /***
     * 按条件分页查询
     * @param condition
     * @param page
     * @param size
     * @return
     */
    @Override
    public List<TeaAppointment> findByCondition_Tea(Condition condition,int page,int size) {
        PageHelper.startPage(page,size);
        return teaAppointmentDao.findByCondition_Tea(condition);
    }
}
