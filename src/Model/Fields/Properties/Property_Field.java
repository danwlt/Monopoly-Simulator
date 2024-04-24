package Model.Fields.Properties;

import Model.Bank;
import Model.Fields.FieldType;
import Model.Fields.TradeableField;
import Model.GameHost;
import Model.PropertyManager;

public abstract class Property_Field extends TradeableField {
    private int amountHouses;

    private final int housePrice;
    Property_Field(String name, int position, PropertyColorType colorGroup, int propertyPrice, int[] rent, int housePrice){
        super(FieldType.PROPERTY, colorGroup, name, position, propertyPrice, rent);
        this.amountHouses = 0;
        this.housePrice = housePrice;
    }

    public int getAmountHouses() {
        return amountHouses;
    }

    public void buyHouse() {
        if(amountHouses < 5 && PropertyManager.canUserBuyHouseOrHotel(this)){
        Bank.subtractCurrentPlayerMoney(housePrice);
        PropertyManager.boughtHouseOrHotelCount(amountHouses);
        amountHouses++;
        notifyObservers();
        }
    }

    public void sellHouse() {
        if(amountHouses > 0 && amountHouses < 5){
            GameHost.getCurrentPlayer().addToBalance(housePrice/2);
            PropertyManager.soldHouse();
            amountHouses--;
        } else if (amountHouses == 5) {
            GameHost.getCurrentPlayer().addToBalance(5 * (housePrice/2));
            PropertyManager.soldHotel();
            amountHouses = 0;
        }
    }


    public int getHousePrice() {
        return housePrice;
    }

    @Override
    public int calculateRent(){
        return (super.isMortgage()) ? 0 : super.getRent()[amountHouses];
    }

}
