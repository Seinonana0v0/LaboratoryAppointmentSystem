package hhu.edu.cn.domain;

public class Teacher {
    private int id;
    private String tea_name;
    private String tea_password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTea_name() {
        return tea_name;
    }

    public void setTea_name(String tea_name) {
        this.tea_name = tea_name;
    }

    public String getTea_password() {
        return tea_password;
    }

    public void setTea_password(String tea_password) {
        this.tea_password = tea_password;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", tea_name='" + tea_name + '\'' +
                ", tea_password='" + tea_password + '\'' +
                '}';
    }
}
