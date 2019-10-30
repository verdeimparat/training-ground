import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Librarie {
    private static Librarie singleton = null;
    private List<Carte> carteList = new ArrayList<>();

    private Librarie() {

    }

    public static Librarie getInstance() {
        if (singleton == null) {
            singleton = new Librarie();
        }
        return singleton;
    }

    public List<Carte> getCarteList() {
        return carteList;
    }

    public void setCarteList(List<Carte> carteList) {
        this.carteList = carteList;
    }

    public void afisareCarti() {
        this.carteList.forEach(i -> System.out.println(i));
    }

    public void afisareCartiIstorie() {
        this.carteList.forEach(i -> {if(i instanceof Istorie) {
            System.out.println(i);}
        });
    }

    public void stergereCarteDupaAutor(String autor) {
        this.carteList.removeIf(carte -> carte.getAutor().equals(autor));
    }

    public void adaugareCarte(Carte carte) throws NotEnoughSpaceException, DuplicateIsbnException {
        if(this.carteList.size() > 100) {
            throw new NotEnoughSpaceException("Capacitate depasita");
        }
        if(this.carteList.contains(carte.getIsbn())) {
            throw new DuplicateIsbnException("Cartea deja exista");
        }
        this.carteList.add(carte);
    }

    public void cumparareCarte(int isbn) {
        this.carteList.removeIf(carte -> (carte.getIsbn() == isbn));
    }
}
