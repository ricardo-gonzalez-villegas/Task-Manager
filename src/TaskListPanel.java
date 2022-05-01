import javax.swing.*;
import java.awt.*;

public class TaskListPanel {
   JPanel panel = new JPanel();

   TaskList taskList;
   
   public TaskListPanel(TaskList list){
       int rows = list.getTaskCount();
       this.panel.setLayout(new GridLayout(rows, 1));
       this.taskList = list;

       addTasksToPanel();
   }

    private void addTasksToPanel() {
        for (Task task: this.taskList.getTaskList()) {
            TaskPanel taskPanel = new TaskPanel(task, this::onItemDeleted);
            this.panel.add(taskPanel.getPanel());
        }
    }

    public JPanel getPanel(){
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
