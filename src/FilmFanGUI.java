import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FilmFanGUI extends JFrame {
    private JButton zalogujButton;
    private JButton załóżKontoButton;
    private JTextField tytul1;
    private JTextField ocena1;
    private JTextField tytul2;
    private JTextField ocena2;
    private JTextField tytul3;
    private JTextField ocena3;
    private JPanel niezalogowanyPanel;
    private JLabel film1;
    private JLabel film2;
    private JLabel film3;
    private JLabel logo;

    Użytkownik użytkownik = new Użytkownik("", "", "", "", "", "");
    Film film = new Film("", "", "", "", "", new ImageIcon(""));
    Ocena ocena = new Ocena(0, film, użytkownik);

    ArrayList<Film> filmy = new ArrayList<>();
    ArrayList<Ocena> oceny = new ArrayList<>();

    public FilmFanGUI() {
        setContentPane(niezalogowanyPanel);
        // koniec Maina
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        filmy = film.stwórzFilmy(filmy);
        ocena.wczytajOceny(oceny);
        // sortowanie po ocenach
        filmy = ocena.posortowaneFilmy(filmy, ocena);

        refresh();

        zalogujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f = new ZalogujGUI();
                f.setPreferredSize(new Dimension(400,300));
                f.pack();
                f.setVisible(true);
                dispose();
            }
        });

        załóżKontoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f = new ZałóżKontoGUI();
                f.setPreferredSize(new Dimension(400,300));
                f.pack();
                f.setVisible(true);
            }
        });
    }

    public void refresh(){
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
