package Model.Fields.UtilityFields;

public class UtilityFields {
    final private static Utility_Field ElectricCompany = new Utility_Field("Electric Company",12);
    final private static Utility_Field WaterWorks = new Utility_Field("Water Works",28);

    public static Utility_Field getElectricCompany() {
        return ElectricCompany;
    }

    public static Utility_Field getWaterWorks() {
        return WaterWorks;
    }

}
