import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateTaskPanel implements ActionListener {
    String[] priorityLevels = {"Low","Medium","High"};
    JPanel panel = new JPanel();
    JLabel nameLabel = new JLabel("Task Name: ");
    JTextField nameField = new JTextField();
    JLabel dateLabel = new JLabel("Due Date: ");
    JTextField dateField = new JTextField();
    JLabel priorityLabel = new JLabel("Priority : ");
    JComboBox<String> priorityList = new JComboBox<>(priorityLevels);
    JButton submitButton = new JButton("Add");
    public CreateTaskPanel(){
        this.panel.setLayout(new GridLayout(7,1));
        this.submitButton.addActionListener(this);
        this.panel.add(nameLabel);
        this.panel.add(nameField);
        this.panel.add(dateLabel);
        this.panel.add(dateField);
        this.panel.add(priorityLabel);
        this.panel.add(priorityList);
        this.panel.add(submitButton);

    }

    public JPanel getCreateTaskPanel(){
        return panel;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String name = this.nameField.getText();
        String date = this.dateField.getText();
        String priority = this.priorityList.getSelectedItem().toString();
        Task task = new Task(name, date, priority);
        TaskList.addTask(task);
    }
}
