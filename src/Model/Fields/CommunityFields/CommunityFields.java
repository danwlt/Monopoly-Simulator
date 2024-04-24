package Model.Fields.CommunityFields;

public class CommunityFields {

    private final static CommunityChest_Field chest1 = new CommunityChest_Field(2);
    private final static CommunityChest_Field chest2 = new CommunityChest_Field(17);
    private final static CommunityChest_Field chest3 = new CommunityChest_Field(33);

    public static CommunityChest_Field getChest1(){return chest1;}
    public static CommunityChest_Field getChest2(){return chest2;}
    public static CommunityChest_Field getChest3(){return chest3;}
}
