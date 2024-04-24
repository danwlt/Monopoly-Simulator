package Model;

import Model.Fields.Jail_Field;

import java.util.Arrays;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class DiceService {
    private static final Logger logger = Logger.getLogger(DiceService.class.getName());
    private static final Random random = new Random();

    private static final Map<Player, Integer> back2backDoublets = Arrays.stream(GameHost.getPlayers())
            .collect(Collectors.toMap(player -> player, player -> 0));
    private static int diceValue;

    private static boolean isDoublets;

    public static void roll(){
        int dice1 = rollDice();
        int dice2 = rollDice();
        checkDoublets(dice1 == dice2);
        diceValue = dice1 + dice2;
        logger.log(Level.INFO, String.format("Result Dice: %s", diceValue));
    }

    public static void ignoreDoublet(){
        isDoublets = false;
    }

    public static boolean isDoublets() {
        logger.log(Level.INFO, String.format("Doublets: %s", isDoublets));
        return isDoublets;
    }

    private static void checkDoublets(boolean doublets){
        isDoublets = doublets;
        int amountDoublets = back2backDoublets.get(GameHost.getCurrentPlayer());
        if(doublets && amountDoublets < 2){
            back2backDoublets.put(GameHost.getCurrentPlayer(), amountDoublets + 1);
        } else if (doublets && amountDoublets == 2) {
            GameHost.getCurrentPlayer().setInJail(true);
            Jail_Field.getInstance().goToField(false);
            logger.log(Level.INFO, String.format("%s went to prison for three doublets in a row", GameHost.getCurrentPlayer()));
        }
        else{
            back2backDoublets.put(GameHost.getCurrentPlayer(), 0);
            isDoublets = false;
        }

    }
    public static int getDicesValue(){
        return diceValue;
    }

    private static int rollDice(){
        return random.nextInt(6) + 1;
    }

}
