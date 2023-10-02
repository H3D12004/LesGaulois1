package personnages;

public class Chef extends Gaulois {
    private Village village;

    public Chef(String nom, int force, Village village) {
        super(nom, force);
        this.village = village;
    }

    @Override
    public void parler(String texte) {
        System.out.println(prendreParole() + "« " + texte + " »");
    }

    private String prendreParole() {
        return "Le chef " + getNom() + " du village " + village.getNom() + " : ";
    }
}