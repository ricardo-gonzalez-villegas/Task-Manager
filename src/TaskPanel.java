import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskPanel implements ActionListener{
    Task task;
    JPanel panel = new JPanel();
    JLabel nameLabel;
    JLabel dateLabel;
    JLabel priorityLabel;
    JCheckBox completedBox;
    JButton button = new JButton("Delete");
    Runnable deleteCallback;
    TaskListEnum taskListEnum = TaskListEnum.INSTANCE;

    public TaskPanel(Task task, Runnable deleteCallback){
        this.task = task;
        this.deleteCallback = deleteCallback;
        this.nameLabel = new JLabel(task.getName());
        this.dateLabel = new JLabel(task.getDate());
        this.priorityLabel = new JLabel(task.getPriority());
        this.completedBox = new JCheckBox();
        this.button.addActionListener(this);
        this.panel.setLayout(new GridLayout(1,5));
        this.panel.add(this.nameLabel);
        this.panel.add(this.dateLabel);
        this.panel.add(this.priorityLabel);
        this.panel.add(this.completedBox);
        this.panel.add(this.button);
    }

    public JPanel getPanel(){
        return this.panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        deleteTask();
    }

    private void deleteTask(){
        taskListEnum.deleteTask(this.task.getUuid());
        deleteCallback.run();
    }
}

