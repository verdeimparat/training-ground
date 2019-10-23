import javax.swing.*;
import java.awt.*;

public class NewGui extends JFrame{

    public NewGui(String title) throws HeadlessException {
        super(title);
        setSize(300,300);
        createUIComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void createUIComponents() {
        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");
        JButton b3 = new JButton("3");
        JButton b4 = new JButton("4");
        JTextField text = new JTextField("Insert here");

        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
//        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(b1)
                    .addComponent(b2))
                .addComponent(text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(b3)
                .addComponent(b4))
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(b1)
                .addComponent(b2)
                .addComponent(b3))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(b4))
        );
        setContentPane(panel);

    }

    public static void main(String[] args) {
        new NewGui("Librarie");
    }
}
