package Model.Fields.Properties;

public class NeueStraße extends Property_Field{
    private static final NeueStraße instance = new NeueStraße();
    private NeueStraße(){
        super("NeueStraße", 14, PropertyColorType.PINK, 160, new int[]{12, 60, 180, 500, 700, 900}, 100);
    }

    public static NeueStraße getInstance(){
        return instance;
    }
}
