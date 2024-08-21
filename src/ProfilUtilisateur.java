import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProfilUtilisateur {
    private String nom;
    private double budgetMensuel;
    private List<Depense> depenses;

    public ProfilUtilisateur(String nom, double budgetMensuel, Depense depense){
        this.nom = nom;
        this.budgetMensuel = budgetMensuel;
        this.depenses = new ArrayList<>();
        depenses.add(depense);
    }

    public ProfilUtilisateur(String nom, double budgetMensuel){
        this.nom = nom;
        this.budgetMensuel = budgetMensuel;
        this.depenses = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getBudgetMensuel() {
        return budgetMensuel;
    }

    public void setBudgetMensuel(double budgetMensuel) {
        this.budgetMensuel = budgetMensuel;
    }

    public List<Depense> getDepenses() {
        return depenses;
    }

    public void setDepenses(List<Depense> depenses) {
        this.depenses = depenses;
    }

    public void ajoutDepense (String description, double montant, Categories categorie, LocalDate date){
        if (montant <= 0){
            System.out.println("Cette action ne peut être effectuer !");
        }
        else{
            Depense newDepense = new Depense(description, montant, categorie, date);
            this.depenses.add(newDepense);
            System.out.println("Dépense ajoutée !");
        }

    }

    public List<Depense> affichageParCategorie(Categories categorie){
        ArrayList<Depense> tableauDepense = new ArrayList<>();

        for (Depense depense : depenses){
            if (depense.getCategorie() == categorie){
                tableauDepense.add(depense);
            }
        }

        return tableauDepense;
    }

    public List<Depense> afficherTousParDate(){
        ArrayList<Depense> mesDepenses = new ArrayList<>();
        mesDepenses.addAll(depenses);

        Collections.sort(mesDepenses, (d1, d2) -> d2.getDate().compareTo(d1.getDate()));
        return mesDepenses;




    }

    public double totalDepenseduMois(){
        List<Depense> depenseDuMois =  getDepenses().stream()
                .filter(depense -> depense.getDate().getYear() == LocalDate.now().getYear())
                .filter(depense -> depense.getDate().getMonth() == LocalDate.now().getMonth())
                .toList();

        int acc = 0;
        for (Depense depense: depenseDuMois){
            acc +=  depense.getMontant();
        }

        return acc;

    }

    public double budgetRestant(){
        return this.getBudgetMensuel() - this.totalDepenseduMois();
    }

    public void alertDepassementBudget(){
        if (this.getBudgetMensuel() < totalDepenseduMois() ){
            System.out.println("Vous avez dépensé plus que prévu !");
        }
        else System.out.println("Vous n'avez pas encore atteint la limite de votre budget de ce mois =)");
    }

    public ArrayList<Depense> topCategories(){
        ArrayList<Depense> mesDepenses = new ArrayList<>();
        mesDepenses.addAll(depenses);

        ArrayList<Categories> categorie1 = mesDepenses.stream()
                .filter(depense -> depense.getCategorie() == Categories.divertissements)
                .reduce(0,  )


    }

    @Override
    public String toString() {
        return "ProfilUtilisateur{" +
                "nom='" + nom + '\'' +
                ", budgetMensuel=" + budgetMensuel +
                ", depenses=" + depenses +
                '}';
    }
}
