package Model.Fields.ChanceFields;

public class ChanceFields {

    final private static Chance_Field chanceField1 = new Chance_Field(7);
    final private static Chance_Field chanceField2 = new Chance_Field(22);
    final private static Chance_Field chanceField3 = new Chance_Field(36);

    public static Chance_Field getInstance1() {return chanceField1;}

    public static Chance_Field getInstance2() {return chanceField2;}

    public static Chance_Field getInstance3() {return chanceField3;}
}
