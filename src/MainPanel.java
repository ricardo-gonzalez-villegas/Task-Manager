import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel implements ActionListener {
    JPanel mainPanel = new JPanel();
    CreateTaskPanel createTaskPanel;
    TaskListPanel taskListPanel;

    JButton addTaskButton;

    public MainPanel(TaskList list){
        this.addTaskButton = new JButton("Add Task");
        this.createTaskPanel = new CreateTaskPanel(this::setTaskListPanel);
        this.taskListPanel = new TaskListPanel(list);
        this.addTaskButton.addActionListener(this);
        this.mainPanel.add(addTaskButton);
        this.mainPanel.add(this.taskListPanel.getPanel());
        this.mainPanel.setLayout(new GridLayout(2, 1));
    }

    public JPanel getMainPanel(){
        return this.mainPanel;
    }

    public void setCreateTaskPanel(){
        this.mainPanel.removeAll();
        this.mainPanel.add(this.createTaskPanel.getCreateTaskPanel());
        this.mainPanel.revalidate();
        this.mainPanel.repaint();
    }

    public void setTaskListPanel(){
        this.mainPanel.removeAll();
        this.mainPanel.add(addTaskButton);
        this.mainPanel.add(this.taskListPanel.getPanel());
        this.mainPanel.revalidate();
        this.mainPanel.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.setCreateTaskPanel();
    }
}
