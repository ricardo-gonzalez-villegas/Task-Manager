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
    JButton button = new JButton("Delete");
    public TaskPanel(Task task){
        this.task = task;
        this.nameLabel = new JLabel(task.getName());
        this.dateLabel = new JLabel(task.getDate());
        this.priorityLabel = new JLabel(task.getPriority());
        this.button.addActionListener(this);
        this.panel.setLayout(new GridLayout(1,4));
        this.panel.add(this.nameLabel);
        this.panel.add(this.dateLabel);
        this.panel.add(this.priorityLabel);
        this.panel.add(this.button);
    }

    public JPanel getPanel(){
        return this.panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(this.task.getUuid());
        TaskList.deleteTask(this.task.getUuid());
    }
}
