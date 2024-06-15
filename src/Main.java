import java.io.Console;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Jeu jeu = new Jeu();
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        while(!jeu.A_perdue(jeu.Tour())){
            System.out.println("Au joueur "+jeu.Tour().get_numero()+" de jouer, pressez Entrer quand vous être prêt");
            Scanner scan = new Scanner(System.in);
            scan.nextLine();
            System.out.println("Votre plateau :");
            System.out.println(jeu.Tour().affiche_plateau(jeu.Tour().get_plateau()));
            System.out.println("Le plateau adverse :\n\n");
            System.out.println(jeu.Tour().affiche_plateau(jeu.Tour().get_ennemie()));
            jeu.Tire(jeu.Tour(),jeu.Autre());
            jeu.Next();
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }
        System.out.println("Le joueur " + jeu.Autre().get_numero() + " a gagne");
    }
}