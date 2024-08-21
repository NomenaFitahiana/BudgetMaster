import java.time.LocalDate;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2010, 8, 12);
        ProfilUtilisateur user1 = new ProfilUtilisateur("user1", 100.5);
        user1.ajoutDepense("ednkzjdn", 200.56, Categories.servicesPublics, date);
        user1.ajoutDepense("1223", 11.4, Categories.divertissements, LocalDate.of(2024, 8, 20));
        user1.ajoutDepense("jsdfjfls", 227.56, Categories.nourriture_restauration, LocalDate.now());

        //System.out.println(user1);

        //System.out.println(user1.affichageParCategorie(Categories.servicesPublics));

        //System.out.println(user1.afficherTousParDate());
        //System.out.println(user1);

        //System.out.println(user1.totalDepenseduMois());
        //System.out.println(user1.budgetRestant());
        System.out.println(user1);
        System.out.println(user1.topCategories());


    }
}