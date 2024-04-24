package Model.Fields;


public class FreeParking_Field extends Field {
    private static final FreeParking_Field instance = new FreeParking_Field();
    private FreeParking_Field(){
        super(FieldType.FREE_PARKING, "Free Parking", 20);
    }

    public static FreeParking_Field getInstance(){
        return instance;
    }

    @Override
    protected void executeAction() {

    }
}
