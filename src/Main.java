import java.io.File;
import java.io.IOException;
import javax.swing.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Task t1 = new Task("Task One", "01-JUN-2022","Low");
        Task t2 = new Task("Task Two", "01-JUN-2022","Low");
        Task t3 = new Task("Task Three", "01-JUN-2022","Low");
        Task t4 = new Task("Task Four", "01-JUN-2022","Low");
        Task t5 = new Task("Task Five", "01-JUN-2022","Low");
        TaskListEnum list = TaskListEnum.INSTANCE;
        list.addTask(t1);
        list.addTask(t2);
        list.addTask(t3);
        list.addTask(t4);
        list.addTask(t5);

        File file = new File("./task-list.txt");
        Operations operations = Operations.INSTANCE;
        operations.readTaskList();

        if (!file.exists()){
            file.createNewFile();
        } else if (file.length() != 0){
            JFrame frame = new JFrame();
            MainPanel mainPanel = new MainPanel();
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.add(mainPanel.getMainPanel());
            frame.setVisible(true);
        }
    }
}
