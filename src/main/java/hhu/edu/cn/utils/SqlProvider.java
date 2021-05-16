package hhu.edu.cn.utils;

import hhu.edu.cn.domain.Condition;
import org.apache.ibatis.annotations.Update;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class SqlProvider {
    private  StringBuilder sb = new StringBuilder();

    public String getSelectForFindByCondition(Condition condition){
        String dataTable = condition.getDataTable();
        int id = condition.getId();
        Date appoint_date = condition.getAppoint_date();
        sb.append("select * from "+dataTable+" where 1 = 1");
        if(id!=0){
            sb.append(" and stu_id = "+id);
        }
        if(appoint_date!=null){
            java.sql.Date sqlDate = new java.sql.Date(appoint_date.getTime());
            sb.append(" and appoint_date like '"+sqlDate+"%'");
        }

        return sb.toString();
    }

    public String getSelectForFindByCondition2(Condition condition){
        String dataTable = condition.getDataTable();
        int id = condition.getId();
        Date appoint_date = condition.getAppoint_date();
        sb.append("select * from "+dataTable+" where 1 = 1");
        if(id!=0){
            sb.append(" and tea_id = "+id);
        }
        if(appoint_date!=null){
            java.sql.Date sqlDate = new java.sql.Date(appoint_date.getTime());
            sb.append(" and appoint_date like '"+sqlDate+"%'");
        }

        return sb.toString();
    }


    public String getUpdateForStatusNotReport(String dataTable,int id){
        sb.append("update "+dataTable+" set status = '未上报' where id = "+id);
        return sb.toString();

    }

    public String getUpdateForStatusReported(String dataTable,int id){
        sb.append("update "+dataTable+" set status = '已上报' where id = "+id);
        return sb.toString();

    }

    public String getSelectForFindCountByDateAndTime(String dataTable,String appoint_date,String appoint_time){
        sb.append("select * from "+dataTable+" where appoint_date like '"+appoint_date +"' and appoint_time = '"+appoint_time+"'");
        return sb.toString();
    }


    public String getInsertForAddNewStuAppointment(String dataTable,int stu_id,String appoint_date,String appoint_time){
        sb.append("insert into "+dataTable+" values (null,"+stu_id+",'"+appoint_date+"','"+appoint_time+"','已预约')");

        return sb.toString();
    }


    public  String getDeleteForCancelAppointment(String dataTable,int aid){
        sb.append("delete from "+dataTable+" where id = "+aid);
        return sb.toString();
    }
}
