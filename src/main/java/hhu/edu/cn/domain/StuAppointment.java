package hhu.edu.cn.domain;

import java.util.Date;

/**
 * 学生预约信息
 */
public class StuAppointment {
    private int id;
    private Date appoint_date;
    private String appoint_time;
    private int stu_id;
    private Student student;
    private String status;
    private String formatDate;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    public String getFormatDate() {
        return formatDate;
    }

    public void setFormatDate(String formatDate) {
        this.formatDate = formatDate;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getAppoint_date() {
        return appoint_date;
    }

    public void setAppoint_date(Date appoint_date) {
        this.appoint_date = appoint_date;
    }

    public String getAppoint_time() {
        return appoint_time;
    }

    public void setAppoint_time(String appoint_time) {
        this.appoint_time = appoint_time;
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "StuAppointment{" +
                "id=" + id +
                ", appoint_date=" + appoint_date +
                ", appoint_time='" + appoint_time + '\'' +
                ", stu_id=" + stu_id +
                ", student=" + student +
                '}';
    }
}
