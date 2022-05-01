import java.util.ArrayList;
import java.util.UUID;

public class TaskList {
    private static ArrayList<Task> list = new ArrayList<>();

    public void addTask(Task task){
        list.add(task);
    }

    public static void deleteTask(UUID uuid){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getUuid() == uuid){
                list.remove(i);
                break;
            }
        }
    }

    public Task getTask(UUID uuid){
        Task task = null;
        for (Task t: list) {
            if (t.getUuid() == uuid){
                task = t;
            }
        }
        return task;
    }

    public ArrayList<Task> getTaskList(){
        return list;
    }

    public int getTaskCount(){
       return list.size();
    }
}
