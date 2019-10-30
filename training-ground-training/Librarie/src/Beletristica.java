public class Beletristica extends Carte {
    private int nrPersonaje;

    public Beletristica(String nume, String autor, int isbn, float pret, int nrPersonaje) {
        super(nume, autor, isbn, pret);
        this.nrPersonaje = nrPersonaje;
    }

    public int getNrPersonaje() {
        return nrPersonaje;
    }

    public void setNrPersonaje(int nrPersonaje) {
        this.nrPersonaje = nrPersonaje;
    }
}
