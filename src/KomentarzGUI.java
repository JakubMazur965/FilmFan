import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class KomentarzGUI extends JFrame implements Serializable {
    private JPanel komentarzPanel;
    private JTextField tytułFilmuKomy;
    private JTextArea treśćKom;
    private JButton anulujButton;

    String treść = "";
    ImageIcon ikona1 = new ImageIcon("");
    Film film = new Film("","","","","", ikona1) ;
    Komentarz kom = new Komentarz("", film, new Użytkownik("","","","","",""));

    public KomentarzGUI(Film wybranyFilm){
        this.film = wybranyFilm;
        setContentPane(komentarzPanel);

        treść = kom.wyświetlKomentarze(film);
        refresh();

        anulujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public void refresh(){
        tytułFilmuKomy.setText(film.getTytuł());
        treśćKom.setText(treść);
    }
}
