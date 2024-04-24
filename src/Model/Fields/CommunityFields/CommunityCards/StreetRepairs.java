package Model.Fields.CommunityFields.CommunityCards;

import Model.Bank;
import Model.Fields.Properties.Property_Field;
import Model.GameHost;
import Model.PropertyManager;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class StreetRepairs extends CommunityCard{
    private final static StreetRepairs instance = new StreetRepairs();
    private StreetRepairs() {
        super("You are assessed for street repairs - pay 40$ per house and 115$ per hotel you own");
    }

    @Override
    void executeCard() {
        final AtomicInteger repairCost = new AtomicInteger(0);
        List<Property_Field> propertyFields = PropertyManager
                .getPropertiesOfPlayer(GameHost.getCurrentPlayer(), property -> property instanceof Property_Field
                        && (((Property_Field) property).getAmountHouses() > 0))
                .stream()
                .map(property -> (Property_Field) property)
                .toList();

        propertyFields.forEach(propertyField -> {
            if (propertyField.getAmountHouses() == 5){
                repairCost.addAndGet(115);
            }
            else{
                repairCost.addAndGet(40 * propertyField.getAmountHouses());
            }
        });
        Bank.subtractCurrentPlayerMoney(repairCost.get());

    }
    protected static StreetRepairs getInstance(){
        return instance;
    }
}
