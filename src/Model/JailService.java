package Model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class JailService {

    private static Map<Player, Integer> roundsInPrison = new HashMap<>();
    private JailService(){
        roundsInPrison = Arrays.stream(GameHost.getPlayers())
                .collect(Collectors.toMap(player -> player, player -> 0));
    }

    public static void tryReleasePlayer(){
            if (GameHost.getCurrentPlayer().hasGetOutOfJailCard()){
                GameHost.getCurrentPlayer().setGetOutOfJailCard(false);
                GameHost.getCurrentPlayer().setInJail(false);
                DiceService.roll();
                GameHost.getCurrentPlayer().addToPosition(DiceService.getDicesValue());
                return;
            }
            for (int i = 0; i < 3; i++) {
                DiceService.roll();
                if(DiceService.isDoublets()){
                    DiceService.ignoreDoublet();
                    GameHost.getCurrentPlayer().setInJail(false);
                    GameHost.getCurrentPlayer().addToPosition(DiceService.getDicesValue());
                    return;
                }
            }
            if (GameHost.getCurrentPlayer().isInJail()) {
                roundsInPrison.merge(GameHost.getCurrentPlayer(), 1, Integer::sum);
            }
            if (roundsInPrison.get(GameHost.getCurrentPlayer()) > 2){
                Bank.subtractCurrentPlayerMoney(50);
                GameHost.getCurrentPlayer().setInJail(false);
                roundsInPrison.put(GameHost.getCurrentPlayer(), 0);
            }
    }
}
