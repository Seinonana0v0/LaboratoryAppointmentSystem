package hhu.edu.cn.domain;

public class AjaxResponse {
    boolean rightDate = true;
    int count;
    boolean alreadyAppoint = false;

    public boolean isRightDate() {
        return rightDate;
    }

    public void setRightDate(boolean rightDate) {
        this.rightDate = rightDate;
    }


    public boolean isAlreadyAppoint() {
        return alreadyAppoint;
    }

    public void setAlreadyAppoint(boolean alreadyAppoint) {
        this.alreadyAppoint = alreadyAppoint;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
