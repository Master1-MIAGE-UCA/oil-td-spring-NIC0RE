package miage.dice;

import miage.dice.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DiceController {

    @Autowired
    private DiceRollLogService diceRollLogService;

    @GetMapping("/rollDice")
    public List<Integer> rollSingleDice() {
        return diceRollLogService.rollDice(1);
    }

    @GetMapping("/rollDice/{count}")
    public List<Integer> rollMultipleDices(@PathVariable int count) {
        return diceRollLogService.rollDice(count);
    }

    @GetMapping("/diceLogs")
    public List<DiceRollLog> getDiceRollLogs() {
        return diceRollLogService.getAllLogs();
    }
}

