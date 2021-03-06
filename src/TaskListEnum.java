import java.util.ArrayList;
import java.util.UUID;

public enum TaskListEnum{
    INSTANCE;

    private ArrayList<Task> taskList = new ArrayList<>();

    public void setTaskList(ArrayList<Task> taskList){
        this.taskList = taskList;
    }

    public void addTask(Task task){
        taskList.add(task);
    }

    public void deleteTask(UUID uuid){
        taskList.removeIf(task -> uuid.equals(task.getUuid()));
    }

    public Task getTask(UUID uuid){
        Task task = null;
        for (Task t: taskList){
           if (t.getUuid() == uuid)
               task = t;
        }
        return task;
    }

    public ArrayList<Task> getTaskList(){
        return taskList;
    }

    public int getTaskCount(){
        return taskList.size();
    }

    public void listPrint(){
        for (Task task: this.taskList){
            System.out.println(task.toString());
        }
    }
}
