package Model.Fields.Properties;

public class MünchenerStraße extends Property_Field{
    private static final MünchenerStraße instance = new MünchenerStraße();

    private MünchenerStraße(){
        super("Münchener Straße", 16, PropertyColorType.ORANGE, 180, new int[]{14, 70, 200, 550, 750, 950}, 100);
    }

    public static MünchenerStraße getInstance(){
        return instance;
    }
}
