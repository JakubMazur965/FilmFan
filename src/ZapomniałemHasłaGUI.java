import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZapomniałemHasłaGUI extends JFrame {
    private JButton zalogujButton;
    private JButton anulujButton;
    private JTextField imię;
    private JTextField nazwisko;
    private JTextField dataUrodzenia;
    private JPanel ZH_Panel;
    private JLabel błędneDane;
    private JTextField nick;

    Użytkownik użytkownik = new Użytkownik("", "", "", "", "", "");

    public ZapomniałemHasłaGUI(){
        setContentPane(ZH_Panel);

        refresh();

        zalogujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nick = ZapomniałemHasłaGUI.this.nick.getText();
                String imię = ZapomniałemHasłaGUI.this.imię.getText();
                String nazwisko = ZapomniałemHasłaGUI.this.nazwisko.getText();
                String data = dataUrodzenia.getText();

                Użytkownik logger = użytkownik.zapomniałemHasła(nick, data, imię, nazwisko);

                if (logger == null) {
                    // komunikat GUI
                    błędneDane.setVisible(true);
                } else {
                    JFrame f = new FilmFanZalogowanyGUI(logger);
                    f.setPreferredSize(new Dimension(1200, 800));
                    f.pack();
                    f.setVisible(true);
                    dispose();
                }
            }
        });

        anulujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f = new ZalogujGUI();
                f.setPreferredSize(new Dimension(400,300));
                f.pack();
                f.setVisible(true);
                dispose();
            }
        });
    }

    public void refresh() {
        błędneDane.setVisible(false);
    }
}
