package ahmad.aghazadeh.recyclerviewcardview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Objects;

/**
 * Created by 890683 on 12/31/2015.
 */

public class CardVideo extends RecyclerView.ViewHolder{



    public TextView txtName;
    public TextView txtFamily;

    public CardVideo(View itemView) {
        super(itemView);
        txtName = (TextView) itemView.findViewById(R.id.txtName);
        txtFamily = (TextView) itemView.findViewById(R.id.txtFamily);
    }

    public static CardVideo Create(Context context, ViewGroup parent){
        return new CardVideo(LayoutInflater.from(context).inflate(R.layout.card_view_row3, parent, false));
    }

    public static void Bind(CardVideo holder, final Object object) {
        CardData cardData=(CardData) object;
        holder.txtName.setText(cardData.getName());
        holder.txtFamily.setText(cardData.getFamily());
    }
}
