public class Plateau {
    private Case[][] plateau = new Case[9][9];
    final int TAILLE = 9;

    public Plateau() {
        for (int i = 0; i < TAILLE; ++i) {
            for (int j = 0; j < TAILLE; ++j) {
                this.plateau[i][j] = new Case(' ');
            }
        }
    }

    public Case get_case(int x, int y) {
        return this.plateau[x][y];
    }

    public boolean peut_placer_premier(int x, int y) {
        if (x == 0 && y == 0) {
            if(this.get_case(x, y + 1).get_nom_case() == 'B' || this.get_case(x + 1, y).get_nom_case() == 'B')
                return true;
            else
                return false;
        } else if (x == 0 && y == TAILLE - 1) {
            if(this.get_case(x, y - 1).get_nom_case() == 'B' || this.get_case(x + 1, y).get_nom_case() == 'B')
                return true;
            else
                return false;
        } else if (x == TAILLE - 1 && y == 0) {
            if(this.get_case(x - 1, y).get_nom_case() == 'B' || this.get_case(x, y + 1).get_nom_case() == 'B')
                return true;
            else
                return false;
        } else if (x == TAILLE-1 && y == TAILLE-1) {
            if(this.get_case(x - 1, y).get_nom_case() == 'B' || this.get_case(x, y-1).get_nom_case() == 'B')
                return true;
            else
                return false;
        }
        else if(x == 0){
            if(this.get_case(x,y-1).get_nom_case() == 'B' ||this.get_case(x,y+1).get_nom_case() == 'B' || this.get_case(x+1,y).get_nom_case() == 'B')
                return true;
            else
                return false;
        }
        else if(y == 0){
            if(this.get_case(x-1,y).get_nom_case() == 'B' || this.get_case(x+1,y).get_nom_case() == 'B' || this.get_case(x,y+1).get_nom_case() == 'B')
                return true;
            else
                return false;
        }
        else if(x == TAILLE-1){
            if(this.get_case(x,y-1).get_nom_case() == 'B' || this.get_case(x,y+1).get_nom_case() == 'B' || this.get_case(x-1,y).get_nom_case() == 'B')
                return true;
            else
                return false;
        }
        else if(y == TAILLE-1){
            if(this.get_case(x-1,y).get_nom_case() == 'B' || this.get_case(x+1,y).get_nom_case() == 'B' || this.get_case(x,y-1).get_nom_case() == 'B')
                return true;
            else
                return false;
        }
        else
        if(this.get_case(x,y-1).get_nom_case() == 'B' || this.get_case(x+1,y).get_nom_case() == 'B' || this.get_case(x,y+1).get_nom_case() == 'B' ||this.get_case(x-1,y).get_nom_case() == 'B')
            return true;
        else
            return false;

    }

    public boolean peut_placer_deuxième(int x, int y,boolean direction) {
        if(direction){
            if(x == 0){
                if(this.get_case(x+1,y).get_nom_case() == 'B')
                    return true;
                else
                    return false;
            }
            else if(x == TAILLE-1){
                if(this.get_case(x-1,y).get_nom_case() == 'B')
                    return true;
                else
                    return false;
            }
            else{
                if(this.get_case(x+1,y).get_nom_case() == 'B' || this.get_case(x-1,y).get_nom_case() == 'B')
                    return true;
                else
                    return false;
            }
        }
        else{
            if(y == 0){
                if(this.get_case(x,y+1).get_nom_case() == 'B')
                    return true;
                else
                    return false;
            }
            else if(y == TAILLE-1){
                if(this.get_case(x,y-1).get_nom_case() == 'B')
                    return true;
                else
                    return false;
            }
            else{
                if(this.get_case(x,y-1).get_nom_case() == 'B' || this.get_case(x,y+1).get_nom_case() == 'B')
                    return true;
                else
                    return false;
            }
        }
    }

    public boolean trouve_direction(int x, int y,int numero_j){
        if(y == TAILLE-1){
            if(this.get_case(x,y-1).get_nom_case() == 'B' && this.get_case(x,y-1).get_bateau_case().get_numero() == numero_j)
                return false;
            else
                return true;
        }
        if (y == 0){
            if(this.get_case(x,y+1).get_nom_case() == 'B' && this.get_case(x,y+1).get_bateau_case().get_numero() == numero_j)
                return false;
            else
                return true;
        }
        if((this.get_case(x,y+1).get_nom_case() == 'B' && this.get_case(x,y+1).get_bateau_case().get_numero() == numero_j) || (this.get_case(x,y-1).get_nom_case() == 'B' && this.get_case(x,y-1).get_bateau_case().get_numero() == numero_j))
            return false;
        else
            return true;
    }

