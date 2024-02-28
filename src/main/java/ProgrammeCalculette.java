/**
 * Décrivez votre classe ProgrammePile ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class ProgrammeCalculette
{
    public static Pile creerPile(){
        Pile p = new Pile();
        return p;
    }

    public static boolean estVide(Pile pile){
        boolean vide = true;
        if (pile.indiceSommet > -1){
            vide = false;
        }
        return vide;
    }

    public static void depiler(Pile pile) throws Exception{
        if (pile.indiceSommet <= -1){
            throw new Exception("Impossible de dépiler");
        }
        else{
            pile.elements[pile.indiceSommet] = 0;
            pile.indiceSommet -= 1;
        }
    }

    public static void empiler(Pile pile, int entier) throws Exception{
        if (pile.indiceSommet >= 99){
            throw new Exception("Impossible d'empiler");
        }
        else{
            pile.elements[pile.indiceSommet + 1] = entier;
            pile.indiceSommet += 1;
        }
    }

    public static int sommet(Pile pile) throws Exception{
        int entier;
        if (estVide(pile) == true){
            throw new Exception("La pile est vide");
        }
        else{
            entier = pile.elements[pile.indiceSommet];
        }
        return entier;
    }

    public static String toString(Pile pfPile){
        String chaine = "";
        for (int i = 0; i <= pfPile.indiceSommet; i++){
            chaine += "|";
            chaine += pfPile.elements[pfPile.indiceSommet - i];
        }
        chaine += "|vide";
        return chaine;
    }

    public static int nbElements(Pile pfPile){
        return pfPile.indiceSommet + 1;
    }

    public static void main(String[] args){
        int tailleTab = 0;
        for (int i = 0; i < args.length; i++){
            if (args[i] != null){
                tailleTab += 1;
            }
        }

        System.out.println("Nombre de paramètres " + tailleTab);

        int résultat = 0;
        String chaine = "";
        Pile pile = new Pile(tailleTab);
        try{
            System.out.println("Aucune erreur détectée");
           for(int j = 0; j < tailleTab; j++){
            chaine = args[j];
            if (chaine.compareTo("1") == 0 || chaine.compareTo("2") == 0 || chaine.compareTo("3") == 0 || chaine.compareTo("4") == 0 || chaine.compareTo("5") == 0 || chaine.compareTo("6") == 0 || chaine.compareTo("7") == 0 || chaine.compareTo("8") == 0 || chaine.compareTo("9") == 0){
                empiler(pile, Integer.parseInt(chaine));
            }
            else if (chaine.compareTo("+") == 0){
                int élément2 = pile.elements[pile.indiceSommet];
                depiler(pile);
                int élément1 = pile.elements[pile.indiceSommet];
                depiler(pile);
                élément1 += élément2;
                empiler(pile, élément1);
            }
            else if (chaine.compareTo("-") == 0){
                int élément2 = pile.elements[pile.indiceSommet];
                depiler(pile);
                int élément1 = pile.elements[pile.indiceSommet];
                depiler(pile);
                élément1 -= élément2;
                empiler(pile, élément1);
            }
            else if (chaine.compareTo("*") == 0){
                int élément2 = pile.elements[pile.indiceSommet];
                depiler(pile);
                int élément1 = pile.elements[pile.indiceSommet];
                depiler(pile);
                élément1 = élément1 * élément2;
                empiler(pile, élément1);
            }
            else if (chaine.compareTo("/") == 0){
                int élément2 = pile.elements[pile.indiceSommet];
                depiler(pile);
                int élément1 = pile.elements[pile.indiceSommet];
                depiler(pile);
                élément1 = élément1 / élément2;
                empiler(pile, élément1);
            }
        } 
        résultat = pile.elements[pile.indiceSommet];
        System.out.println("Le résultat est " + résultat);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
