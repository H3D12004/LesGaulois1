package personnages;

import java.util.Random;

public class Druide {
    private String nom;
    private int effetPotionMin;
    private int effetPotionMax;

    public Druide(String nom, int effetPotionMin, int effetPotionMax) {
        this.nom = nom;
        this.effetPotionMin = effetPotionMin;
        this.effetPotionMax = effetPotionMax;
        parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin + " à " + effetPotionMax + ".");
    }

    public String getNom() {
        return nom;
    }

    public void parler(String texte) {
        System.out.println(prendreParole() + "« " + texte + " »");
    }

    private String prendreParole() {
        return "Le druide " + nom + " : ";
    }

    public int preparerPotion() {
        Random random = new Random();
        int forcePotion = effetPotionMin + random.nextInt(effetPotionMax - effetPotionMin + 1);
        parler("Je vais aller préparer une petite potion...");
        parler("Je n'ai pas trouvé tous les ingrédients, ma potion est seulement de force " + forcePotion + ".");
        return forcePotion;
    }

    public void booster(Gaulois gaulois) {
        if ("Obélix".equals(gaulois.getNom())) {
            parler("Non, Obélix !... Tu n'auras pas de potion magique !");
        } else {
            gaulois.boirePotion(preparerPotion());
        }
    }
}