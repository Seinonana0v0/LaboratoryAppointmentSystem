package hhu.edu.cn.service;

import hhu.edu.cn.domain.Admin;
import org.springframework.stereotype.Service;


public interface AdminService {
    /**
     * 管理员登陆
     * @param loginAdmin
     */
    Admin adminLogin(Admin loginAdmin);


}
