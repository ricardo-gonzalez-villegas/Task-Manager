import java.io.File;
import java.io.IOException;
import javax.swing.*;

public class Main {
    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame();
        Operations operations = Operations.INSTANCE;
        operations.readTaskList();
        MainPanel mainPanel = new MainPanel();
        File file = new File("./task-list.txt");

        if (!file.exists()){
            file.createNewFile();
        }

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.add(mainPanel.getMainPanel());
        frame.setVisible(true);

    }
}
