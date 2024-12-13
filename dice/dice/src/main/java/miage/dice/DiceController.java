package miage.dice;

import miage.dice.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DiceController {

    @Autowired
    private DiceRollLogService DiceRollLogService;

    @GetMapping("/rollDice")
    public List<Integer> rollSingleDice() {
        return DiceRollLogService.rollDice(1);
    }

    @GetMapping("/rollDice/{count}")
    public List<Integer> rollMultipleDices(@PathVariable int count) {
        return DiceRollLogService.rollDice(count);
    }

    @GetMapping("/diceLogs")
    public List<DiceRollLog> getDiceRollLogs() {
        return (List<DiceRollLog>) DiceRollLogService.rollAndLogDice(1);
    }
}
