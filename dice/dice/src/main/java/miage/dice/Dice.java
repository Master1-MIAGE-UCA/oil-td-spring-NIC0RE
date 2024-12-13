package miage.dice;

import org.springframework.stereotype.Component;
import java.util.Random;

@Component
public class Dice {

    private final Random random;

    public Dice() {
        this.random = new Random();
    }

    /**
     * Effectue un lancé de dé et retourne un résultat compris entre 1 et le nombre de faces.
     * @param numberOfSides le nombre de faces du dé.
     * @return un entier aléatoire entre 1 et numberOfSides.
     * @throws IllegalArgumentException si le nombre de faces est inférieur à 1.
     */
    public int roll(int numberOfSides) {
        if (numberOfSides < 1) {
            throw new IllegalArgumentException("Le nombre de faces doit être supérieur ou égal à 1.");
        }
        return random.nextInt(numberOfSides) + 1;
    }
}
