import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

public class Depense {
    private String description;
    private double montant;
    private Categories categorie;
    private LocalDate date;

    public Depense (String description, double montant, Categories categorie, LocalDate date){
        this.description = description;
        this.montant = montant;
        this.categorie = categorie;
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Categories getCategorie() {
        return categorie;
    }

    public void setCategorie(Categories categorie) {
        this.categorie = categorie;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Depense{" +
                "description='" + description + '\'' +
                ", montant=" + montant +
                ", categorie='" + categorie + '\'' +
                ", date=" + date +
                '}';
    }
}
