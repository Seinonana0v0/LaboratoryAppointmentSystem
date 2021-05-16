package hhu.edu.cn.domain;

import java.util.Date;

public class Condition {
    private String dataTable;
    private int id;
    private Date appoint_date;

    public String getDataTable() {
        return dataTable;
    }

    public void setDataTable(String dataTable) {
        this.dataTable = dataTable;
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
}
