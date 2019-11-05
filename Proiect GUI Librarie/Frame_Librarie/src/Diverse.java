import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class Diverse extends JPanel{

    private String[]   tipObiect        = {"Papetarie",   "Rechizite",  "Materiale-didactice"};
    private String[]   afiseazaObiect   = {"Toate",   "Papetarie",    "Rechizite",    "Materiale-didactice"};
    private String[]   coloanaObiecte   = {"Nume",    "Producator",   "ID",   "Pret",   "Info",   "Tip"};
    private String[][] dateObiecte      = {};
    private String[]   motivSters       = {"Nume", "Producator"};

    Diverse()  {
        super();
        createUIComponents();
    }

    public void createUIComponents() {
        JTextField textFieldNume        = new JTextField("Nume");
        JTextField textFieldProducator  = new JTextField("Producator");
        JTextField textFieldID          = new JTextField("ID");
        JTextField textFieldPret        = new JTextField("Pret");
        JTextField textFieldInfo        = new JTextField("Info");
        JTextField searchField          = new JTextField("Search");
        JTextField stergeField          = new JTextField("<sterge>");

        JButton adaugaButton            = new JButton("Adauga");
        JButton stergeButton            = new JButton("Sterge");
        JButton vindeButton             = new JButton("Vinde");
        JButton afiseazaButton          = new JButton("Afiseaza");

        JLabel labelMesaj               = new JLabel( "Libraria VerDe" );

        JComboBox<String> comboBoxTip       = new JComboBox<>(tipObiect);
        JComboBox<String> comboBoxAfiseaza  = new JComboBox<>(afiseazaObiect);
        JComboBox<String> comboBoxSterge    = new JComboBox<>(motivSters);

        DefaultTableModel modelDiverse      = new DefaultTableModel(dateObiecte, coloanaObiecte);
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(modelDiverse);
        JTable tabelDiverse                 = new JTable(modelDiverse);
        tabelDiverse.setRowSorter(sorter);

        JScrollPane scrollPane              = new JScrollPane(tabelDiverse);

        tabelDiverse.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabelDiverse.setFillsViewportHeight(true);
        tabelDiverse.setAutoCreateRowSorter(true);

        GroupLayout mainLayout              = new GroupLayout(this);
        this.setLayout(mainLayout);
        mainLayout.setAutoCreateGaps(true);
        mainLayout.setAutoCreateContainerGaps(true);

        mainLayout.setHorizontalGroup(mainLayout.createSequentialGroup()
                .addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(mainLayout.createSequentialGroup()
                                .addComponent(textFieldNume)
                                .addComponent(textFieldProducator)
                                .addComponent(textFieldID)
                                .addComponent(textFieldPret)
                                .addComponent(textFieldInfo))
                        .addComponent(scrollPane))
                .addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(mainLayout.createSequentialGroup()
                                .addComponent(comboBoxTip)
                                .addComponent(adaugaButton))
                        .addGroup(mainLayout.createSequentialGroup()
                                .addComponent(comboBoxAfiseaza)
                                .addComponent(afiseazaButton))
                        .addGroup(mainLayout.createSequentialGroup()
                                .addComponent(searchField)
                                .addComponent(vindeButton))
                        .addGroup(mainLayout.createSequentialGroup()
                                .addComponent(comboBoxSterge)
                                .addComponent(stergeButton))

                        .addGroup(mainLayout.createSequentialGroup()
                                .addComponent(stergeField ))
                        .addGroup(mainLayout.createSequentialGroup()
                                .addComponent(labelMesaj))
                ));

        mainLayout.linkSize(SwingConstants.HORIZONTAL, adaugaButton, afiseazaButton, vindeButton, stergeButton);

        mainLayout.setVerticalGroup(mainLayout.createSequentialGroup()
                .addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(textFieldNume, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textFieldProducator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textFieldID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textFieldPret, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textFieldInfo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboBoxTip, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(adaugaButton))
                .addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(scrollPane)
                        .addGroup(mainLayout.createSequentialGroup()
                                .addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(comboBoxAfiseaza, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(afiseazaButton))
                                .addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(searchField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(vindeButton))
                                .addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(comboBoxSterge, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(stergeButton))
                                .addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(stergeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(labelMesaj, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))

                        )));

        adaugaButton.addActionListener(e -> {
            boolean flag = false;
            if (comboBoxTip.getSelectedIndex() == 0) {
                for (int d = 0; d < tabelDiverse.getRowCount(); d++) {
                    if (tabelDiverse.getValueAt(d, 2).equals(textFieldID.getText())) {
                        labelMesaj.setText("Obiectul exista deja in Librarie!");
                        //lblICon.setIcon(image);
                        flag = true;
                        break;
                    }
                }
                if (tabelDiverse.getRowCount() >= 100) {
                    labelMesaj.setText("Pragul maxim de o 100 de obiecte a fost atins!");
                    //lblICon.setIcon(image);
                } else if (!flag) {
                    labelMesaj.setText("Am adaugat un obiect de tip Papetarie.");
                    modelDiverse.addRow(new Object[]{textFieldNume.getText(), textFieldProducator.getText(), textFieldID.getText(), textFieldPret.getText(), textFieldInfo.getText(), "Papetarie"});
                    textFieldNume.setText("Nume");
                    textFieldProducator.setText("Producator");
                    textFieldID.setText("ID");
                    textFieldPret.setText("Pret");
                    textFieldInfo.setText("Tag");
                    //lblICon.setIcon(null);
                }
            } else if (comboBoxTip.getSelectedIndex() == 1) {
                for (int d = 0; d < tabelDiverse.getRowCount(); d++) {
                    if (tabelDiverse.getValueAt(d, 2).equals(textFieldID.getText())) {
                        labelMesaj.setText("Obiectul exista deja in Librarie!");
                        flag = true;
                        //lblICon.setIcon(image);
                        break;
                    }
                }
                if (tabelDiverse.getRowCount() >= 100) {
                    labelMesaj.setText("Pragul maxim de o 100 de obiecte a fost atins!");
                    //lblICon.setIcon(image);
                } else if (!flag) {
                    labelMesaj.setText("Am adaugat un obiect de tip Rechizite.");
                    modelDiverse.addRow(new Object[]{textFieldNume.getText(), textFieldProducator.getText(), textFieldID.getText(), textFieldPret.getText(), textFieldInfo.getText(), "Rechizite"});
                    textFieldNume.setText("Nume");
                    textFieldProducator.setText("Producator");
                    textFieldID.setText("ID");
                    textFieldPret.setText("Pret");
                    textFieldInfo.setText("Info");
                    //lblICon.setIcon(null);
                }
            }
            else if (comboBoxTip.getSelectedIndex() == 2) {
                for (int d = 0; d < tabelDiverse.getRowCount(); d++) {
                    if (tabelDiverse.getValueAt(d, 2).equals(textFieldID.getText())) {
                        labelMesaj.setText("Obiectul exista deja in Librarie!");
                        flag = true;
                        //lblICon.setIcon(image);
                        break;
                    }
                }
                if (tabelDiverse.getRowCount() >= 100) {
                    labelMesaj.setText("Pragul maxim de o 100 de obiecte a fost atins!");
                    //lblICon.setIcon(image);
                } else if (!flag) {
                    labelMesaj.setText("Am adaugat un obiect de tip Material-didactic.");
                    modelDiverse.addRow(new Object[]{textFieldNume.getText(), textFieldProducator.getText(), textFieldID.getText(), textFieldPret.getText(), textFieldInfo.getText(), "Material-didactic"});
                    textFieldNume.setText("Nume");
                    textFieldProducator.setText("Producator");
                    textFieldID.setText("ID");
                   //
                    textFieldPret.setText("Pret");
                    textFieldInfo.setText("Info");
                    //lblICon.setIcon(null);
                }
            }
        });

        stergeButton.addActionListener(e -> {
            if (comboBoxSterge.getSelectedIndex() == 0) {
                labelMesaj.setText("Sterge dupa Nume.");
                //System.out.println( modelDiverse.getDataVector() + " " + tabelDiverse.getRowCount());
                for (int d = tabelDiverse.getRowCount() - 1; d >= 0; d--) {
                    if (tabelDiverse.getValueAt( d, 0 ).equals( stergeField.getText( ) )) {
                        modelDiverse.removeRow( d );
                        System.out.println( modelDiverse.getDataVector( ) );
                    }
                }
            } else if (comboBoxSterge.getSelectedIndex() == 1) {
                labelMesaj.setText("Sterge dupa Producator.");
                for (int d = tabelDiverse.getRowCount() - 1; d >= 0; d--) {
                    if (tabelDiverse.getValueAt(d, 1).equals(stergeField.getText())) {
                        modelDiverse.removeRow(d);
                        break;
                    }
                }
                stergeField.setText("<sterge>");
            }
        });

        afiseazaButton.addActionListener(e -> {
            //lblICon.setIcon(null);
            if (comboBoxAfiseaza.getSelectedIndex() == 1) {
                labelMesaj.setText("Afiseaza obiectele de tip Papetarie.");
                sorter.setRowFilter(RowFilter.regexFilter(".*Papetarie.*"));
                tabelDiverse.setRowSorter(sorter);
            } else if (comboBoxAfiseaza.getSelectedIndex() == 2) {
                labelMesaj.setText("Afiseaza obiectele de tip Rechizite.");
                sorter.setRowFilter(RowFilter.regexFilter(".*Rechizite.*"));
                tabelDiverse.setRowSorter(sorter);
            } else if (comboBoxAfiseaza.getSelectedIndex() == 3) {
                labelMesaj.setText("Afiseaza obiectele de tip Material-didactic.");
                sorter.setRowFilter(RowFilter.regexFilter(".*Material-didactic.*"));
                tabelDiverse.setRowSorter(sorter);
            } else {
                labelMesaj.setText("Afiseaza toate obiectele.");
                sorter.setRowFilter(null);
            }
        });
    }
}