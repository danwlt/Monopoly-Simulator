package Model.Fields.Properties;

public class Goethestraße extends Property_Field{
    private final static Goethestraße instance = new Goethestraße();

    private Goethestraße(){
        super("Goethestraße", 29, PropertyColorType.YELLOW, 280,
                new int[]{24, 120, 360, 850, 1025, 1200}, 150);
    }

    public static Goethestraße getInstance() {
        return instance;
    }
}
