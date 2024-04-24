package Model.Fields.ChanceFields.ChanceCards;

import Model.Bank;
import Model.Fields.Properties.Property_Field;
import Model.GameHost;
import Model.PropertyManager;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class RepairProperty extends ChanceCard{
    private static final RepairProperty instance = new RepairProperty();
    private RepairProperty(){
        super("Make general repairs on all your property: For each house pay 25$, For each hotel pay 100$");
    }

    @Override
    void executeCard(){
        final AtomicInteger repairCost = new AtomicInteger(0);
        List<Property_Field> propertyFields = PropertyManager
                .getPropertiesOfPlayer(GameHost.getCurrentPlayer(), property -> property instanceof Property_Field
                        && (((Property_Field) property).getAmountHouses() > 0))
                .stream()
                .map(property -> (Property_Field) property)
                .toList();

        propertyFields.forEach(propertyField -> {
            if (propertyField.getAmountHouses() == 5){
                repairCost.addAndGet(100);
            }
            else{
                repairCost.addAndGet(25 * propertyField.getAmountHouses());
            }
        });
        Bank.subtractCurrentPlayerMoney(repairCost.get());
    }

    public static RepairProperty getInstance() {
        return instance;
    }
}
