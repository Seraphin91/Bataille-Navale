import java.io.Console;
import java.util.Scanner;

public class Bateau {
    private int numero;
    private int taille_bateau;
    private int PV;
    private boolean vie;
    private boolean direction;//true = horizontale,false verticale

    public Bateau(int taille,int num_joueur){
        this.taille_bateau = taille;
        this.PV = taille;
        this.vie = true;
        this.numero = num_joueur;
    }

    public void set_direction(boolean nouv_direction){
        this.direction = nouv_direction;
    }

    public int get_numero(){
        return this.numero;
    }

    public boolean get_direction(){
        return this.direction;
    }

    public boolean estenvie(){
        return this.vie;
    }

    public void estdetruit(){
        if(PV == 0) {
            this.vie = false;
            System.out.println("Vous avez détruit un bateau, pressez Entrer pour continuer");
            Scanner scan = new Scanner(System.in);
            scan.nextLine();
        }
    }

    public void toucher(){
        this.PV-=1;
        System.out.println("Vous avez touché un bateau, pressez Entrer pour continuer");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
    }
}
