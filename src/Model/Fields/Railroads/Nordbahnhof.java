package Model.Fields.Railroads;

public class Nordbahnhof extends Railroad_Field{
    private final static Nordbahnhof instance = new Nordbahnhof();

    private Nordbahnhof(){
        super(25);
    }

    public static Nordbahnhof getInstance() {
        return instance;
    }
}
