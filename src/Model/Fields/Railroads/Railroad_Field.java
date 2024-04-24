package Model.Fields.Railroads;

import Model.Fields.FieldType;
import Model.Fields.Properties.PropertyColorType;
import Model.Fields.TradeableField;

public class Railroad_Field extends TradeableField {
    private static int instanceCount = 0;
    public Railroad_Field(int position){
        super(FieldType.RAILROAD, PropertyColorType.BLACK, "Railroad", position, 200, new int[]{25, 50, 100, 200});
        if(instanceCount < 4){
            instanceCount ++;
        }
        else{
            throw new IllegalStateException("Max number of Railroad_Field instances reached");
        }
    }

    @Override
    protected int calculateRent() {
        return 0;
    }
}
