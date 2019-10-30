public class Istorie extends Carte {
    private String eveniment;

    public Istorie(String nume, String autor, int isbn, float pret, String eveniment) {
        super(nume, autor, isbn, pret);
        this.eveniment = eveniment;
    }

    public String getEveniment() {
        return eveniment;
    }

    public void setEveniment(String eveniment) {
        this.eveniment = eveniment;
    }
}
