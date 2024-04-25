package Model;

import java.awt.*;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GameHost {
    private static final Logger logger = Logger.getLogger(GameHost.class.getName());
    private static final GameHost instance = new GameHost();
    private static boolean gameover = false;
    private static final Player[] players = new Player[]{new Player("Player 1", Color.RED), new Player("Player 2", Color.BLUE), new Player("Player 3", Color.YELLOW), new Player("Player 4", Color.GREEN)};

    private static Player currentPlayer = players[0];

    private GameHost() {
    }

    //ToDo check
    public void run() throws InterruptedException{
        while (!gameover) {
            for (Player player : players) {
                if (player.isBankrupt()) {
                    continue;
                }

                logger.log(Level.INFO, player.getName());
                currentPlayer = player;
                do {
                    if (player.isInJail()) {
                        JailService.tryReleasePlayer();
                    } else {
                        DiceService.roll();
                        player.addToPosition(DiceService.getDicesValue());
                    }

                } while (!player.isInJail() && !player.isBankrupt() && DiceService.isDoublets());
                player.investFunds();
                player.notifyObservers();
                Thread.sleep(500);
            }

            long count = Arrays.stream(players).filter(Player::isBankrupt)
                    .count();
            if (count >= players.length - 1) {
                gameover = true;
                break;
            }

        }
    }


    public static Player getCurrentPlayer() {
        return currentPlayer;
    }

    public static Player[] getPlayers(){
        return players;
    }

    public static GameHost getInstance() {
        return instance;
    }
}
