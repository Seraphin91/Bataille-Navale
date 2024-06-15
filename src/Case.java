public class Case {
    private char Nom;
    private Bateau bateau;

    public Case(char nouv){
        this.Nom = nouv;
        this.bateau = null;
    }

    public void set_bateau_case(Bateau bateau){
        this.bateau = bateau;
    }

    public char get_nom_case(){
        return this.Nom;
    }
    public Bateau get_bateau_case(){
        return this.bateau;
    }

    public void set_nom_case(char nouv){
        this.Nom = nouv;
    }
}


