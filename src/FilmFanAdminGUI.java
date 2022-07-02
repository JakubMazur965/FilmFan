import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FilmFanAdminGUI extends JFrame{
    private JPanel zalogowanyAdminPanel;
    private JTextField nickAdmina;
    private JComboBox comboBoxWszystkieFilmy;
    private JButton wylogujButton;
    private JLabel logo;
    private JLabel film1;
    private JTextField tytul1;
    private JTextField ocena1;
    private JLabel film2;
    private JTextField tytul2;
    private JTextField ocena2;
    private JLabel film3;
    private JTextField tytul3;
    private JTextField ocena3;
    private JComboBox użytkownicyComboBox;
    private JButton usuńUżytkownikaButton;

    Admin admin;
    Użytkownik użytkownik = new Użytkownik("", "", "", "", "", "");
    Film film = new Film("", "", "", "", "", new ImageIcon(""));
    Ocena ocena = new Ocena(0, film, użytkownik);

    ArrayList<Film> filmy = new ArrayList<>();
    ArrayList<Ocena> oceny = new ArrayList<>();
    ArrayList<Użytkownik> użytkownicy = new ArrayList<>();

    public FilmFanAdminGUI(Admin a){
        setContentPane(zalogowanyAdminPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.admin = a;
        filmy = film.stwórzFilmy(filmy);
        ocena.wczytajOceny(oceny);
        użytkownicy = admin.wczytajUżytkowników(użytkownicy);
        filmy = ocena.posortowaneFilmy(filmy,ocena);

        for (Film value : filmy) {
            comboBoxWszystkieFilmy.addItem(value);
        }

        for (Użytkownik value : użytkownicy) {
            użytkownicyComboBox.addItem(value);
        }

        refresh();

        comboBoxWszystkieFilmy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Film value : filmy) {
                    // wybór filmu z comboBoxa
                    if (comboBoxWszystkieFilmy.getSelectedItem().toString().equals(value.getTytuł())) {
                        JFrame f = new FilmAdminGUI(value, admin);
                        f.setPreferredSize(new Dimension(1000, 600));
                        f.pack();
                        f.setVisible(true);
                        dispose();
                    }
                }
            }
        });

        użytkownicyComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                użytkownik = (Użytkownik) użytkownicyComboBox.getSelectedItem();
            }
        });

        usuńUżytkownikaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                admin.usuńUżytkownika(użytkownik);
                użytkownicy = admin.wczytajUżytkowników(użytkownicy);
                użytkownicyComboBox.removeItem(użytkownik);
                filmy = ocena.posortowaneFilmy(filmy,ocena);
                refresh();
            }
        });

        wylogujButton.addActionListener(new ActionListener() {
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

    public void refresh() {
        nickAdmina.setText(admin.getNick());

        // top 3 filmy
        film1.setIcon(filmy.get(0).getIkona());
        tytul1.setText(filmy.get(0).getTytuł());
        ocena1.setText(String.valueOf(ocena.średniaOcena(filmy.get(0))));

        film2.setIcon(filmy.get(1).getIkona());
        tytul2.setText(filmy.get(1).getTytuł());
        ocena2.setText(String.valueOf(ocena.średniaOcena(filmy.get(1))));

        film3.setIcon(filmy.get(2).getIkona());
        tytul3.setText(filmy.get(2).getTytuł());
        ocena3.setText(String.valueOf(ocena.średniaOcena(filmy.get(2))));
    }


}
