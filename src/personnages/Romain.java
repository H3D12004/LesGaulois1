package personnages;

public class Romain {
    private String nom;
    private int force;
    private Equipement[] equipements = new Equipement[2];
    private int nbEquipements = 0;

    public Romain(String nom, int force) {
        this.nom = nom;
        assert force > 0 : "La force d'un Romain doit être positive";
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
        assert force > 0 : "Précondition violée: la force d'un Romain doit être positive avant de recevoir un coup";

        int initialForce = force;
        force -= forceCoup;

        if (force > 0) {
            parler("Aïe");
        } else {
            parler("J'abandonne...");
            force = 0;
        }

        assert force < initialForce : "Postcondition violée: la force d'un Romain doit diminuer après avoir reçu un coup";
    }

    public void sEquiper(Equipement equipement) {
        switch (nbEquipements) {
            case 0:
            case 1:
                if (nbEquipements == 1 && equipements[0] == equipement) {
                    afficherMessage("possède déjà un", equipement.toString());
                } else {
                    equipements[nbEquipements++] = equipement;
                    afficherMessage("s'équipe avec un", equipement.toString());
                }
                break;
            case 2:
                afficherMessage("est déjà bien protégé !", "");
                break;
        }
    }

    private void afficherMessage(String action, String equipement) {
        System.out.println("Le soldat " + nom + " " + action + (equipement.isEmpty() ? "" : " " + equipement) + ".");
    }

    @Override
    public String toString() {
        return "Romain [nom = " + nom + ", force = " + force + "]";
    }

    public static void main(String[] args) {
        Romain caesar = new Romain("César", 10);
        System.out.println(caesar);

        caesar.parler("Ave César");

        caesar.recevoirCoup(3);
        System.out.println(caesar);

        caesar.recevoirCoup(8);
        System.out.println(caesar);

        Romain minus = new Romain("Minus", 6);
        System.out.println(minus);

        System.out.println(Equipement.CASQUE);
        System.out.println(Equipement.BOUCLIER);

        minus.sEquiper(Equipement.CASQUE); // Le soldat Minus s'équipe avec un casque.
        minus.sEquiper(Equipement.CASQUE); // Le soldat Minus possède déjà un casque.
        minus.sEquiper(Equipement.BOUCLIER); // Le soldat Minus s'équipe avec un bouclier.
        minus.sEquiper(Equipement.CASQUE); // Le soldat Minus est déjà bien protégé !
    }
}
