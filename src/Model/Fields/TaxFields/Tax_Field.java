package Model.Fields.TaxFields;

import Model.Bank;
import Model.Fields.Field;
import Model.Fields.FieldType;

public class Tax_Field extends Field {
    private static int instanceCount = 0;
    private final int taxAmount;
    public Tax_Field(int position, int taxAmount){
        super(FieldType.TAX,"Tax", position);
        this.taxAmount = taxAmount;
        if(instanceCount < 2){
            instanceCount ++;
        }
        else{
            throw new IllegalStateException("Max number of Tax_Field instances reached");
        }

    }

    @Override
    public void executeAction(){
        Bank.subtractCurrentPlayerMoney(taxAmount);
        addTotalCostOfVisiting(taxAmount);
    }

}
