package duke.task;

import java.time.LocalDate;

// Level 3 -> A-Classes: Task class that represents all Tasks
public class Task {

    protected String description;
    protected LocalDate by = null;
    protected String at = null;
    protected boolean isDone;
    protected TASK_TYPE type;

    // overloaded constructors for separate duke.task types
    public Task(String description, String r, TASK_TYPE type) {
        this(description,type);
        if (type.equals(TASK_TYPE.D)) {
            by = LocalDate.parse(r);
        } else {
            at = r;
        }
        isDone = false;
    }

    public Task(String description, TASK_TYPE type) {
        this(description);
        this.type = type;
        isDone = false;
    }

    public Task(String description) {
        this.description = description;
        isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    public String getEventIcon() {
        String out;
        switch (type) {
        case T:
            out = "T";
            break;
        case D:
            out = "D";
            break;
        case E:
            out = "E";
            break;
        default:
            out = " ";
            break;
        }
        return out;
    }

    public String getDescription() {
        return description;
    }

    public TASK_TYPE getType() {
        return type;
    }

    public boolean getState() {
        return isDone;
    }

    public String getAt() {
        return at;
    }

    public LocalDate getBy() {
        return by;
    }

    public void setDone() {
        isDone = true;
    }

    @Override
    public String toString() {
        return "["
                .concat(getEventIcon())
                .concat("][")
                .concat(getStatusIcon())
                .concat("] ")
                .concat(getDescription());
    }
}
