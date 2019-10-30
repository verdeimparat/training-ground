import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class MainLibrarieGUI extends JFrame {
    CartiGUI gui = new CartiGUI();
    CartiGUITable guiTable = new CartiGUITable(new String[]{
            LibrarieConstants.NUME, LibrarieConstants.AUTOR, LibrarieConstants.ISBN, LibrarieConstants.PRET, LibrarieConstants.TIP_CARTE
    });
    CardLayout cardLayout = new CardLayout();
    JPanel jPanel = new JPanel(cardLayout);


    public MainLibrarieGUI(String title) throws HeadlessException {
        super(title);
        setSize(500,500);
        jPanel.add(gui);
        jPanel.add(guiTable);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.getDisplayButton().addActionListener(e -> cardLayout.next(jPanel));
        gui.getAddButton().addActionListener(e -> {
            guiTable.getDefaultTableModel().addRow(new Object[]{
                    gui.getTextFieldNume().getText(), gui.getTextFieldAutor().getText(), gui.getTextFieldIsbn().getText(),
                    gui.getTextFieldPret().getText(), gui.getComboBoxTip().getItemAt(gui.getComboBoxTip().getSelectedIndex())
            });
            gui.resetTextFields();
        });
        guiTable.getBackButton().addActionListener(e -> cardLayout.previous(jPanel));
        setContentPane(jPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
                new MainLibrarieGUI("Librarie").setVisible(true));
    }
}
