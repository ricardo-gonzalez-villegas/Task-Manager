import javax.swing.*;
import java.awt.*;

public class TaskListPanel {
   JPanel panel = new JPanel();

   TaskListEnum taskListEnum = TaskListEnum.INSTANCE;

   public TaskListPanel(){
       int rows = taskListEnum.getTaskCount();
       this.panel.setLayout(new GridLayout(rows, 1));
       addTasksToPanel();
   }

    private void addTasksToPanel() {
        for (Task task: taskListEnum.getTaskList()) {
            TaskPanel taskPanel = new TaskPanel(task, this::onItemDeleted);
            this.panel.add(taskPanel.getPanel());
        }
    }

    public JPanel getPanel(){
       this.onItemDeleted();
       return this.panel;
   }

   public void onItemDeleted() {
       // Remove everything from the panel
       this.panel.removeAll();

       // Re-add all the tasks to the panel
       this.addTasksToPanel();

       // Repaint panel with newly added components
       this.panel.revalidate();
       this.panel.repaint();
   }
}
