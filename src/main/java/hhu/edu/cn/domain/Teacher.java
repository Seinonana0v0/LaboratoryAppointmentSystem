package hhu.edu.cn.domain;

import java.util.List;

public class Teacher {
    private int id;
    private String tea_name;
    private String tea_password;
    private List<Tea_Class> classes;

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

    public List<Tea_Class> getClasses() {
        return classes;
    }

    public void setClasses(List<Tea_Class> classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", tea_name='" + tea_name + '\'' +
                ", tea_password='" + tea_password + '\'' +
                ", classes=" + classes +
                '}';
    }
}
