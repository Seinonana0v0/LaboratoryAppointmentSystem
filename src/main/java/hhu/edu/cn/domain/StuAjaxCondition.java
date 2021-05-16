package hhu.edu.cn.domain;

public class StuAjaxCondition {
    private int stu_id;
    private String dataTable;
    private String appoint_date;
    private String appoint_time;

    public String getAppoint_date() {
        return appoint_date;
    }

    public void setAppoint_date(String appoint_date) {
        this.appoint_date = appoint_date;
    }

    public String getAppoint_time() {
        return appoint_time;
    }

    public void setAppoint_time(String appoint_time) {
        this.appoint_time = appoint_time;
    }

    public String getDataTable() {
        return dataTable;
    }

    public void setDataTable(String dataTable) {
        this.dataTable = dataTable;
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    @Override
    public String toString() {
        return "AjaxCondition{" +
                "stu_id=" + stu_id +
                ", dataTable='" + dataTable + '\'' +
                ", appoint_date='" + appoint_date + '\'' +
                ", appoint_time='" + appoint_time + '\'' +
                '}';
    }
}
