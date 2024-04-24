package Model.Fields.Properties;

public class Museumsstraße extends Property_Field{
    private static final Museumsstraße instance = new Museumsstraße();

    private Museumsstraße(){
        super("Museumsstraße", 23, PropertyColorType.RED, 220,
                new int[]{18, 90, 250, 700, 875, 1050}, 150);
    }

    public static Museumsstraße getInstance() {
        return instance;
    }
}
