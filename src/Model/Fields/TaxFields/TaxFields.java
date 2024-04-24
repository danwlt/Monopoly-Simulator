package Model.Fields.TaxFields;

public class TaxFields {
    private final static Tax_Field IncomeTax = new Tax_Field(5, 200);
    private final static Tax_Field LuxuryTax = new Tax_Field(38, 100);

    public static Tax_Field getIncomeTax(){return IncomeTax;}
    public static Tax_Field getLuxuryTax(){return LuxuryTax;}
}
