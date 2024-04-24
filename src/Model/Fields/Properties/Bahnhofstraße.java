package Model.Fields.Properties;

public class Bahnhofstraße extends Property_Field{
    private final static Bahnhofstraße instance = new Bahnhofstraße();

    private Bahnhofstraße(){
        super("Bahnhofstraße", 34, PropertyColorType.GREEN, 320,
                new int[]{28, 150, 450, 1000, 1200, 1400}, 200);
    }

    public static Bahnhofstraße getInstance() {
        return instance;
    }
}
