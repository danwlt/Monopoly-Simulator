package Model.Fields.CommunityFields;

import Model.Fields.CommunityFields.CommunityCards.CommunityCard;
import Model.Fields.CommunityFields.CommunityCards.CommunityCardService;
import Model.Fields.Field;
import Model.Fields.FieldType;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CommunityChest_Field extends Field {

    private static final Logger logger = Logger.getLogger(CommunityChest_Field.class.getName());
    private static int instanceCount = 0;
    public CommunityChest_Field(int position) {
        super(FieldType.COMMUNITY_CHEST, "Community Chest", position);
        if(instanceCount < 3){
            instanceCount ++;
        }
        else{
            throw new IllegalStateException("Max number of CommunityChest_Field instances reached");
        }
    }

    @Override
    protected void executeAction() {
        CommunityCard drawnCard = CommunityCardService.getInstance().drawCommunityCard();
        logger.log(Level.INFO, drawnCard.getText());
    }
}