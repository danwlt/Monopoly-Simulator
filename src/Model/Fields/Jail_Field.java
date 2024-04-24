package Model.Fields;

public class Jail_Field extends Field{
    private static final Jail_Field instance = new Jail_Field();
    private Jail_Field() {
        super(FieldType.JAIL, "Jail", 10);
    }

    public static Jail_Field getInstance() {
        return instance;
    }

    @Override
    protected void executeAction() {

    }
}
