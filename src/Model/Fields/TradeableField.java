package Model.Fields;

import Model.Bank;
import Model.Fields.Properties.PropertyColorType;
import Model.GameHost;
import Model.Player;

public abstract class TradeableField extends Field {
    private Player owner = null;

    private boolean isMortgage;

    final private int propertyPrice;

    final private PropertyColorType propertyColorType;
    final private int[] rent;

    public TradeableField(FieldType fieldType, PropertyColorType propertyColorType, String name, int position, int propertyPrice, int[] rent) {
        super(fieldType, name, position);
        this.isMortgage = false;
        this.propertyPrice = propertyPrice;
        this.propertyColorType = propertyColorType;
        this.rent = rent;
    }

    @Override
    public void executeAction(){
        if (!GameHost.getCurrentPlayer().equals(owner) && owner != null){
            addTotalCostOfVisiting(calculateRent());
            Bank.payRentToOwner(owner, calculateRent());
        }
    }

    public void buyProperty(){
        if(owner == null && GameHost.getCurrentPlayer().getBalance() > Math.ceil(propertyPrice * 1.5) ){
            Bank.subtractCurrentPlayerMoney(propertyPrice);
            owner = GameHost.getCurrentPlayer();
        }
    }
    protected abstract int calculateRent();

    public PropertyColorType getColorGroup(){
        return propertyColorType;
    }

    public int getPropertyPrice() {
        return propertyPrice;
    }

    public void setMortgage(boolean value) {
        isMortgage = value;
    }

    public void payOffMortgage(){
        if(owner != null && owner.equals(GameHost.getCurrentPlayer()) && GameHost.getCurrentPlayer().getBalance() > (propertyPrice/2) * 1.1){
            Bank.subtractCurrentPlayerMoney(propertyPrice);
            setMortgage(false);
        }
    }
    public boolean isMortgage() {
        return isMortgage;
    }
    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public Player getOwner() {
        return owner;
    }

    public int[] getRent() {
        return rent;
    }
}
