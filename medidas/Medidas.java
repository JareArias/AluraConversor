package medidas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import menu.Menu;

public class Medidas extends JFrame {
    final private Font mainFont = new Font("Segoe print", Font.BOLD, 18);
    JTextField tfFirstName, tfLastName;
    JLabel lbWelcome;

    public void initialize() {

        JComboBox<String> combo1 = new JComboBox<String>();
        combo1.setFont(mainFont);

        combo1.addItem("Centimetros a Metros");
        combo1.addItem("Centimetros a Kilometros");
        combo1.addItem("Metros a Centimetros");
        combo1.addItem("Metros a Kilometros");
        combo1.addItem("Kilometros a Centimetros");
        combo1.addItem("Kilometros a Metros");

        // PANEL
        JLabel lbFirsName = new JLabel("Tipo de longitud a convertir: ");
        lbFirsName.setFont(mainFont);

        JLabel lbLastName = new JLabel("Cantidad a convertir: ");
        lbLastName.setFont(mainFont);

        tfLastName = new JTextField();
        tfLastName.setFont(mainFont);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4, 1, 5, 20));
        formPanel.setOpaque(false);
        formPanel.add(lbFirsName);
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
                            case "Centimetros a Metros" ->
                                lbWelcome.setText(
                                        "<html>" + "La longitud de " + lastName + " " + seleccionado + " es:" + "<p>"
                                                + (Double.parseDouble(lastName) / 100) + " metros");
                            case "Centimetros a Kilometros" ->
                                lbWelcome.setText(
                                        "<html>" + "La longitud de " + lastName + " " + seleccionado + " es:" + "<p>"
                                                + (Double.parseDouble(lastName) / 100000) + " kilometros");
                            case "Metros a Centimetros" ->
                                lbWelcome.setText(
                                        "<html>" + "La longitud de " + lastName + " " + seleccionado + " es:" + "<p>"
                                                + (Double.parseDouble(lastName) * 100) + " centimetros");
                            case "Metros a Kilometros" ->
                                lbWelcome.setText(
                                        "<html>" + "La longitud de " + lastName + " " + seleccionado + " es:" + "<p>"
                                                + (Double.parseDouble(lastName) / 1000) + " kilometros");
                            case "Kilometros a Centimetros" ->
                                lbWelcome.setText(
                                        "<html>" + "La longitud de " + lastName + " " + seleccionado + " es:" + "<p>"
                                                + (Double.parseDouble(lastName) * 100000) + " centimetros");
                            case "Kilometros a Metros" ->
                                lbWelcome.setText(
                                        "<html>" + "La longitud de " + lastName + " " + seleccionado + " es:" + "<p>"
                                                + (Double.parseDouble(lastName) * 1000) + " metros");

                        }

                    }
                } catch (Exception es) {
                    es.printStackTrace();
                    lbWelcome.setText("Porfavor primero ingrese una medidad valida =D!");
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

}
