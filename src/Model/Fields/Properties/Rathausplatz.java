package Model.Fields.Properties;

public class Rathausplatz extends Property_Field{
    private final static Rathausplatz instance = new Rathausplatz();

    private Rathausplatz(){
        super("Rathausplatz", 31, PropertyColorType.GREEN, 300,
                new int[]{26, 130, 390, 900, 1100, 1275}, 200);
    }

    public static Rathausplatz getInstance() {
        return instance;
    }
}
