package Model.Fields.ChanceFields.ChanceCards;

import Model.Fields.UtilityFields.UtilityFields;
import Model.GameHost;

public class AdvanceToUtility extends ChanceCard{
    private final static AdvanceToUtility instance = new AdvanceToUtility();
    private AdvanceToUtility(){
        super("Advance to the nearest Utility");

    }

    @Override
    void executeCard() {
        int playerPosition = GameHost.getCurrentPlayer().getPosition();
        int waterWorksPosition = UtilityFields.getWaterWorks().getPosition();
        int electricCompanyPosition = UtilityFields.getElectricCompany().getPosition();

        int distanceToWaterWorks = Math.abs(playerPosition - waterWorksPosition);
        int distanceToElectricCompany = Math.abs(playerPosition - electricCompanyPosition);


        if (distanceToElectricCompany < distanceToWaterWorks){
            UtilityFields.getElectricCompany().goToField();
        }
    }

    public static AdvanceToUtility getInstance(){
        return instance;
    }
}
