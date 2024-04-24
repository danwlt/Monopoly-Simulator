package Model.Fields.Railroads;

public class Hauptbahnhof extends Railroad_Field{
    private final static Hauptbahnhof instance = new Hauptbahnhof();

    private Hauptbahnhof(){
        super(5);
    }

    public static Hauptbahnhof getInstance() {
        return instance;
    }
}
