package Model.Fields.Properties;

public class Elisenstraße extends Property_Field{
    private static final Elisenstraße instance = new Elisenstraße();
    private Elisenstraße() {
        super("Elisenstraße", 8, PropertyColorType.LIGHT_BLUE, 100, new int[]{6, 30, 90, 270, 400, 550}, 50);
    }

    public static Elisenstraße getInstance(){
        return instance;
    }
}
