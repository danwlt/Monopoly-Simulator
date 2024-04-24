package Model.Fields.ChanceFields.ChanceCards;

import Model.Fields.Railroads.Südbahnhof;
import Model.Fields.TradeableField;
import Model.GameHost;
import Model.PropertyManager;

import java.util.List;

public class AdvanceToRailroad extends ChanceCard{
    private final static AdvanceToRailroad instance = new AdvanceToRailroad();

    private AdvanceToRailroad(){
        super("Advance to the nearest Railroad");

    }

    @Override
    void executeCard() {
        int playerPosition = GameHost.getCurrentPlayer().getPosition();
        List<TradeableField> railroads = PropertyManager.getColorGroup(Südbahnhof.getInstance());

        int nearestRailroadPosition = Integer.MAX_VALUE;
        TradeableField nearestRailroad = null;
        for (TradeableField railroad: railroads) {
            int distanceToRailroad = Math.abs(playerPosition - railroad.getPosition());
            if (distanceToRailroad < nearestRailroadPosition) {
                nearestRailroadPosition = distanceToRailroad;
                nearestRailroad = railroad;
            }
        }

        assert nearestRailroad != null;
        nearestRailroad.goToField();
    }

    public static AdvanceToRailroad getInstance() {
        return instance;
    }

}
