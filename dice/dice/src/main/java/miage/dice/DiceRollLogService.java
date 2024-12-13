package miage.dice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class DiceRollLogService {

    private final DiceRollLogRepository diceRollLogRepository;

    @Autowired
    public DiceRollLogService(DiceRollLogRepository diceRollLogRepository) {
        this.diceRollLogRepository = diceRollLogRepository;
    }

    public List<Integer> rollDice(int diceCount) {
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < diceCount; i++) {
            results.add((int) (Math.random() * 6) + 1); // Dé à 6 faces
        }

        // Créer une entrée de log
        DiceRollLog log = new DiceRollLog();
        log.setDiceCount(diceCount);
        log.setResults(results);
        log.setTimestamp(LocalDateTime.now());

        // Enregistrer le log dans la base de données
        diceRollLogRepository.save(log);

        return results;
    }

    public List<DiceRollLog> getAllLogs() {
        return diceRollLogRepository.findAll();
    }
}



