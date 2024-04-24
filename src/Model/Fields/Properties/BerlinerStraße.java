package Model.Fields.Properties;

public class BerlinerStraße extends Property_Field{
    private static final BerlinerStraße instance = new BerlinerStraße();

    private BerlinerStraße(){
        super("Berliener Straße", 19, PropertyColorType.ORANGE, 200, new int[]{16, 80, 220, 600, 800, 1000}, 100);
    }

    public static BerlinerStraße getInstance(){
        return instance;
    }
}
