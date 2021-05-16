package hhu.edu.cn.dao;

import hhu.edu.cn.domain.Admin;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * 操作管理员表的Dao
 */
@Repository
public interface AdminDao {
    /**
     * 管理员登录
     * @param loginAdmin
     */
    @Select("select * from admin where admin_name=#{admin_name} and admin_password=#{admin_password}")
    Admin adminLogin (Admin loginAdmin) throws NullPointerException;
}
