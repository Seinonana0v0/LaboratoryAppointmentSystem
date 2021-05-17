package hhu.edu.cn.domain;

public class Tea_Class {
    private String class_name;
    private int teacher_id;

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    @Override
    public String toString() {
        return "Tea_Class{" +
                "class_name='" + class_name + '\'' +
                ", teacher_id=" + teacher_id +
                '}';
    }
}