    public boolean compte_place(int taille,int x, int y){
        boolean ok = true;
        if (x == 0 && y == 0) {
            for(int i = 1; i < taille; ++i){
                if(this.get_case(x+i,y).get_nom_case() != ' '){
                    ok = false;
                }
            }
            if(ok)
                return true;
            ok = true;
            for(int i = 1; i < taille; ++i){
                if(this.get_case(x,y+i).get_nom_case() != ' '){
                    ok = false;
                }
            }
            return ok;
        }
        else if(x == 0 && y == TAILLE-1){
            for(int i = 1; i < taille; ++i){
                if(this.get_case(x+i,y).get_nom_case() != ' '){
                    ok = false;
                }
            }
            if(ok)
                return true;
            ok = true;
            for(int i = 1; i < taille; ++i){
                if(this.get_case(x,y-i).get_nom_case() != ' '){
                    ok = false;
                }
            }
            return ok;
        }
        else if(x == TAILLE-1 && y == 0){
            for(int i = 1; i < taille; ++i){
                if(this.get_case(x-i,y).get_nom_case() != ' '){
                    ok = false;
                }
            }
            if(ok)
                return true;
            ok = true;
            for(int i = 1; i < taille; ++i){
                if(this.get_case(x,y+i).get_nom_case() != ' '){
                    ok = false;
                }
            }
            return ok;
        }
        else if(x == TAILLE-1 && y == TAILLE-1){
            for(int i = 1; i < taille; ++i){
                if(this.get_case(x,y-i).get_nom_case() != ' '){
                    ok = false;
                }
            }
            if(ok)
                return true;
            ok = true;
            for(int i = 1; i < taille; ++i){
                if(this.get_case(x-i,y).get_nom_case() != ' '){
                    ok = false;
                }
            }
            return ok;
        }
        else if(x == 0){
            if(y - taille >= 0){
                ok = true;
                for(int i = 1; i < taille; ++i){
                    if(this.get_case(x,y-i).get_nom_case() != ' '){
                        ok = false;
                    }
                }
                if(ok)
                    return true;
            }
            if(y + taille < TAILLE){
                ok = true;
                for(int i = 1; i < taille; ++i){
                    if(this.get_case(x,y+i).get_nom_case() != ' '){
                        ok = false;
                    }
                }
                if(ok)
                    return true;
            }
            ok = true;
            for(int i = 1; i < taille; ++i){
                if(this.get_case(x+i,y).get_nom_case() != ' '){
                    ok = false;
                }
            }
            return ok;
        }
        else if(y == 0){
            if(x - taille >= 0){
                ok = true;
                for(int i = 1; i < taille; ++i){
                    if(this.get_case(x-i,y).get_nom_case() != ' '){
                        ok = false;
                    }
                }
                if(ok)
                    return true;
            }
            if(x + taille < TAILLE){
                ok = true;
                for(int i = 1; i < taille; ++i){
                    if(this.get_case(x+i,y).get_nom_case() != ' '){
                        ok = false;
                    }
                }
                if(ok)
                    return true;
            }
            ok = true;
            for(int i = 1; i < taille; ++i){
                if(this.get_case(x,y+i).get_nom_case() != ' '){
                    ok = false;
                }
            }
            return ok;
        }
        else if(x == TAILLE-1){
            if(y - taille >= 0){
                ok = true;
                for(int i = 1; i < taille; ++i){
                    if(this.get_case(x,y-i).get_nom_case() != ' '){
                        ok = false;
                    }
                }
                if(ok)
                    return true;
            }
            if(y + taille < TAILLE){
                ok = true;
                for(int i = 1; i < taille; ++i){
                    if(this.get_case(x,y+i).get_nom_case() != ' '){
                        ok = false;
                    }
                }
                if(ok)
                    return true;
            }
            ok = true;
            for(int i = 1; i < taille; ++i){
                if(this.get_case(x-i,y).get_nom_case() != ' '){
                    ok = false;
                }
            }
            return ok;
        }
        else if(y == TAILLE-1){
            if(x - taille >= 0){
                ok = true;
                for(int i = 1; i < taille; ++i){
                    if(this.get_case(x-i,y).get_nom_case() != ' '){
                        ok = false;
                    }
                }
                if(ok)
                    return true;
            }
            if(x + taille < TAILLE){
                ok = true;
                for(int i = 1; i < taille; ++i){
                    if(this.get_case(x+i,y).get_nom_case() != ' '){
                        ok = false;
                    }
                }
                if(ok)
                    return true;
            }
            ok = true;
            for(int i = 1; i < taille; ++i){
                if(this.get_case(x,y-i).get_nom_case() != ' '){
                    ok = false;
                }
            }
            return ok;
        }
        else{
            if(y - taille >= 0){
                ok = true;
                for(int i = 1; i < taille; ++i){
                    if(this.get_case(x,y-i).get_nom_case() != ' '){
                        ok = false;
                    }
                }
                if(ok)
                    return true;
            }
            if(y + taille < TAILLE){
                ok = true;
                for(int i = 1; i < taille; ++i){
                    if(this.get_case(x,y+i).get_nom_case() != ' '){
                        ok = false;
                    }
                }
                if(ok)
                    return true;
            }
            if(x - taille >= 0){
                ok = true;
                for(int i = 1; i < taille; ++i){
                    if(this.get_case(x-i,y).get_nom_case() != ' '){
                        ok = false;
                    }
                }
                if(ok)
                    return true;
            }
            if(x + taille < TAILLE){
                ok = true;
                for(int i = 1; i < taille; ++i){
                    if(this.get_case(x+i,y).get_nom_case() != ' '){
                        ok = false;
                    }
                }
                if(ok)
                    return true;
            }
            return ok;
        }
    }
}