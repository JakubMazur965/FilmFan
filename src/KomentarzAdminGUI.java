import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;

public class KomentarzAdminGUI extends JFrame implements Serializable {
    private JTextArea treśćKom;
    private JPanel komentarzeAdmin;
    private JTextField tytułFilmuKomy;
    private JButton anulujButton;
    private JButton usuńKomentarzButton;
    private JComboBox komyComboBox;

    String treść = "";
    ImageIcon ikona1 = new ImageIcon("");
    Film film = new Film("","","","","", ikona1);
    Admin admin = new Admin("","","","","","", "");
    Komentarz komentarz = new Komentarz("", film, admin);

    ArrayList<Komentarz> komentarze = new ArrayList<>();

    public KomentarzAdminGUI(Film wybranyFilm, Admin a) {
        this.film = wybranyFilm;
        this.admin = a;

        setContentPane(komentarzeAdmin);

        treść = komentarz.wyświetlKomentarze(film);
        komentarze = admin.wczytajKomentarze(komentarze);

        refresh();

        komyComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                komentarz = (Komentarz) komyComboBox.getSelectedItem();
            }
        });

        usuńKomentarzButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                admin.usuńKomentarze(komentarz);
                komentarze = admin.wczytajKomentarze(komentarze);
                komyComboBox.removeItem(komentarz);
                if (komyComboBox.getItemCount() != 0) {
                    treść = komentarz.wyświetlKomentarze(film);
                    refresh();
                } else {
                    treść = "";
                    refresh();
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
        tytułFilmuKomy.setText(film.getTytuł());
        treśćKom.setText(treść);

        komyComboBox.removeAllItems();
        for (Komentarz value : komentarze) {
            if (value.getFilm().getTytuł().equals(film.getTytuł())) {
                komyComboBox.addItem(value);
            }
        }
    }
}
