package divisas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import menu.Menu;

public class Monedas extends JFrame {
    final private Font mainFont = new Font("Segoe print", Font.BOLD, 18);
    JTextField tfFirstName, tfLastName;
    JLabel lbWelcome;

    Sol sol = new Sol();
    Dolar dolar = new Dolar();
    Euro euro = new Euro();

    public void initialize() {

        JComboBox<String> combo1 = new JComboBox<String>();
        combo1.setFont(mainFont);

        combo1.addItem("Soles a Dolares");
        combo1.addItem("Soles a Euros");
        combo1.addItem("Dolares a Soles");
        combo1.addItem("Dolares a Euros");
        combo1.addItem("Euros a Soles");
        combo1.addItem("Euros a Dolares");

        // PANEL
        JLabel lbFirsName = new JLabel("Tipo de cambio: ");
        lbFirsName.setFont(mainFont);

        // tfFirstName = new JTextField();
        // tfFirstName.setFont(mainFont);

        JLabel lbLastName = new JLabel("Monto a cambiar: ");
        lbLastName.setFont(mainFont);

        tfLastName = new JTextField();
        tfLastName.setFont(mainFont);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4, 1, 5, 20));
        formPanel.setOpaque(false);
        formPanel.add(lbFirsName);
        // formPanel.add(tfFirstName);
        formPanel.add(combo1);
        formPanel.add(lbLastName);
        formPanel.add(tfLastName);

        // WELCOME LABEL
        lbWelcome = new JLabel();
        lbWelcome.setFont(mainFont);

        // BUTTONS PANEL
        JButton btnOK = new JButton("Atras");
        btnOK.setFont(mainFont);
        btnOK.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnOK) {
                    atras();

                }

            }

        });

        JButton btnClear = new JButton("Limpiar");
        btnClear.setFont(mainFont);
        btnClear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                combo1.setEnabled(true);
                tfLastName.setText("");
                lbWelcome.setText("");
            }

        });

        combo1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (e.getSource() == combo1) {
                        String seleccionado = (String) combo1.getSelectedItem();
                        String lastName = tfLastName.getText();
                        switch (seleccionado) {
                            case "Soles a Dolares" ->
                                lbWelcome.setText(
                                        "<html>" + "El cambio de " + lastName + " " + seleccionado + " es:" + "<p>"
                                                + "$"
                                                + sol.solDolar(Double.parseDouble(lastName)) + " dolares");
                            case "Soles a Euros" ->
                                lbWelcome.setText(
                                        "<html>" + "El cambio de " + lastName + " " + seleccionado + " es:" + "<p>"
                                                + "$"
                                                + sol.solEuro(Double.parseDouble(lastName)) + " euros");
                            case "Dolares a Soles" ->
                                lbWelcome.setText(
                                        "<html>" + "El cambio de " + lastName + " " + seleccionado + " es:" + "<p>"
                                                + "$"
                                                + dolar.dolarSol(Double.parseDouble(lastName)) + " soles");
                            case "Dolares a Euros" ->
                                lbWelcome.setText(
                                        "<html>" + "El cambio de " + lastName + " " + seleccionado + " es:" + "<p>"
                                                + "$"
                                                + dolar.dolarEuro(Double.parseDouble(lastName)) + " euros");
                            case "Euros a Soles" ->
                                lbWelcome.setText(
                                        "<html>" + "El cambio de " + lastName + " " + seleccionado + " es:" + "<p>"
                                                + "$"
                                                + euro.euroSol(Double.parseDouble(lastName)) + " soles");
                            case "Euros a Dolares" ->
                                lbWelcome.setText(
                                        "<html>" + "El cambio de " + lastName + " " + seleccionado + " es:" + "<p>"
                                                + "$"
                                                + euro.euroDolar(Double.parseDouble(lastName)) + " dolares");

                        }

                    }
                } catch (Exception es) {
                    es.printStackTrace();
                    lbWelcome.setText("Porfavor primero ingrese un monto valido =D!");
                }

            }

        });

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 2, 5, 5));
        buttonsPanel.setOpaque(false);
        buttonsPanel.add(btnOK);
        buttonsPanel.add(btnClear);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(128, 128, 255));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(lbWelcome, BorderLayout.CENTER);
        mainPanel.add(buttonsPanel, BorderLayout.SOUTH);

        add(mainPanel);

        setTitle("welcome conversor ALURA =) !!");
        setSize(500, 600);
        setLocation(400, 75);
        setMinimumSize(new Dimension(300, 400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public void atras() {
        Menu menu = new Menu();
        menu.initialize();
        super.dispose();
    }

    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}
