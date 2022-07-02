import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FilmGUI extends JFrame {
    private JTextField tytuł;
    private JTextField rokProdukcji;
    private JTextField reżyser;
    private JTextField ocenaPole;
    private JTextField gatunek;
    private JButton oceńFilmButton;
    private JButton napiszKomentarzButton;
    private JButton wyświetlKomentarzeButton;
    private JButton POWRÓTButton;
    private JRadioButton a1RadioButton;
    private JRadioButton a2RadioButton;
    private JRadioButton a3RadioButton;
    private JRadioButton a4RadioButton;
    private JRadioButton a5RadioButton;
    private JRadioButton a10RadioButton;
    private JRadioButton a9RadioButton;
    private JRadioButton a8RadioButton;
    private JRadioButton a7RadioButton;
    private JRadioButton a6RadioButton;
    private JPanel filmPanel;
    private JTextField nick;
    private JLabel ikona;
    private JButton wylogujButton;
    private JTextField twojaOcena;
    private JTextArea opis;

    Film film;
    Użytkownik użytkownik;
    Ocena ocena;

    // otrzymuje jako argument wybrany film z listy i zalogowanego użytkownika
    public FilmGUI(Film wybranyFilm, Użytkownik u){
        // referencja
        this.film = wybranyFilm;
        this.użytkownik = u;
        this.ocena = new Ocena(0, film, użytkownik);
        // przy otwarciu okna, bo istnieją już jakieś oceny
        ocena.setOcena(ocena.średniaOcena(ocena.getFilm()));

        setContentPane(filmPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        refresh();

        napiszKomentarzButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f = new NowyKomentarzGUI(film, użytkownik);
                f.setPreferredSize(new Dimension(400,300));
                f.pack();
                f.setVisible(true);
            }
        });

        wyświetlKomentarzeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f = new KomentarzGUI(film);
                f.setPreferredSize(new Dimension(600,300));
                f.pack();
                f.setVisible(true);
            }
        });

        oceńFilmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int wybranaOcena = 0;

                if (a1RadioButton.isSelected()) wybranaOcena = 1;
                else if (a2RadioButton.isSelected()) wybranaOcena = 2;
                else if (a3RadioButton.isSelected()) wybranaOcena = 3;
                else if (a4RadioButton.isSelected()) wybranaOcena = 4;
                else if (a5RadioButton.isSelected()) wybranaOcena = 5;
                else if (a6RadioButton.isSelected()) wybranaOcena = 6;
                else if (a7RadioButton.isSelected()) wybranaOcena = 7;
                else if (a8RadioButton.isSelected()) wybranaOcena = 8;
                else if (a9RadioButton.isSelected()) wybranaOcena = 9;
                else if (a10RadioButton.isSelected()) wybranaOcena = 10;

                Ocena nowaOcena = new Ocena(wybranaOcena, film, użytkownik);

                nowaOcena.dodajOcenę(nowaOcena);
                ocena.setOcena(ocena.średniaOcena(wybranyFilm));
                refresh();
            }
        });

        POWRÓTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f = new FilmFanZalogowanyGUI(użytkownik);
                f.setPreferredSize(new Dimension(1200, 800));
                f.pack();
                f.setVisible(true);
                dispose();
            }
        });

        wylogujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f = new FilmFanGUI();
                f.setPreferredSize(new Dimension(1200,800));
                f.pack();
                f.setVisible(true);
                dispose();
            }
        });
    }

    public void refresh(){
        nick.setText(użytkownik.getNick());
        ikona.setIcon(film.getIkona());
        tytuł.setText(film.getTytuł());
        gatunek.setText(film.getGatunek());
        ocenaPole.setText(String.valueOf(ocena.getOcena()));
        reżyser.setText(film.getReżyser());
        rokProdukcji.setText(film.getRokProdukcji());
        opis.setText(film.getOpis());
        twojaOcena.setText(ocena.twojaOcena(użytkownik, film));
    }
}
