package Model.Fields.CommunityFields.CommunityCards;

import Model.GameHost;
import Model.PropertyManager;

public abstract class CommunityCard {
    final protected String text;
    protected CommunityCard(String text) {
        this.text = text;
    }

    public String getText(){
        return text;
    }

    public void receivedBonus(int received){
        PropertyManager.getFieldAtPosition(GameHost.getCurrentPlayer().getPosition()).removeTotalCostOfVisiting(received);
    }

    public void payedAmount(int payed){
        PropertyManager.getFieldAtPosition(GameHost.getCurrentPlayer().getPosition()).addTotalCostOfVisiting(payed);
    }
    abstract void executeCard();


}
