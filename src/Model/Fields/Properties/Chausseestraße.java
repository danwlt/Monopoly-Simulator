package Model.Fields.Properties;

public class Chausseestraße extends Property_Field{
    private static final Chausseestraße instance = new Chausseestraße();
    private Chausseestraße() {
        super("Chausseestraße", 6, PropertyColorType.LIGHT_BLUE, 100, new int[]{6, 30, 90, 270, 400, 550}, 50);
    }

    public static Chausseestraße getInstance(){
        return instance;
    }
}
