import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CartiGUI extends JPanel {
//    private JFrame frame;
    private GroupLayout layout;

    private JLabel labelNume;
    private JLabel labelAutor;
    private JLabel labelIsbn;
    private JLabel labelPret;
    private JLabel labelTipCarte;

    private JTextField textFieldNume;
    private JTextField textFieldAutor;
    private JTextField textFieldIsbn;
    private JTextField textFieldPret;

    private JComboBox<String> comboBoxTip;

    private JButton addButton;
    private JButton displayButton;

    public CartiGUI() {
        super();
        layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        assemblePanel();
//        frame = new JFrame();
//        frame.setContentPane(this);
//        frame.setSize(500,400);
////        frame.pack();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createUIComponents() {
        labelNume = CartiGUIComponentFactory.createLabel(LibrarieConstants.NUME);
        labelAutor = CartiGUIComponentFactory.createLabel(LibrarieConstants.AUTOR);
        labelIsbn = CartiGUIComponentFactory.createLabel(LibrarieConstants.ISBN);
        labelPret = CartiGUIComponentFactory.createLabel(LibrarieConstants.PRET);
        labelTipCarte = CartiGUIComponentFactory.createLabel(LibrarieConstants.TIP_CARTE);

        textFieldNume = CartiGUIComponentFactory.createTextField();
        textFieldAutor = CartiGUIComponentFactory.createTextField();
        textFieldIsbn = CartiGUIComponentFactory.createTextField();
        textFieldPret = CartiGUIComponentFactory.createTextField();

        comboBoxTip = CartiGUIComponentFactory.createComboBox(
                LibrarieConstants.ISTORIE, LibrarieConstants.BELETRISTICA
        );

        addButton = CartiGUIComponentFactory.createButton(LibrarieConstants.ADAUGA);
        displayButton = CartiGUIComponentFactory.createButton(LibrarieConstants.AFISEAZA);
    }

    private void assemblePanel() {
        createUIComponents();
        layout.setHorizontalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(labelNume)
                .addComponent(labelAutor)
                .addComponent(labelIsbn)
                .addComponent(labelPret)
                .addComponent(labelTipCarte))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(textFieldNume)
                .addComponent(textFieldAutor)
                .addComponent(textFieldIsbn)
                .addComponent(textFieldPret)
                .addComponent(comboBoxTip))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(addButton)
                .addComponent(displayButton))
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(labelNume)
                .addComponent(textFieldNume, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(addButton))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(labelAutor)
                .addComponent(textFieldAutor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(displayButton))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(labelIsbn)
                .addComponent(textFieldIsbn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(labelPret)
                .addComponent(textFieldPret, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(labelTipCarte)
                .addComponent(comboBoxTip, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        layout.linkSize(SwingConstants.HORIZONTAL, addButton, displayButton);
        layout.linkSize(SwingConstants.VERTICAL, textFieldNume, textFieldAutor, textFieldIsbn, textFieldPret, comboBoxTip,
                displayButton, addButton,
                labelNume, labelAutor, labelIsbn, labelPret, labelTipCarte);
    }

    public void resetTextFields() {
        textFieldNume.setText("");
        textFieldAutor.setText("");
        textFieldIsbn.setText("");
        textFieldPret.setText("");
    }

    public JButton getDisplayButton() {
        return displayButton;
    }

    public JTextField getTextFieldNume() {
        return textFieldNume;
    }

    public JTextField getTextFieldAutor() {
        return textFieldAutor;
    }

    public JTextField getTextFieldIsbn() {
        return textFieldIsbn;
    }

    public JTextField getTextFieldPret() {
        return textFieldPret;
    }

    public JComboBox<String> getComboBoxTip() {
        return comboBoxTip;
    }

    public JButton getAddButton() {
        return addButton;
    }
}
