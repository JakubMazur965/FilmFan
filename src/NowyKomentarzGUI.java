import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NowyKomentarzGUI extends JFrame {
    private JPanel nowyKomentarzPanel;
    private JTextArea nowyKom;
    private JTextField tytułFilmuNowyKom;
    private JButton dodajKomentarzButton;
    private JButton anulujButton;
    private JLabel pustyKom;

    Film film;
    Użytkownik użytkownik;

    public NowyKomentarzGUI(Film wybranyFilm, Użytkownik u){

        setContentPane(nowyKomentarzPanel);
        this.film = wybranyFilm;
        this.użytkownik = u;
        setResizable(false);
        refresh();

        dodajKomentarzButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Komentarz nowy = new Komentarz(nowyKom.getText(), film, u);
                int kom = nowy.dodajKomentarz(nowy);

                refresh();

                if (kom == 0) {
                    pustyKom.setVisible(true);
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

    public void refresh(){
        tytułFilmuNowyKom.setText(film.getTytuł());
        pustyKom.setVisible(false);
    }
}
