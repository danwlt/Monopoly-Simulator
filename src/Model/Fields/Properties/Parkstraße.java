package Model.Fields.Properties;

public class Parkstraße extends Property_Field{
    private final static Parkstraße instance = new Parkstraße();

    private Parkstraße(){
        super("Parkstraße", 37, PropertyColorType.BLUE, 350,
                new int[]{35, 175, 500, 1100, 1300, 1500}, 200);
    }

    public static Parkstraße getInstance() {
        return instance;
    }
}
