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
            FileOutputStream f = new FileOutputStream("myTasks.txt");
            ObjectOutputStream o = new ObjectOutputStream(f);

            o.writeObject(taskListEnum);

            o.close();
            f.close();

        } catch (FileNotFoundException e){
            System.out.println("File not found");
        } catch (IOException ignored){
        }
    }

    public void readTaskList(){
        try {
            FileInputStream fi = new FileInputStream("myTasks.txt");
            ObjectInputStream oi = new ObjectInputStream(fi);

            TaskListEnum taskList = null;
            try{
                taskList = (TaskListEnum) oi.readObject();
            } catch (ClassNotFoundException e){
                e.printStackTrace();
            }
            if (taskList != null){
                taskListEnum.setTaskList(taskList.getTaskList());
            }

            oi.close();
            fi.close();

        } catch (FileNotFoundException e){
            System.out.println("File not found");
        } catch (IOException ignored){
        }
    }
}
