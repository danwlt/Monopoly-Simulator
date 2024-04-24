package Model.Fields.Properties;

public class Hauptstraße extends Property_Field{
    private final static Hauptstraße instance = new Hauptstraße();

    private Hauptstraße(){
        super("Hauptstraße", 32, PropertyColorType.GREEN, 300,
                new int[]{26, 130, 390, 900, 1100, 1275}, 200);
    }

    public static Hauptstraße getInstance() {
        return instance;
    }

}
