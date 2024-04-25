package Model.Fields.ChanceFields;

import Model.Fields.ChanceFields.ChanceCards.ChanceCardService;
import Model.Fields.Field;
import Model.Fields.FieldType;


public class Chance_Field extends Field {
    private static int instanceCount = 0;
    public Chance_Field(int position) {
        super(FieldType.CHANCE, "Chance", position);
        if(instanceCount < 3){
            instanceCount ++;
        }
        else{
            throw new IllegalStateException("Max number of Chance_Field instances reached");
        }
    }

    @Override
    protected void executeAction() {
        ChanceCardService.getInstance().drawChanceCard();
    }
}
