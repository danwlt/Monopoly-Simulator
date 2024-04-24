package Model.Fields.Railroads;

public class Südbahnhof extends Railroad_Field{
    private final static Südbahnhof instance = new Südbahnhof();

    private Südbahnhof(){
        super(5);
    }

    public static Südbahnhof getInstance() {
        return instance;
    }

}
