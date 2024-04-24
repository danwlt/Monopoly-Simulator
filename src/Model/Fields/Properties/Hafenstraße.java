package Model.Fields.Properties;

public class Hafenstraße extends Property_Field{
    private static final Hafenstraße instance = new Hafenstraße();

    private Hafenstraße(){
        super("Hafenstraße", 13, PropertyColorType.PINK, 140, new int[]{10, 50, 150, 450, 625, 750}, 100);
    }

    public static Hafenstraße getInstance(){
        return instance;
    }
}
