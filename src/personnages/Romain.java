package personnages;

public class Romain {
    private String nom;
    private int force;

    public Romain(String nom, int force) {
        this.nom = nom;
        this.force = force;
    }

    public String getNom() {
        return nom;
    }

    public void parler(String texte) {
        System.out.println(prendreParole() + "« " + texte + " »");
    }

    private String prendreParole() {
        return "Le romain " + nom + " : ";
    }

    public void recevoirCoup(int forceCoup) {
        force -= forceCoup;
        if (force > 0) {
            parler("Aïe");
        } else {
            parler("J'abandonne...");
        }
    }
    
    @Override
    public String toString() {
    	return "Romain [nom = " + nom + ", force = " + force + "]";
    }
    
    public static void main(String[] args) {
        Romain caesar = new Romain("César", 10);
        System.out.println(caesar);

        // Tester la méthode parler (qui utilise prendreParole en interne)
        caesar.parler("Ave César");

        // Tester la méthode recevoirCoup
        caesar.recevoirCoup(3); // César devrait dire "Aïe" et sa force devrait être réduite
        System.out.println(caesar); // Afficher l'état de César après avoir reçu le coup

        caesar.recevoirCoup(8); // César devrait dire "J'abandonne..." car sa force sera négative ou zéro
        System.out.println(caesar); // Afficher l'état de César après avoir reçu le deuxième coup
    }
}