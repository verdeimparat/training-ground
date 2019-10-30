public class Carte {
    private String nume;
    private String autor;
    private int isbn;
    private float pret;

    public Carte(String nume, String autor, int isbn, float pret) {
        this.nume = nume;
        this.autor = autor;
        this.isbn = isbn;
        this.pret = pret;
    }

    @Override
    public String toString() {
        return "Carte{" +
                "nume='" + nume + '\'' +
                ", autor='" + autor + '\'' +
                ", isbn=" + isbn +
                ", pret=" + pret +
                '}';
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }
}
