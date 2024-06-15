import java.util.Scanner;

public class Jeu {
    private Joueur j1;
    private Joueur j2;

    private Joueur[] liste_joueur = new Joueur[2];

    public Jeu(){
        this.j1 = new Joueur();
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        this.j2 = new Joueur();
        this.liste_joueur[0] = this.j1;
        this.liste_joueur[1] = this.j2;
    }

    public Joueur Tour(){
        return this.liste_joueur[0];
    }

    public Joueur Autre(){
        return this.liste_joueur[1];
    }

    public void Next(){
        Joueur joueurtmp = this.liste_joueur[1];
        this.liste_joueur[1] = this.liste_joueur[0];
        this.liste_joueur[0] = joueurtmp;
    }

    public boolean A_perdue(Joueur j){
        boolean mort = true;
        for(int i = 0; i < j.getNb_bateau() && mort;++i){
            if(j.get_liste_bateau()[i].estenvie())
                mort = false;
        }
        return mort;
    }

    public void Tire(Joueur joueur1, Joueur joueur2){
        String co;
        Scanner scan = new Scanner(System.in);
        boolean ok = true;
        int x;
        int y;
        do {
            System.out.println("Saissez une coordonne : ");
            co = scan.nextLine();
            x = co.charAt(0)-65;
            y = co.charAt(1)-49;
            if(joueur2.get_plateau().get_case(x,y).get_nom_case() == 'X' || joueur2.get_plateau().get_case(x,y).get_nom_case() == 'O'){
                System.out.println("Vous avez déjà tiré ici, recommencez");
            }
            else
                ok = false;
        }while(ok);
        if(joueur2.get_plateau().get_case(x,y).get_nom_case() == ' '){
            joueur1.get_ennemie().get_case(x,y).set_nom_case('O');
            joueur2.get_plateau().get_case(x,y).set_nom_case('O');
            System.out.println("Vous n'avez rien touché, pressez Entrer pour continuer");
            Scanner scan1 = new Scanner(System.in);
            scan1.nextLine();
        }
        else{
            joueur2.get_plateau().get_case(x,y).get_bateau_case().toucher();
            joueur2.get_plateau().get_case(x,y).get_bateau_case().estdetruit();
            joueur2.get_plateau().get_case(x,y).set_nom_case('X');
            joueur1.get_ennemie().get_case(x,y).set_nom_case('X');
        }
    }

}
