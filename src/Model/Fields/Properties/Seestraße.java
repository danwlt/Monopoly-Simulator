package Model.Fields.Properties;

public class Seestraße extends Property_Field{
    private static final Seestraße instance = new Seestraße();
    private Seestraße(){
        super("Seestraße", 11, PropertyColorType.PINK, 140, new int[]{10, 50, 150, 450, 625, 750}, 100);
    }

    public static Seestraße getInstance(){
        return instance;
    }

}
