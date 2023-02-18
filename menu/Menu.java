package menu;

import javax.swing.*;

import divisas.Monedas;
import medidas.Medidas;

import java.awt.*;
import java.awt.event.*;

public class Menu extends JFrame {

    final private Font mainFont = new Font("Segoe print", Font.BOLD, 24);
    JTextField tfFirstName, tfLastName, tfMonedas;
    JLabel lbWelcome;

    public void initialize() {

        // PANEL
        JLabel lbFirsName = new JLabel("***************ALURA****************");
        lbFirsName.setFont(mainFont);

        JLabel tfLastName = new JLabel("************CONVERSOR*************");
        tfLastName.setFont(mainFont);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(2, 1, 5, 20));
        formPanel.setOpaque(false);
        formPanel.add(lbFirsName);
        // formPanel.add(tfFirstName);

        formPanel.add(tfLastName);

        // WELCOME LABEL
        lbWelcome = new JLabel();
        lbWelcome.setFont(mainFont);

        lbWelcome.setText("Menú");

        // BUTTONS PANEL
        JButton btnOK = new JButton("Conversor Divisas");
        btnOK.setFocusable(false);
        btnOK.setFont(mainFont);

        btnOK.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnOK) {
                    monedas();
                }
            }
        });

        JButton btnClear = new JButton("Conversor Medidas");
        btnClear.setFont(mainFont);
        btnClear.setFocusable(false);
        btnClear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnClear) {
                    medidas();
                }
            }

        });

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(2, 1, 5, 5));
        buttonsPanel.setOpaque(false);
        buttonsPanel.add(btnOK);
        buttonsPanel.add(btnClear);
        buttonsPanel.setFocusable(false);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(128, 128, 255));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(lbWelcome, BorderLayout.CENTER);
        mainPanel.add(buttonsPanel, BorderLayout.SOUTH);

        add(mainPanel);

        setTitle("welcome conversor ALURA =) !!");
        setSize(500, 400);
        setLocation(400, 75);
        setMinimumSize(new Dimension(300, 400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public void monedas() {
        Monedas monedas = new Monedas();
        monedas.initialize();
        super.dispose();
    }

    public void medidas() {
        Medidas medidas = new Medidas();
        medidas.initialize();
        super.dispose();
    }

}
