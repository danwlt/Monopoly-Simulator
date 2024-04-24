package Model.Fields.Properties;

public class Badstraße extends Property_Field {

    private static final Badstraße instance = new Badstraße();
    private Badstraße() {
        super("Badstraße", 1, PropertyColorType.BROWN, 60, new int[]{2, 10, 30, 90, 160, 250}, 50);
    }

    public static Badstraße getInstance(){
        return instance;
    }


}
