import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;

public class Film implements Serializable {
    private String tytuł;
    private String gatunek;
    private String rokProdukcji;
    private String reżyser;
    private String opis;
    private ImageIcon ikona;

    public Film(String tytuł, String gatunek, String rokProdukcji, String reżyser, String opis, ImageIcon ikona) {
        this.tytuł = tytuł;
        this.gatunek = gatunek;
        this.rokProdukcji = rokProdukcji;
        this.reżyser = reżyser;
        this.opis = opis;
        this.ikona = ikona;
    }

    public String getTytuł() {
        return tytuł;
    }

    public String getGatunek() {
        return gatunek;
    }

    public String getRokProdukcji() {
        return rokProdukcji;
    }

    public String getReżyser() {
        return reżyser;
    }

    public String getOpis() {
        return opis;
    }

    public ImageIcon getIkona() {
        return ikona;
    }

    public ArrayList <Film> stwórzFilmy(ArrayList <Film> filmy){

        ImageIcon ikona1 = new ImageIcon("filmweb/src/siedem.png");
        ImageIcon ikona2 = new ImageIcon("filmweb/src/potwory.png");
        ImageIcon ikona3 = new ImageIcon("filmweb/src/piraci.png");
        ImageIcon ikona4 = new ImageIcon("filmweb/src/ogien.png");
        ImageIcon ikona5 = new ImageIcon("filmweb/src/wilk.png");
        ImageIcon ikona6 = new ImageIcon("filmweb/src/mila.png");
        ImageIcon ikona7 = new ImageIcon("filmweb/src/dzentelmeni.png");
        ImageIcon ikona8 = new ImageIcon("filmweb/src/doubtfire.png");
        ImageIcon ikona9 = new ImageIcon("filmweb/src/contratiempo.png");
        ImageIcon ikona10 = new ImageIcon("filmweb/src/adwokat.png");

        Film f1 = new Film("Siedem", "thriller", "1995", "David Fincher",
                "Dwóch policjantów stara się złapać seryjnego mordercę wybierającego swoje ofiary według"+
                        "specjalnego klucza - siedmiu grzechów" + "\n" + "głównych.", ikona1);

        Film f2 = new Film("Potwory i Spółka", "familijny", "2001", "Pete Docter",
                "Potwory straszą dzieci, bo to ich praca, ale w rzeczywistości panicznie się ich boją. " +
                        "Pewnego razu do ich świata trafia dziewczynka," + "\n" +
                        "która nie czuje przed nimi strachu.", ikona2);

        Film f3 = new Film("Piraci z Karaibów na nieznanych wodach","przygodowy", "2011",
                "Rob Marshall", "Kapitan Jack Sparrow poszukuje słynnej Fontanny Młodości. " +
                "Na swojej drodze spotyka piękną Angelicę i okrutnego Czarnobrodego.", ikona3);

        Film f4 = new Film("Ogniem i Mieczem", "historyczny", "1999", "Jerzy Hoffman",
                "Adaptacja powieści Henryka Sienkiewicza. XVII wiek, na Kresach Wschodnich zbliża się wojna " +
                        "pomiędzy Rzeczpospolitą a Kozakami.", ikona4);

        Film f5 = new Film("Wilk z Wall Street", "komedia kryminalna", "2013",
                "Martin Scorsese", "Historia Jordana Belforta, brokera, którego błyskawiczna droga na " +
                "szczyt i rozrzutny styl życia wzbudziły zainteresowanie FBI.", ikona5);

        Film f6 = new Film("Zielona Mila", "dramat", "1999", "Frank Darabont",
                "Emerytowany strażnik więzienny opowiada przyjaciółce o niezwykłym mężczyźnie, którego skazano" +
                        "na śmierć za zabójstwo dwóch" + "\n" + "9-letnich dziewczynek.", ikona6);

        Film f7 = new Film("Dżentelmeni", "kryminał", "2019", "Guy Ritchie",
                "Handlarz marihuany postanawia sprzedać narkotykowe imperium i przejść na emeryturę. Pożegnanie " +
                        "z półświatkiem nie będzie" + "\n" + "jednak tak łatwe, jak mogło mu się wydawać.", ikona7);

        Film f8 = new Film("Pani Doubtfire", "komedia", "1993", "Chris Columbus",
                "Daniel Hillard zatrudnia się jako gosposia swojej byłej żony, by spędzać więcej czasu z " +
                        "dziećmi. Nikt nie wie, kim jest naprawdę, bo" + "\n" +
                        "pracuje w przebraniu jako pani Doubtfire.", ikona8);

        Film f9 = new Film("Contratiempo", "kryminał", "2016", "Oriol Paulo",
                "Po przebudzeniu się w pokoju hotelowym obok martwej kochanki młody biznesmen zatrudnia wybitną" +
                        " adwokat, aby ustalić, do czego" + "\n" + "tak naprawdę doszło.", ikona9);

        Film f10 = new Film("Adwokat Diabła", "thriller", "1997", "Taylor Hackford",
                "Kevin Lomax - wybitny adwokat, skuszony intratną propozycją pracy, przeprowadza się do " +
                        "Nowego Jorku. Nie zdaje sobie jednak"+ "\n" +
                        "sprawy z tego, kim jest jego chlebodawca.", ikona10);

        filmy.add(f1);
        filmy.add(f2);
        filmy.add(f3);
        filmy.add(f4);
        filmy.add(f5);
        filmy.add(f6);
        filmy.add(f7);
        filmy.add(f8);
        filmy.add(f9);
        filmy.add(f10);

        return filmy;
    }

    // wyświetlanie w comboBoxie
    @Override
    public String toString(){
        String wyświetl = tytuł;
        return wyświetl;
    }

}
