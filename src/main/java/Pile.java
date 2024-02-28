
/**
 * Décrivez votre classe Pile ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile
{
    /**
     * Constructeur d'objets de classe Pile
     */
    int[] elements;
    int indiceSommet;
    
    /**
     * Construsteur d'une pile avec aucun paramètres
     */
    public Pile()
    {
        this.elements = new int[100];
        this.indiceSommet = -1;
    }

    /**
     * Construsteur d'une pile avec en paramètre sa taille
     */
    public Pile(int pfTaille)
    {
        this.elements = new int[pfTaille];
        this.indiceSommet = -1;
    }
}
