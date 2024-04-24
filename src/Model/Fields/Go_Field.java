package Model.Fields;

public class Go_Field extends Field {
    private static final Go_Field instance = new Go_Field();

    private Go_Field() {
        super(FieldType.GO, "Los", 0);
    }

    public static Go_Field getInstance() {
        return instance;
    }

    @Override
    protected void executeAction() {
        //Do nothing, because advance to go needs to be handled different
    }
}
