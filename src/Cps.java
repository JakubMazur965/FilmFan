import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cps {

    public Map<Integer, Integer> ksiazka = new HashMap<>();

    public void setKsiazka(){
        ksiazka.put(1, 110);
        ksiazka.put(2, 1111);
        ksiazka.put(3, 1110);
        ksiazka.put(4, 10);
        ksiazka.put(5, 0);
    }

    public List<Integer> code(List<Integer> input){
        return input.stream().map(x -> ksiazka.get(x)).toList();
    }



    public static void main(String[] args) {
        List<Integer> wiadomosc = new ArrayList<>();
        //5, 4, 1, 5, 4, 1, 2, 3, 4, 5
        wiadomosc.add(5);
        wiadomosc.add(4);
        wiadomosc.add(1);
        wiadomosc.add(5);
        wiadomosc.add(4);
        wiadomosc.add(1);
        wiadomosc.add(2);
        wiadomosc.add(3);
        wiadomosc.add(4);
        wiadomosc.add(5);

        Cps cps = new Cps();
        cps.setKsiazka();
        System.out.println(cps.code(wiadomosc));
    }
}

