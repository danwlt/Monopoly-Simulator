package Model.Fields.Properties;

public class Theaterstraße extends Property_Field{
    private final static Theaterstraße instance = new Theaterstraße();

    private Theaterstraße(){
        super("Theaterstraße", 21, PropertyColorType.RED, 220,
                new int[]{18, 90, 250, 700, 875, 1050}, 150);
    }

    public static Theaterstraße getInstance() {
        return instance;
    }
}
