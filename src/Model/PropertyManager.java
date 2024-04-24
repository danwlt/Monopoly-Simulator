package Model;

import Model.Fields.ChanceFields.ChanceFields;
import Model.Fields.CommunityFields.CommunityFields;
import Model.Fields.*;
import Model.Fields.Properties.*;
import Model.Fields.Railroads.Hauptbahnhof;
import Model.Fields.Railroads.Nordbahnhof;
import Model.Fields.Railroads.Südbahnhof;
import Model.Fields.Railroads.Westbahnhof;
import Model.Fields.TaxFields.TaxFields;
import Model.Fields.UtilityFields.UtilityFields;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

// Singleton?

public class PropertyManager {
    private static final Logger logger = Logger.getLogger(PropertyManager.class.getName());
    private static int availableHouses = 32;

    private static int availableHotels = 12;

    private final static Field[] fields = new Field[]{
            Go_Field.getInstance(),
            Badstraße.getInstance(),
            CommunityFields.getChest1(),
            Turmstraße.getInstance(),
            TaxFields.getIncomeTax(),
            Südbahnhof.getInstance(),
            Chausseestraße.getInstance(),
            ChanceFields.getInstance1(),
            Elisenstraße.getInstance(),
            Poststraße.getInstance(),
            Jail_Field.getInstance(),
            Seestraße.getInstance(),
            UtilityFields.getElectricCompany(),
            Hafenstraße.getInstance(),
            NeueStraße.getInstance(),
            Westbahnhof.getInstance(),
            MünchenerStraße.getInstance(),
            CommunityFields.getChest2(),
            WienerStraße.getInstance(),
            BerlinerStraße.getInstance(),
            FreeParking_Field.getInstance(),
            Theaterstraße.getInstance(),
            ChanceFields.getInstance2(),
            Museumsstraße.getInstance(),
            Opernplatz.getInstance(),
            Nordbahnhof.getInstance(),
            Lessingstraße.getInstance(),
            Schillerstraße.getInstance(),
            UtilityFields.getWaterWorks(),
            Goethestraße.getInstance(),
            GoToJail_Field.getInstance(),
            Rathausplatz.getInstance(),
            Hauptstraße.getInstance(),
            CommunityFields.getChest3(),
            Bahnhofstraße.getInstance(),
            Hauptbahnhof.getInstance(),
            ChanceFields.getInstance3(),
            Parkstraße.getInstance(),
            TaxFields.getLuxuryTax(),
            Schlossallee.getInstance()
    };

    private static final List<TradeableField> properties = init();

    private PropertyManager(){
    }

    private static List<TradeableField> init(){
        List<TradeableField> properties = new ArrayList<TradeableField>(){};
        for (int i = 0; i < fields.length; i++) {
            if (fields[i] instanceof TradeableField){
                properties.add((TradeableField) fields[i]);
            }
        }
        return properties;
    }

    public static void boughtHouseOrHotelCount(int amountHouses){
        if (amountHouses == 4){
            changeAmountHouses(+4);
            changeAmountHotels(-1);
        } else if (amountHouses < 4) {
            changeAmountHouses(+1);
        }
    }

    public static void soldHouse(){
            changeAmountHouses(+1);
    }

    public static void soldHotel(){
        changeAmountHotels(+1);
    }

    private static void changeAmountHouses(int difference){
        availableHouses += difference;
    }

    private static void changeAmountHotels(int difference){
        availableHotels += difference;
    }

    public static int getAvailableHouses() {
        return availableHouses;
    }

    public static int getAvailableHotels() {
        return availableHotels;
    }

    public static int getAmountOfFields(){
        return fields.length;
    }

    // Filter every Property with the same ColorGroup and check if owned by the same person who owns the field
    public static boolean doesUserOwnGroup(TradeableField field){
        logger.log(Level.FINER, String.format("Checking if current Player %s does own every property of colorgroup %s", GameHost.getCurrentPlayer().getName(), field.getColorGroup()));
        boolean result = getColorGroup(field).stream().allMatch(entry -> entry.getOwner() != null && entry.getOwner().equals(field.getOwner()));
        logger.log(Level.INFO, String.format("%s owns colorgroup: %s", GameHost.getCurrentPlayer().getName(), result));
        return result;
    }

    // Every property in same color group needs same amount of houses in order to be able to build a new house
    public static boolean canUserBuyHouseOrHotel(Property_Field propertyField){
        logger.log(Level.FINER, String.format("Checking if current Player %s is allowed to buy a house on the property %s", GameHost.getCurrentPlayer().getName(), propertyField.getName()));
        if (doesUserOwnGroup(propertyField) && GameHost.getCurrentPlayer().getBalance() > propertyField.getHousePrice() && isHouseOrHotelAvailable(propertyField.getAmountHouses()) && !propertyField.isMortgage()){
            boolean result = getColorGroup(propertyField)
                    .stream()
                    .allMatch(field -> ((Property_Field) field).getAmountHouses() >= propertyField.getAmountHouses());
            logger.log(Level.INFO, String.format("Is %s allowed to buy house: %s", GameHost.getCurrentPlayer().getName(), result));
            return result;
        }
        else{
            return false;
        }
    }

    public static List<TradeableField> getColorGroup(TradeableField field) {
        logger.log(Level.FINER, String.format("Getting every tradable field from color group: %s", field.getColorGroup()));

        List<TradeableField> colorGroup = properties.stream()
                .filter(entry -> entry.getColorGroup().equals(field.getColorGroup()))
                .collect(Collectors.toList());

        logger.log(Level.INFO, String.format("Properties of colorgroup %s are %s", field.getColorGroup(), colorGroup));

        return colorGroup;
    }

    private static boolean isHouseOrHotelAvailable(int housesOnProperty){
        if(housesOnProperty <= 3 && getAvailableHouses() >= 1){
            return true;
        } else return housesOnProperty == 4 && getAvailableHotels() >= 1;
    }

    public static List<TradeableField> getPropertiesOfPlayer(Player player, Predicate<TradeableField> condition){
        return properties.stream()
                .filter(property ->  property.getOwner() != null && property.getOwner().equals(player) && condition.test(property))
                .sorted(Comparator.comparing(PropertyManager::doesUserOwnGroup)
                        .thenComparingInt(TradeableField::getPropertyPrice))
                .toList();
    }


    public static void changeOwnership(List<TradeableField> properties, Player newOwner){
        if (newOwner != null){
            properties.forEach(property -> {
                property.setOwner(newOwner);
            });
        }
        else{
            properties.forEach(property -> {
                property.setOwner(null);
                property.setMortgage(false);
            });
        }
    }

    public static Field getFieldAtPosition(int position){
        fields[position].visitedByPlayer();
        return fields[position];
    }

}
