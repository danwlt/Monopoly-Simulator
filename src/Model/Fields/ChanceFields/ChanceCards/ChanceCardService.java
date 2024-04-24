package Model.Fields.ChanceFields.ChanceCards;

import java.util.Random;

public class ChanceCardService {
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

    public ChanceCard drawChanceCard(){
        ChanceCard card = chanceCards[random.nextInt(chanceCards.length)];
        card.executeCard();
        return card;
    }

    public static ChanceCardService getInstance() {
        return instance;
    }

}
