package Model.Fields.UtilityFields;

import Model.DiceService;
import Model.Fields.FieldType;
import Model.Fields.Properties.PropertyColorType;
import Model.Fields.TradeableField;
import Model.PropertyManager;


public class Utility_Field extends TradeableField {
    private static int instanceCount = 0;
    public Utility_Field(String name, int position){
        super(FieldType.UTILITY, PropertyColorType.WHITE, name, position, 150, new int[]{4, 10});
        if(instanceCount < 2){
            instanceCount ++;
        }
        else{
            throw new IllegalStateException("Max number of Utility_Field instances reached");
        }
    }

    @Override
    public int calculateRent() {
        return DiceService.getDicesValue() * ((PropertyManager.doesUserOwnGroup(UtilityFields.getElectricCompany())) ? getRent()[0]: getRent()[1]);
    }
}
