import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZalogujGUI extends JFrame {

    private JPanel panel;
    private JTextField nick;
    private JTextField kod;
    private JButton zalogujButton;
    private JButton zapomniałemHasłaButton;
    private JButton zalogujJakoAdministratorButton;
    private JButton anulujButton;
    private JPasswordField hasło;
    private JLabel błędnyLoginLubHasło;
    private JLabel błędnyKod;

    Admin admin = new Admin("", "", "", "", "", "", "");
    Użytkownik użytkownik = new Użytkownik("", "", "", "", "", "");

    public ZalogujGUI(){
        setContentPane(panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        refresh();

        zalogujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nick_ = nick.getText();
                String hasło_ = hasło.getText();

                Użytkownik logger = użytkownik.zaloguj(nick_, hasło_);

                if (logger == null) {
                    // komunikat GUI
                    błędnyLoginLubHasło.setVisible(true);
                } else {
                    JFrame f = new FilmFanZalogowanyGUI(logger);
                    f.setPreferredSize(new Dimension(1200, 800));
                    f.pack();
                    f.setVisible(true);
                    dispose();
                }
            }
        });

        zalogujJakoAdministratorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nick_ = nick.getText();
                String hasło_ = hasło.getText();
                String kod_ = kod.getText();

                Admin logger = admin.zalogujAdmin(nick_, hasło_, kod_);

                if (logger == null) {
                    // komunikat GUI
                    błędnyKod.setVisible(true);
                } else {
                    JFrame f = new FilmFanAdminGUI(logger);
                    f.setPreferredSize(new Dimension(1200, 800));
                    f.pack();
                    f.setVisible(true);
                    dispose();
                }
            }
        });

        zapomniałemHasłaButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame f = new ZapomniałemHasłaGUI();
            f.setPreferredSize(new Dimension(400,300));
            f.pack();
            f.setVisible(true);
            dispose();
        }
    });

        anulujButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame f = new FilmFanGUI();
            f.setPreferredSize(new Dimension(1200, 800));
            f.pack();
            f.setVisible(true);
            dispose();
        }
    });
    }

    public void refresh(){
        błędnyLoginLubHasło.setVisible(false);
        błędnyKod.setVisible(false);
    }
}
