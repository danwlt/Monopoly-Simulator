package Model.Fields.Properties;

public class Turmstraße extends Property_Field{
    private static final Turmstraße instance = new Turmstraße();
    private Turmstraße(){
        super("Turmstraße", 3, PropertyColorType.BROWN, 60, new int[]{4, 20, 60, 180, 320, 450}, 50);
    }

    public static Turmstraße getInstance(){
        return instance;
    }
}
