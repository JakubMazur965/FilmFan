import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FilmFanZalogowanyGUI extends JFrame{
    private JTextField tytul1;
    private JTextField ocena1;
    private JTextField tytul2;
    private JTextField ocena2;
    private JTextField tytul3;
    private JTextField ocena3;
    private JComboBox comboBoxWszystkieFilmy;
    private JTextField nazwaUżytkownika;
    private JPanel zalogowanyPanel;
    private JButton wylogujButton;
    private JLabel logo;
    private JLabel film2;
    private JLabel film3;
    private JLabel film1;

    Użytkownik użytkownik = new Użytkownik("", "", "", "", "", "") ;
    Film film = new Film("", "", "", "", "", new ImageIcon(""));
    Ocena ocena = new Ocena(0, film, użytkownik);

    ArrayList<Film> filmy = new ArrayList<>();
    ArrayList<Ocena> oceny = new ArrayList<>();

    public FilmFanZalogowanyGUI (Użytkownik u){
        setContentPane(zalogowanyPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // referencja
        this.użytkownik = u;
        filmy = film.stwórzFilmy(filmy);
        ocena.wczytajOceny(oceny);
        // sortowanie po ocenach
        filmy = ocena.posortowaneFilmy(filmy, ocena);

        // dodanie filmów do comboBoxa
        for (Film value : filmy) {
            comboBoxWszystkieFilmy.addItem(value);
        }

        refresh();

        comboBoxWszystkieFilmy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Film value : filmy) {
                    // wybór filmu z comboBoxa
                    if (comboBoxWszystkieFilmy.getSelectedItem().toString().equals(value.getTytuł())) {
                        JFrame f = new FilmGUI(value, użytkownik);
                        f.setPreferredSize(new Dimension(1000, 600));
                        f.pack();
                        f.setVisible(true);
                        dispose();
                    }
                }
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

    public void refresh(){
        nazwaUżytkownika.setText(użytkownik.getNick());

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
