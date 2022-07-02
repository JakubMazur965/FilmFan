import java.io.*;
import java.util.ArrayList;

public class Admin extends Użytkownik {
    private String kod;

    ArrayList<Użytkownik> użytkownicy = new ArrayList<>();
    ArrayList<Admin> admini = new ArrayList<>();
    ArrayList<Komentarz> komentarze = new ArrayList<>();
    ArrayList<Ocena> oceny = new ArrayList<>();

    public Admin(String imię, String nazwisko, String dataUrodzenia, String płeć, String nick, String hasło, String kod) {
        super(imię, nazwisko, dataUrodzenia, płeć, nick, hasło);
        this.kod = kod;
    }

    public String getKod() {
        return kod;
    }

    public ArrayList<Admin> stwórzAdminów() {

        Admin admin1 = new Admin("Jakub", "Mazur", "07.04.2001", "M", "admin1",
                "admin", "1234");

        Admin admin2 = new Admin("Zuzanna", "Pietrzak", "05.07.2001", "K", "admin2",
                "admin", "1234");

        admini.add(admin1);
        admini.add(admin2);

        return admini;
    }

    public ArrayList<Użytkownik> wczytajUżytkowników(ArrayList<Użytkownik> użytkownicy_) {
        try{
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("użytkownicy.txt"));
            użytkownicy_ = (ArrayList<Użytkownik>) inputStream.readObject();
        } catch (IOException d){
            d.printStackTrace();
        } catch (ClassNotFoundException d){
            d.printStackTrace();
        }

        return użytkownicy_;
    }

    public ArrayList<Komentarz> wczytajKomentarze(ArrayList<Komentarz> komentarze_) {
        try{
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("komentarze.txt"));
            komentarze_ = (ArrayList<Komentarz>) inputStream.readObject();
        } catch (IOException d){
            d.printStackTrace();
        } catch (ClassNotFoundException d){
            d.printStackTrace();
        }

        return komentarze_;
    }

    public Admin zalogujAdmin(String nickZaloguj, String hasłoZaloguj, String kodZaloguj){
        admini = stwórzAdminów();

        for (Admin admin : admini) {
            if ((nickZaloguj.equals(admin.getNick()) && hasłoZaloguj.equals(admin.getHasło())) &&
                    kodZaloguj.equals(admin.getKod())) {
                return admin;
            }
        }
        return null;
    }

    public void usuńUżytkownika(Użytkownik wybranyUżytkownik) {
        try{
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("użytkownicy.txt"));
            użytkownicy = (ArrayList<Użytkownik>) inputStream.readObject();
        } catch (IOException d){
            d.printStackTrace();
        } catch (ClassNotFoundException d){
            d.printStackTrace();
        }

        try{
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("oceny.txt"));
            oceny = (ArrayList<Ocena>) inputStream.readObject();
        } catch (IOException d){
            d.printStackTrace();
        } catch (ClassNotFoundException d){
            d.printStackTrace();
        }


        for (int i = 0; i < użytkownicy.size(); i++){
            if(użytkownicy.get(i).getNick().equals(wybranyUżytkownik.getNick())){
                użytkownicy.remove(użytkownicy.get(i));
            }
        }

        // usuwamy też ocenę użytkownika
        // pętla od tyłu, żeby usunąć wszystkie oceny
        // gdyby szła normalnie to po usunięciu zmieniłyby się indeksy
        for (int i = oceny.size() - 1; i >= 0; i--){
            if(oceny.get(i).getUżytkownik().getNick().equals(wybranyUżytkownik.getNick())){
                oceny.remove(oceny.get(i));
            }
        }

        try{
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("użytkownicy.txt"));
            outputStream.writeObject(użytkownicy);
        } catch (IOException d){
            d.printStackTrace();
        }

        try{
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("oceny.txt"));
            outputStream.writeObject(oceny);
        } catch (IOException d){
            d.printStackTrace();
        }
    }

    public void usuńKomentarze(Komentarz wybranyKomentarz) {
        try{
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("komentarze.txt"));
            komentarze = (ArrayList<Komentarz>) inputStream.readObject();
        } catch (IOException d){
            d.printStackTrace();
        } catch (ClassNotFoundException d){
            d.printStackTrace();
        }

        for (int i = 0; i < komentarze.size(); i++){
            if(komentarze.get(i).getTekst().equals(wybranyKomentarz.getTekst())){
                komentarze.remove(komentarze.get(i));
            }
        }

        try{
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("komentarze.txt"));
            outputStream.writeObject(komentarze);
        } catch (IOException d){
            d.printStackTrace();
        }
    }
}
