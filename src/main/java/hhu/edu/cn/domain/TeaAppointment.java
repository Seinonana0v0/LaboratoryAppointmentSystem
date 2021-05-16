package hhu.edu.cn.domain;

import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Date;

public class TeaAppointment implements Serializable {
    private int id;
    private int tea_id;
    private String class_name;
    private Date appoint_date;
    private String appoint_time;
    private String formatDate;
    private Teacher teacher;

    public int getTea_id() {
        return tea_id;
    }

    public void setTea_id(int tea_id) {
        this.tea_id = tea_id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
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

    public String getFormatDate() {
        return formatDate;
    }

    public void setFormatDate(String formatDate) {
        this.formatDate = formatDate;
    }

    @Override
    public String toString() {
        return "TeaAppointment{" +
                "id=" + id +
                ", tea_id=" + tea_id +
                ", class_name='" + class_name + '\'' +
                ", appoint_date=" + appoint_date +
                ", appoint_time='" + appoint_time + '\'' +
                ", formatDate='" + formatDate + '\'' +
                ", teacher=" + teacher +
                '}';
    }
}
