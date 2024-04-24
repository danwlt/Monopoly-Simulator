package Model.Fields.Properties;

public class WienerStraße extends Property_Field{
    private static final WienerStraße instance = new WienerStraße();

    private WienerStraße(){
        super("Wiener Straße", 18, PropertyColorType.ORANGE, 180, new int[]{14, 70, 200, 550, 750, 950}, 100);
    }

    public static WienerStraße getInstance(){
        return instance;
    }
}
