import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Task t1 = new Task("Task One", "01-JUN-2022","Low");
        Task t2 = new Task("Task Two", "01-JUN-2022","Low");
        Task t3 = new Task("Task Three", "01-JUN-2022","Low");
        Task t4 = new Task("Task Four", "01-JUN-2022","Low");
        Task t5 = new Task("Task Five", "01-JUN-2022","Low");
        TaskList list = new TaskList();
        list.addTask(t1);
        list.addTask(t2);
        list.addTask(t3);
        list.addTask(t4);
        list.addTask(t5);

        JFrame frame = new JFrame();
        MainPanel mainPanel = new MainPanel(list);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.add(mainPanel.getMainPanel());
        frame.setVisible(true);
    }
}
