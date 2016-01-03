package ahmad.aghazadeh.recyclerviewcardview;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by 890683 on 12/31/2015.
 */
public class BaseCard<T> {



    public   enum CardType {
        Pic ,Text,Video

    }
    @Retention(RetentionPolicy.SOURCE)
    public @interface ViewType {
    }
    @ViewType int viewType;
    T object;

    public BaseCard(T object, int viewType) {
        this.object = object;
        this.viewType = viewType;
    }

}
