package Model.Fields.Properties;

public class Schillerstraße extends Property_Field{
    private final static Schillerstraße instance = new Schillerstraße();
    private Schillerstraße(){
        super("Schillerstraße", 27, PropertyColorType.YELLOW, 260,
                new int[]{22, 110, 330, 800, 975, 1150}, 150);
    }

    public static Schillerstraße getInstance() {
        return instance;
    }
}
