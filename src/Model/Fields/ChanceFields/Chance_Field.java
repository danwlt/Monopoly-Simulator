package Model.Fields.ChanceFields;

import Model.Fields.ChanceFields.ChanceCards.ChanceCard;
import Model.Fields.ChanceFields.ChanceCards.ChanceCardService;
import Model.Fields.Field;
import Model.Fields.FieldType;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Chance_Field extends Field {
    private static final Logger logger = Logger.getLogger(Chance_Field.class.getName());
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
        ChanceCard drawnCard = ChanceCardService.getInstance().drawChanceCard();
        logger.log(Level.INFO, drawnCard.getText());
    }
}
