import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public enum Operations {
    INSTANCE;

    TaskListEnum taskListEnum = TaskListEnum.INSTANCE;
    public void writeTaskList(){
        try {
            FileOutputStream f = new FileOutputStream("task-list.txt");
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(taskListEnum.getTaskList());
            o.close();
            f.close();

        } catch (FileNotFoundException e){
            System.out.println("File not found");
        } catch (IOException ignored){
        }
    }

    public void readTaskList(){
        try {
            FileInputStream fi = new FileInputStream("task-list.txt");
            ObjectInputStream oi = new ObjectInputStream(fi);
            ArrayList<Task> taskList = null;
            try{
                taskList = (ArrayList<Task>) oi.readObject();
            } catch (ClassNotFoundException e){
                e.printStackTrace();
            }
            if (taskList != null){
                taskListEnum.setTaskList(taskList);
            }

            oi.close();
            fi.close();

        } catch (IOException ignored){
        }
    }
}
