package Model.Fields.CommunityFields.CommunityCards;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CommunityCardService {
    private static final Logger logger = Logger.getLogger(CommunityCardService.class.getName());
    private final static CommunityCardService instance = new CommunityCardService();

    private final static Random random = new Random();
    private final CommunityCard[] communityCards;



    private CommunityCardService(){
        this.communityCards = new CommunityCard[]{
                AdvanceToGo.getInstance(),
                BankError.getInstance(),
                BeautyContest.getInstance(),
                BirthdayGift.getInstance(),
                ConsultancyFee.getInstance(),
                DoctorFee.getInstance(),
                FreeOutJail.getInstance(),
                GoToJail.getInstance(),
                GrandOperaNight.getInstance(),
                HolidayFund.getInstance(),
                HospitalFee.getInstance(),
                InheritMoney.getInstance(),
                LifeInsurance.getInstance(),
                SchoolFee.getInstance(),
                StockSale.getInstance(),
                StreetRepairs.getInstance(),
                TaxRefund.getInstance()
        };
    }

    public void drawCommunityCard(){
        CommunityCard card = communityCards[random.nextInt(communityCards.length)];
        logger.log(Level.INFO, card.getText());
        card.executeCard();
    }

    public static CommunityCardService getInstance(){
        return instance;
    }
}
