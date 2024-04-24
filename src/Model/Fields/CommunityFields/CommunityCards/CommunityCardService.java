package Model.Fields.CommunityFields.CommunityCards;

import java.util.Random;

public class CommunityCardService {
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

    public CommunityCard drawCommunityCard(){
        CommunityCard card = communityCards[random.nextInt(communityCards.length)];
        card.executeCard();
        return card;
    }

    public static CommunityCardService getInstance(){
        return instance;
    }
}
