package miage.dice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class DiceRollLogService {

    private final Dice dice;
    private final DiceRollLogRepository diceRollLogRepository;

    @Autowired
    public DiceRollLogService(Dice dice, DiceRollLogRepository diceRollLogRepository) {
        this.dice = dice;
        this.diceRollLogRepository = diceRollLogRepository;
    }

    public List<Integer> rollDice(int diceCount) {
        List<Integer> results = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < diceCount; i++) {
            results.add(random.nextInt(6) + 1);
        }

        DiceRollLog log = new DiceRollLog();
        log.setDiceCount(diceCount);
        log.setResults(results);
        log.setTimestamp(LocalDateTime.now());
        diceRollLogRepository.save(log);

        return results;
    }

    /**
     * Lance le nombre spécifié de dés et enregistre le résultat dans la base.
     *
     * @param diceCount Nombre de dés à lancer.
     * @return Les résultats des lancers.
     */
    public DiceRollLog rollAndLogDice(int diceCount) {
        // Liste pour stocker les résultats des lancers
        List<Integer> results = new ArrayList<>();

        // Lancer les dés
        for (int i = 0; i < diceCount; i++) {
            results.add(dice.roll(6)); // Dé à 6 faces
        }

        // Créer une entrée de log
        DiceRollLog log = new DiceRollLog();
        log.setDiceCount(diceCount);
        log.setResults(results);
        log.setTimestamp(LocalDateTime.now());

        // Enregistrer le log dans la base de données
        return diceRollLogRepository.save(log);
    }
}


