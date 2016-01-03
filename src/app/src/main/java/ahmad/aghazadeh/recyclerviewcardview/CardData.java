package ahmad.aghazadeh.recyclerviewcardview;

/**
 * Created by 890683 on 1/3/2016.
 */
public class CardData {
    private   String name;
    private String family;
    public   CardData(String name,String family) {
        this.name = name;
        this.family = family;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}