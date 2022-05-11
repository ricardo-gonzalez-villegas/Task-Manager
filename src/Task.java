import java.util.UUID;

public class Task {
    private UUID uuid = UUID.randomUUID();
    private String name;
    private String date;
    private String priority;
    private boolean completed = false;

    public Task(String name, String date, String priority){
        this.name = name;
        this.date = date;
        this.priority = priority;
    }

    public UUID getUuid(){
        return this.uuid;
    }

    public String getName(){
        return this.name;
    }

    public String getDate(){
        return this.date;
    }

    public String getPriority(){
        return this.priority;
    }

    public boolean getCompleted(){
        return this.completed;
    }

    public void toggleTaskCompleted(){
        this.completed = !this.completed;
    }


}
