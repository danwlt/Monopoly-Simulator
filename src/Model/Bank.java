package Model;

import Model.Fields.Properties.Property_Field;
import Model.Fields.TradeableField;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private final static int passGoMoney = 200;
    private final static int starterMoney = 1500;
    private Bank(){}
    public static int getStarterMoney(){
        return starterMoney;
    }

    public static void playerAdvancedGo(){
        GameHost.getCurrentPlayer().addToBalance(passGoMoney);
    }

    public static void addCurrentPlayerMoney(int amount){
        GameHost.getCurrentPlayer().addToBalance(amount);
    }

    public static void subtractCurrentPlayerMoney(int amount, Player creditor){
        if(amount > GameHost.getCurrentPlayer().getBalance()){
            takeOutMortgage(amount - GameHost.getCurrentPlayer().getBalance(), creditor);

        }
        GameHost.getCurrentPlayer().subtractBalance(amount);
    }

    public static void subtractCurrentPlayerMoney(int amount){
        if(amount > GameHost.getCurrentPlayer().getBalance()){
            takeOutMortgage(amount - GameHost.getCurrentPlayer().getBalance(), null);

        }
        GameHost.getCurrentPlayer().subtractBalance(amount);
    }

    public static void subtractPlayerMoney(int amount, Player debtor, Player creditor){
        if(amount > debtor.getBalance()){
            takeOutMortgage(amount - debtor.getBalance(), creditor);

        }
        debtor.subtractBalance(amount);
    }

    public static void payRentToOwner(Player owner, int rent){
            subtractCurrentPlayerMoney(rent, owner);
            owner.addToBalance(rent);
    }

    private static void takeOutMortgage(int neededMoney, Player newOwner){
        //ToDo add Mortgage logic
        //ToDo optimize
        List<TradeableField> propertiesOfPlayer = PropertyManager.getPropertiesOfPlayer(GameHost.getCurrentPlayer(), property -> !property.isMortgage());

        /* Take out mortgage on fields with no houses and sorted by low visitors, then houses with lowest visitors
            If still not enough -> Take out mortgage on all fields (setMortgage to true), pay as much as possible, and give rest to owner and bankrupt
            If money is owed to bank, just bankrupt and remove ownership of all properties
            Depending on strategies it makes sense to get as close as possible to the owed amount of money,
            or sell least valuable properties first -> this approach tries to sell less valuable properties first
         */

        int totalMortgage = 0;
        List<TradeableField> propertiesForMortgage = new ArrayList<>();
        for (TradeableField tradeableField : propertiesOfPlayer) {

            if (totalMortgage + tradeableField.getPropertyPrice()/2 <= neededMoney) {
                // use instance of to check if houses can be sold
                if(!(tradeableField instanceof Property_Field)){
                    totalMortgage += tradeableField.getPropertyPrice()/2;
                    tradeableField.setMortgage(true);
                    propertiesForMortgage.add(tradeableField);
                }
                else{
                    // ToDo has to be overriden to adjust house selling to game rules
                    totalMortgage += (((Property_Field)tradeableField).getHousePrice() / 2) * ((Property_Field)tradeableField).getAmountHouses();
                    totalMortgage += tradeableField.getPropertyPrice()/2;
                    propertiesForMortgage.add(tradeableField);
                }

                if (totalMortgage == neededMoney) {
                    break;
                }
            } else {
                break;
            }
        }

        for (TradeableField tradableField: propertiesForMortgage) {
            tradableField.setMortgage(true);
            if(tradableField instanceof Property_Field){
                for (int i = 0; i < ((Property_Field) tradableField).getAmountHouses(); i++) {
                    ((Property_Field) tradableField).sellHouse();
                }
            }
        }

        GameHost.getCurrentPlayer().addToBalance(totalMortgage);

        if(neededMoney > totalMortgage){
            PropertyManager.changeOwnership(PropertyManager.getPropertiesOfPlayer(GameHost.getCurrentPlayer(), property -> true), newOwner);
            Bank.subtractCurrentPlayerMoney(GameHost.getCurrentPlayer().getBalance(), newOwner);
            GameHost.getCurrentPlayer().setBankrupt();
        }

    }
}
