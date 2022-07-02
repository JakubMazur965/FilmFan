import java.io.*;
import java.util.ArrayList;

public class Użytkownik implements Serializable {
    private String imię;
    private String nazwisko;
    private String dataUrodzenia;
    private String płeć;
    private String nick;
    private String hasło;

    ArrayList<Użytkownik> użytkownicy = new ArrayList<>();

    public Użytkownik(String imię, String nazwisko, String dataUrodzenia, String płeć, String nick, String hasło) {
        this.imię = imię;
        this.nazwisko = nazwisko;
        this.dataUrodzenia = dataUrodzenia;
        this.płeć = płeć;
        this.nick = nick;
        this.hasło = hasło;
    }

    public String getImię() {
        return imię;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getDataUrodzenia() {
        return dataUrodzenia;
    }

    public String getPłeć() {
        return płeć;
    }

    public String getHasło() {
        return hasło;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Użytkownik zaloguj(String nickZaloguj, String hasłoZaloguj) {
        try{
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("użytkownicy.txt"));
            użytkownicy = (ArrayList<Użytkownik>) inputStream.readObject();
        } catch (IOException d){
            d.printStackTrace();
        } catch (ClassNotFoundException d){
            d.printStackTrace();
        }

        for (Użytkownik użytkownik : użytkownicy) {
            if (nickZaloguj.equals(użytkownik.getNick()) && hasłoZaloguj.equals(użytkownik.getHasło())) {
                return użytkownik;
            }
        }
        return null;
    }

    public Użytkownik zapomniałemHasła(String nickHasło, String dataHasło, String imięHasło, String nazwiskoHasło) {
        try{
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("użytkownicy.txt"));
            użytkownicy = (ArrayList<Użytkownik>) inputStream.readObject();
        } catch (IOException d){
            d.printStackTrace();
        } catch (ClassNotFoundException d){
            d.printStackTrace();
        }

        for (Użytkownik użytkownik : użytkownicy) {
            if (dataHasło.equals(użytkownik.getDataUrodzenia()) && imięHasło.equals(użytkownik.getImię())
                    && nazwiskoHasło.equals(użytkownik.getNazwisko()) && nickHasło.equals(użytkownik.getNick())) {
                return użytkownik;
            }
        }
        return null;
    }

    public int załóżKonto (Użytkownik nowy) {
        try{
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("użytkownicy.txt"));
            użytkownicy = (ArrayList<Użytkownik>) inputStream.readObject();
        } catch (IOException d){
            d.printStackTrace();
        } catch (ClassNotFoundException d){
            d.printStackTrace();
        }

        if ((nowy.getImię().isEmpty()) || (nowy.getNazwisko().isEmpty()) || (nowy.getDataUrodzenia().isEmpty()) ||
                (nowy.getPłeć().isEmpty()) || (nowy.getNick().isEmpty()) || (nowy.getHasło().isEmpty())) {
            return 0;
        } else {
            int zajęty = 0;


            for (Użytkownik użytkownik : użytkownicy) {
                if (nowy.getNick().equals(użytkownik.getNick())) {
                    zajęty = 1;
                }
            }

            if (zajęty == 0) {
                użytkownicy.add(nowy);
            } else {
                return 1;
            }
        }

        try{
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("użytkownicy.txt"));
            outputStream.writeObject(użytkownicy);
        } catch (IOException d){
            d.printStackTrace();
        }

        return 2;
    }

    @Override
    public String toString(){
        String wyświetl = nick;
        return wyświetl;
    }
}

