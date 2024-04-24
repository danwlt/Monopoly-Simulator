package Model.Fields.Properties;

public class Schlossallee extends Property_Field{
    private final static Schlossallee instance = new Schlossallee();

    private Schlossallee(){
        super("Schlossallee", 39, PropertyColorType.BLUE, 400,
                new int[]{50, 200, 600, 1400, 1700, 2000}, 200);
    }

    public static Schlossallee getInstance() {
        return instance;
    }

}
