package Model.Fields.Properties;

public class Opernplatz extends Property_Field{
    private final static Opernplatz instance = new Opernplatz();
    private Opernplatz(){
        super("Opernplatz", 24, PropertyColorType.RED, 240,
                new int[]{20, 100, 300, 750, 925, 1100}, 150);
    }

    public static Opernplatz getInstance() {
        return instance;
    }
}
