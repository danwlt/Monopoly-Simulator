package Model.Fields.Properties;

public class Poststraße extends Property_Field{
    private static final Poststraße instance = new Poststraße();
    private Poststraße() {
        super("Poststraße", 9, PropertyColorType.LIGHT_BLUE, 120, new int[]{8, 40, 100, 300, 450, 600}, 50);
    }

    public static Poststraße getInstance(){
        return instance;
    }
}
