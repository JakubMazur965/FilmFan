import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class ZałóżKontoGUI extends JFrame implements Serializable {
    private JTextField imię;
    private JTextField nazwisko;
    private JTextField dataUrodzenia;
    private JTextField płeć;
    private JTextField nick;
    private JButton załóżKontoButton;
    private JButton anulujButton;
    private JPanel panelZałóżKonto;
    private JPasswordField passwordField1;
    private JLabel brakDanych;
    private JLabel zajętyNick;

    public ZałóżKontoGUI() {
        setContentPane(panelZałóżKonto);

        refresh();

        załóżKontoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refresh();

                Użytkownik nowy = new Użytkownik(imię.getText(), nazwisko.getText(), dataUrodzenia.getText(), płeć.getText(),
                        nick.getText(), passwordField1.getText());

                int logger = nowy.załóżKonto(nowy);

                if (logger == 0) {
                    brakDanych.setVisible(true);
                }
                else if (logger == 1) {
                    zajętyNick.setVisible(true);
                } else {
                    dispose();
                }
            }
        });

        anulujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public void refresh() {
        brakDanych.setVisible(false);
        zajętyNick.setVisible(false);
    }
}
