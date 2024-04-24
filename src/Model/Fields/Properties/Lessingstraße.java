package Model.Fields.Properties;

public class Lessingstraße extends Property_Field{
    private final static Lessingstraße instance = new Lessingstraße();

    private Lessingstraße(){
        super("Lessingstraße", 26, PropertyColorType.YELLOW, 260,
                new int[]{22, 110, 330, 800, 975, 1150}, 150);
    }

    public static Lessingstraße getInstance() {
        return instance;
    }
}
