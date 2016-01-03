package ahmad.aghazadeh.recyclerviewcardview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView
        .Adapter<RecyclerView.ViewHolder> {
    private   List<BaseCard> list=new LinkedList<>();
    private static String LOG_TAG = "MyRecyclerViewAdapter";
    private static MyClickListener myClickListener;
    private final Context context;


    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public MyRecyclerViewAdapter(  Context context) {
        this.context = context;

    }

    public  void AddCard(Object object,BaseCard.CardType cardType){
        try{
            BaseCard b=new BaseCard<>(object, cardType.ordinal());
            list.add(b);
            notifyItemInserted(list.size());
        }catch (Exception ex)
        {
            ex.getMessage();
        }

    }

    @Override
    public int getItemViewType(int position) {

        return list.get(position).viewType;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {
        BaseCard.CardType t = BaseCard.CardType.values()[viewType];

        switch (t) {
            case Pic:
                return CardPic.Create(context, parent);
            case Text:
                return CardText.Create(context, parent);
            case Video:
                return CardVideo.Create(context, parent);
        }
        return null;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        BaseCard.CardType cardType = BaseCard.CardType.values()[getItemViewType(position)];

        switch (cardType) {
            case Pic:
                CardPic.Bind((CardPic) holder, list.get(position).object);
                break;
            case Text:
                CardText.Bind((CardText) holder, list.get(position).object);
                break;
            case Video:
                CardVideo.Bind((CardVideo) holder, list.get(position).object);
                break;
        }


    }



/*
    public void deleteItem(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }
*/

    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }
}