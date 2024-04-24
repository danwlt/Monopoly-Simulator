package Model.Fields.Railroads;

public class Westbahnhof extends Railroad_Field{
    private final static Westbahnhof instance = new Westbahnhof();

    private Westbahnhof(){
        super(15);
    }

    public static Westbahnhof getInstance() {
        return instance;
    }
}
