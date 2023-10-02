package histoire;

import personnages.Druide;
import personnages.Gaulois;
import personnages.Romain;

public class Scenario {
    public static void main(String[] args) {
        Druide panoramix = new Druide("Panoramix", 5, 10);
        Gaulois asterix = new Gaulois("Astérix", 8);
        Gaulois obelix = new Gaulois("Obélix", 25);
        Romain minus = new Romain("Minus", 6);

        panoramix.booster(asterix);
        panoramix.booster(obelix);

        obelix.parler("Par Bélénos, ce n'est pas juste !");
        asterix.parler("Bonjour");
        minus.parler("UN GAU... UN GAUGAU...");

        asterix.frapper(minus);
    }
}
