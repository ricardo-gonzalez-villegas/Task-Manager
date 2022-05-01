import javax.swing.*;
import java.awt.*;

public class TaskListPanel {
   JPanel panel = new JPanel();
   
   public TaskListPanel(TaskList list){
       int rows = list.getTaskCount();
       this.panel.setLayout(new GridLayout(rows, 1));
       for (Task task: list.getTaskList()) {
           TaskPanel taskPanel = new TaskPanel(task);
           this.panel.add(taskPanel.getPanel());
       }
   }
   public JPanel getPanel(){
       return this.panel;
   }
}
