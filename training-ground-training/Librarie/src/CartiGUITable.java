import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CartiGUITable extends JPanel {
    private DefaultTableModel defaultTableModel;
    private JTable table;
    private JScrollPane jScrollPane;
    private JButton backButton;

    public CartiGUITable(String[] columns) {
        super();
        createTable(columns);
        setLayout(new BorderLayout());
        add(jScrollPane);
        backButton = new JButton("Back");
        add(backButton, BorderLayout.SOUTH);
    }

    private void createTable(String[] columns) {
        defaultTableModel = new DefaultTableModel(null, columns);
        table = new JTable(defaultTableModel);
        jScrollPane = new JScrollPane(table);

    }

    public DefaultTableModel getDefaultTableModel() {
        return defaultTableModel;
    }

    public JButton getBackButton() {
        return backButton;
    }
}
