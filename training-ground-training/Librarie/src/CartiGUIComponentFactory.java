import javax.swing.*;

public class CartiGUIComponentFactory {

    public static JLabel createLabel(String name) {
        return new JLabel(name);
    }

    public static JButton createButton(String name) {
        return new JButton(name);
    }

    public static JTextField createTextField() {
        return new JTextField();
    }

    public static JComboBox<String> createComboBox(String ... nume) {
        JComboBox<String> comboBox = new JComboBox<>(nume);
        return comboBox;
    }

}
