import java.io.*;
import java.util.ArrayList;

public class Ocena implements Serializable {
    private double ocena;
    private Film film;
    private Użytkownik użytkownik;

    ArrayList<Ocena> oceny = new ArrayList<>();

    public Ocena(double ocenaPrzekazana, Film wybranyFilm, Użytkownik u) {
        this.ocena = ocenaPrzekazana;
        this.film = wybranyFilm;
        this.użytkownik = u;
    }

    public double getOcena() {
        return ocena;
    }

    public Film getFilm() {
        return film;
    }

    public Użytkownik getUżytkownik() {
        return użytkownik;
    }

    public void setOcena(double ocena) {
        this.ocena = ocena;
    }

    public ArrayList<Ocena> wczytajOceny(ArrayList<Ocena> oceny_) {
        try{
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("oceny.txt"));
            oceny_ = (ArrayList<Ocena>) inputStream.readObject();
        } catch (IOException d){
            d.printStackTrace();
        } catch (ClassNotFoundException d){
            d.printStackTrace();
        }

        return oceny_;
    }

    public void dodajOcenę (Ocena nowaOcena){
        try{
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("oceny.txt"));
            oceny = (ArrayList<Ocena>) inputStream.readObject();
        } catch (IOException d){
            d.printStackTrace();
        } catch (ClassNotFoundException d){
            d.printStackTrace();
        }

        boolean czyOcenione = false;

        for (Ocena value : oceny) {
            if (nowaOcena.getUżytkownik().getNick().equals(value.getUżytkownik().getNick()) &&
                    nowaOcena.getFilm().getTytuł().equals(value.getFilm().getTytuł())) {
                czyOcenione = true;
            }
        }

        if (!czyOcenione){
            oceny.add(nowaOcena);
        }
        else {
            for (int i = 0; i < oceny.size(); i++) {
                if(nowaOcena.getUżytkownik().getNick().equals(oceny.get(i).getUżytkownik().getNick()) &&
                        nowaOcena.getFilm().getTytuł().equals(oceny.get(i).getFilm().getTytuł())){
                    oceny.remove(oceny.get(i));
                }
            }
            oceny.add(nowaOcena);
        }

        try{
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("oceny.txt"));
            outputStream.writeObject(oceny);
        } catch (IOException d){
            d.printStackTrace();
        }
    }

    public double średniaOcena(Film wybranyFilm) {
        double średniaOcena_;
        double sumaOcen = 0;
        double ilośćOcen = 0;

        try{
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("oceny.txt"));
            oceny = (ArrayList<Ocena>) inputStream.readObject();
        } catch (IOException d){
            d.printStackTrace();
        } catch (ClassNotFoundException d){
            d.printStackTrace();
        }

        for (Ocena value : oceny) {
            if (wybranyFilm.getTytuł().equals(value.getFilm().getTytuł())) {
                sumaOcen = sumaOcen + value.getOcena();
                ilośćOcen = ilośćOcen + 1;
            }
        }

        średniaOcena_ = sumaOcen / ilośćOcen;

        // zaokrąglanie do 2 miejsc po przecinku
        int miejscePoPrzecinku = (int)Math.pow(10, 2);
        średniaOcena_ *= miejscePoPrzecinku;
        średniaOcena_ = Math.round(średniaOcena_);
        średniaOcena_ /= miejscePoPrzecinku;

        return średniaOcena_;
    }

    public ArrayList<Film> posortowaneFilmy(ArrayList<Film> filmy, Ocena ocena_) {

        for (int i = 0; i < filmy.size(); i++) {
            for (int j = 0; j < filmy.size() - 1; j++) {
                if (ocena_.średniaOcena(filmy.get(j+1)) > ocena_.średniaOcena(filmy.get(j))) {
                    Film temp;
                    temp = filmy.get(j);
                    filmy.set(j,filmy.get(j+1));
                    filmy.set(j+1,temp);
                }
            }
        }

        return filmy;
    }

    public String twojaOcena(Użytkownik aktualnyUżytkownik, Film wybranyFilm) {
        String ocena_ = "ten film jeszcze nie jest przez Ciebie oceniony";

        try{
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("oceny.txt"));
            oceny = (ArrayList<Ocena>) inputStream.readObject();
        } catch (IOException d){
            d.printStackTrace();
        } catch (ClassNotFoundException d){
            d.printStackTrace();
        }

        for (Ocena value : oceny) {
            if (value.getUżytkownik().getNick().equals(aktualnyUżytkownik.getNick())
                    && value.getFilm().getTytuł().equals(wybranyFilm.getTytuł())) {
                ocena_ = String.valueOf(value.getOcena());
            }
        }

        return ocena_;
    }

}
