import java.io.*;
import java.util.ArrayList;

public class Komentarz implements Serializable {
    private String tekst;
    private Film film;
    private Użytkownik użytkownik;
    ArrayList<Komentarz> komentarze = new ArrayList<>();

    public Komentarz(String tekst, Film wybranyFilm, Użytkownik u) {
        this.tekst = tekst;
        this.film = wybranyFilm;
        this.użytkownik = u;
    }

    public String getTekst() {
        return tekst;
    }

    public Film getFilm() {
        return film;
    }

    public Użytkownik getUżytkownik() {
        return użytkownik;
    }

    public int dodajKomentarz(Komentarz nowy){
        try{
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("komentarze.txt"));
            komentarze = (ArrayList<Komentarz>) inputStream.readObject();
        } catch (IOException d){
            d.printStackTrace();
        } catch (ClassNotFoundException d){
            d.printStackTrace();
        }

        if (nowy.getTekst().isEmpty()) {
            return 0;
        } else {
            komentarze.add(nowy);
        }

        try{
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("komentarze.txt"));
            outputStream.writeObject(komentarze);
        } catch (IOException d){
            d.printStackTrace();
        }

        return 1;
    }

    public String wyświetlKomentarze (Film wybranyFilm){
        String treść = "";

        try{
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("komentarze.txt"));
            komentarze = (ArrayList<Komentarz>) inputStream.readObject();
        } catch (IOException d){
            d.printStackTrace();
        } catch (ClassNotFoundException d){
            d.printStackTrace();
        }

        for (Komentarz komentarz : komentarze) {
            if (wybranyFilm.getTytuł().equals(komentarz.getFilm().getTytuł())) {
                treść = treść + komentarz.getUżytkownik().getNick() + ": " + komentarz.getTekst() + "\n";
            }
        }

        return treść;
    }

    @Override
    public String toString(){
        String wyświetl = użytkownik.getNick() +": " + tekst;
        return wyświetl;
    }
}
