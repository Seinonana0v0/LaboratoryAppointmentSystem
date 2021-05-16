package hhu.edu.cn.service.impl;

import hhu.edu.cn.dao.AdminDao;
import hhu.edu.cn.domain.Admin;
import hhu.edu.cn.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin adminLogin(Admin loginAdmin) {

        try {
            return adminDao.adminLogin(loginAdmin);
        } catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }
}
