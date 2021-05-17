package hhu.edu.cn.dao;

import hhu.edu.cn.domain.Tea_Class;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Tea_ClassDao {
    @Select("select * from class where teacher_id=#{teacher_id}")
    List<Tea_Class> findClassesByTea_id(int teacher_id);
}
