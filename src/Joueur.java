import com.sun.source.tree.BreakTree;

import java.lang.constant.Constable;
import java.util.Scanner;

public class Joueur {
    private int numero;
    private static int nb_joueur = 1;
    private int nb_bateau = 4;

    final char BATEAU = 'B';
    final char BATEAU_T = 'X';
    final char MER = ' ';
    final int MER_T = 'O';
    private Bateau[] liste_bateau = new Bateau[4];

    private Plateau plateau;
    private Plateau ennemie;

    public Joueur(){
        this.numero = nb_joueur;
        nb_joueur+=1;
        this.plateau = new Plateau();
        this.ennemie = new Plateau();
        int indice = 0;
        String co;
        this.liste_bateau[0] = new Bateau(4,this.numero);
        char num = '4';
        do{
            System.out.println(this.affiche_plateau(this.get_plateau()));
            Scanner scan = new Scanner(System.in);
            System.out.println("Il est temps de placer un bateau à 4 cases, veuillez indiquer les coordonnes de la case " + num +" (Lettre/chiffre attaché)");
            co = scan.nextLine();
            if(co.length() == 2 && (co.charAt(0) >= 'A' && co.charAt(0) <= 'I') && (co.charAt(1) >= '1' && co.charAt(1) <= '9')){
                int x = co.charAt(0)-65;
                int y = co.charAt(1)-49;
                if(indice == 0 && this.plateau.compte_place(4,x,y)){
                    this.plateau.get_case(x, y).set_bateau_case(this.liste_bateau[0]);
                    this.plateau.get_case(x,y).set_nom_case(BATEAU);
                    indice += 1;
                    num-=1;
                }
                else if(indice == 1){
                    if(this.plateau.peut_placer_premier(x,y)){
                        this.plateau.get_case(x, y).set_bateau_case(this.liste_bateau[0]);
                        this.plateau.get_case(x,y).set_nom_case(BATEAU);
                        this.plateau.get_case(x,y).get_bateau_case().set_direction(this.plateau.trouve_direction(x,y,this.numero));
                        indice += 1;
                        num-=1;
                    }
                }
                else{
                    if(this.plateau.peut_placer_deuxième(x,y,this.liste_bateau[0].get_direction())){
                        this.plateau.get_case(x, y).set_bateau_case(this.liste_bateau[0]);
                        this.plateau.get_case(x,y).set_nom_case(BATEAU);
                        indice += 1;
                        num-=1;
                    }
                }
            }
            else{
                System.out.println("Coordonnee non valide, veuillez appuyer sur Entrer pour reessayer");
                Scanner scan1 = new Scanner(System.in);
                scan1.nextLine();
            }
        }while(indice != 4);
        this.liste_bateau[1] = new Bateau(3,this.numero);
        this.liste_bateau[2] = new Bateau(3,this.numero);
        for(int i = 1; i < 3; ++i){
            indice = 0;
            co = "";
            num = '3';
            do {
                System.out.println(this.affiche_plateau(this.get_plateau()));
                Scanner scan = new Scanner(System.in);
                System.out.println("Il est temps de placer un bateau à 3 cases, veuillez indiquer les coordonnes de la case " + num + " (Lettre/chiffre attaché)");
                co = scan.nextLine();
                if (co.length() == 2 && co.charAt(0) >= 'A' && co.charAt(0) <= 'I' && co.charAt(1) >= '1' && co.charAt(1) <= '9') {
                    int x = co.charAt(0) - 65;
                    int y = co.charAt(1) - 49;
                    if (this.plateau.get_case(x, y).get_nom_case() == MER) {
                        if(indice == 0 && this.plateau.compte_place(3,x,y)){
                            this.plateau.get_case(x, y).set_bateau_case(this.liste_bateau[i]);
                            this.plateau.get_case(x,y).set_nom_case(BATEAU);
                            indice += 1;
                            num-=1;
                        }
                        else if(indice == 1){
                            if(this.plateau.peut_placer_premier(x,y)){
                                this.plateau.get_case(x, y).set_bateau_case(this.liste_bateau[i]);
                                this.plateau.get_case(x,y).set_nom_case(BATEAU);
                                this.plateau.get_case(x,y).get_bateau_case().set_direction(this.plateau.trouve_direction(x,y,this.numero));
                                indice += 1;
                                num-=1;
                            }
                        }
                        else{
                            if(this.plateau.peut_placer_deuxième(x,y,this.liste_bateau[i].get_direction())){
                                this.plateau.get_case(x, y).set_bateau_case(this.liste_bateau[i]);
                                this.plateau.get_case(x,y).set_nom_case(BATEAU);
                                indice += 1;
                                num-=1;
                            }
                        }
                    }
                    else{
                        System.out.println("Coordonnee non valide, veuillez appuyer sur Entrer pour reessayer");
                        Scanner scan1 = new Scanner(System.in);
                        scan1.nextLine();
                    }
                }
            }while(indice != 3);

        }
        this.liste_bateau[3] = new Bateau(2,this.numero);
        indice = 0;
        co = "";
        num = '2';
        do{
            System.out.println(this.affiche_plateau(this.get_plateau()));
            Scanner scan = new Scanner(System.in);
            System.out.println("Il est temps de placer un bateau à 2 cases, veuillez indiquer les coordonnes de la case " + num +" (Lettre/chiffre attaché)");
            co = scan.nextLine();
            if(co.length() == 2 && co.charAt(0) >= 'A' && co.charAt(0) <= 'I' && co.charAt(1) >= '1' && co.charAt(1) <= '9'){
                int x = co.charAt(0)-65;
                int y = co.charAt(1)-49;
                if (this.plateau.get_case(x, y).get_nom_case() == MER) {
                    if(indice == 0 && this.plateau.compte_place(2,x,y)){
                        this.plateau.get_case(x, y).set_bateau_case(this.liste_bateau[3]);
                        this.plateau.get_case(x,y).set_nom_case(BATEAU);
                        indice += 1;
                        num-=1;
                    }
                    else if(indice == 1){
                        if(this.plateau.peut_placer_premier(x,y)){
                            this.plateau.get_case(x, y).set_bateau_case(this.liste_bateau[3]);
                            this.plateau.get_case(x,y).set_nom_case(BATEAU);
                            this.plateau.get_case(x,y).get_bateau_case().set_direction(this.plateau.trouve_direction(x,y,this.numero));
                            indice += 1;
                            num-=1;
                        }
                    }
                }
                else{
                    System.out.println("Coordonnee non valide, veuillez appuyer sur Entrer pour reessayer");
                    Scanner scan1 = new Scanner(System.in);
                    scan1.nextLine();
                }
            }
        }while(indice != 2);
    }
    public Plateau get_ennemie(){
        return this.ennemie;
    }

    public int get_numero(){
        return this.numero;
    }

    public int getNb_bateau(){
        return this.nb_bateau;
    }

    public Bateau[] get_liste_bateau(){
        return this.liste_bateau;
    }

    public Plateau get_plateau(){
        return this.plateau;
    }

    public String affiche_plateau(Plateau plat){
        char ordonnee = 'A';
        String tab = "  1 2 3 4 5 6 7 8 9\n";
        tab += " ------------------\n";
        for(int i = 0; i < 9; i++){
            tab+=ordonnee+"|";
            ordonnee+=1;
            for(int j = 0 ; j < 9; j++)
            {
                tab+=plat.get_case(i,j).get_nom_case()+"|";
            }
            tab+="\n ------------------\n";
        }
        return tab;
    }
}
