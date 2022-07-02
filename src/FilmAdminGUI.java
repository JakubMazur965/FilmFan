import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FilmAdminGUI extends JFrame {
    private JLabel ikona;
    private JTextField tytuł;
    private JTextField rokProdukcji;
    private JTextField reżyser;
    private JTextField ocenaPole;
    private JTextField gatunek;
    private JButton POWRÓTButton;
    private JTextField nick;
    private JButton wylogujButton;
    private JTextArea opis;
    private JButton oceńFilmButton;
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
    private JButton napiszKomentarzButton;
    private JPanel FilmAdmin;
    private JButton wyświetlKomentarzeButton;
    private JTextField twojaOcena;

    Admin admin;
    Film film;
    Ocena ocena;

    public FilmAdminGUI(Film wybranyFilm, Admin a){
        this.film = wybranyFilm;
        this.admin = a;
        this.ocena = new Ocena(0, film, admin);
        // przy otwarciu okna, bo istnieją już jakieś oceny
        ocena.setOcena(ocena.średniaOcena(ocena.getFilm()));

        setContentPane(FilmAdmin);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        refresh();

        napiszKomentarzButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f = new NowyKomentarzGUI(film, admin);
                f.setPreferredSize(new Dimension(400,300));
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

                Ocena nowaOcena = new Ocena(wybranaOcena, film, admin);

                nowaOcena.dodajOcenę(nowaOcena);
                ocena.setOcena(ocena.średniaOcena(wybranyFilm));
                refresh();
            }
        });

        POWRÓTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f = new FilmFanAdminGUI(admin);
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

        wyświetlKomentarzeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f = new KomentarzAdminGUI(film, admin);
                f.setPreferredSize(new Dimension(600,300));
                f.pack();
                f.setVisible(true);
            }
        });

    }

    public void refresh() {
        nick.setText(admin.getNick());
        ikona.setIcon(film.getIkona());
        tytuł.setText(film.getTytuł());
        gatunek.setText(film.getGatunek());
        ocenaPole.setText(String.valueOf(ocena.getOcena()));
        reżyser.setText(film.getReżyser());
        rokProdukcji.setText(film.getRokProdukcji());
        opis.setText(film.getOpis());
        twojaOcena.setText(ocena.twojaOcena(admin, film));
    }
}
