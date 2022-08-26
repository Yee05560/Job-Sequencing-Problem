public abstract class Job {

    String id;
    private int deadline;
    private int mark;

    public Job() {
    }

    public Job(String id, int deadline, int mark) {
        this.id = id;
        this.deadline = deadline;
        this.mark = mark;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDeadline() {
        return deadline;
    }

    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

}