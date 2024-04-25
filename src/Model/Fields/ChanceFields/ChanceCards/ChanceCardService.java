package Model.Fields.ChanceFields.ChanceCards;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChanceCardService {
    private static final Logger logger = Logger.getLogger(ChanceCardService.class.getName());
    private final static ChanceCardService instance = new ChanceCardService();

    private final static Random random = new Random();

    private final ChanceCard[] chanceCards;

    private ChanceCardService(){
        this.chanceCards = new ChanceCard[]{
                AdvanceToGo.getInstance(),
                AdvanceToOpernplatz.getInstance(),
                AdvanceToRailroad.getInstance(),
                AdvanceToSchlossallee.getInstance(),
                AdvanceToSeestraße.getInstance(),
                AdvanceToSüdbanhof.getInstance(),
                AdvanceToUtility.getInstance(),
                BuildingLoan.getInstance(),
                Chairman.getInstance(),
                DividendPayment.getInstance(),
                FreeOutJail.getInstance(),
                GoBackThree.getInstance(),
                GoToJail.getInstance(),
                PoorTax.getInstance(),
                RepairProperty.getInstance()
        };
    }

    public void drawChanceCard(){
        ChanceCard card = chanceCards[random.nextInt(chanceCards.length)];
        logger.log(Level.INFO, card.getText());
        card.executeCard();
    }

    public static ChanceCardService getInstance() {
        return instance;
    }

}
