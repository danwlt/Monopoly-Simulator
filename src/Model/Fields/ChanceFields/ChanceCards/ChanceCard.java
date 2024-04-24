package Model.Fields.ChanceFields.ChanceCards;

import Model.GameHost;
import Model.PropertyManager;

public abstract class ChanceCard {
    final protected String text;
    protected ChanceCard(String text) {
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
