package ahmad.aghazadeh.recyclerviewcardview.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ahmad.aghazadeh.recyclerviewcardview.R;
import ahmad.aghazadeh.recyclerviewcardview.business.PicData;
import ahmad.aghazadeh.recyclerviewcardview.cards.CardPic;
import ahmad.aghazadeh.recyclerviewcardview.logic.CardViewType;
import ahmad.aghazadeh.recyclerviewcardview.logic.TitleSection;
import butterknife.ButterKnife;
import butterknife.InjectView;
import jp.satorufujiwara.binder.Section;
import jp.satorufujiwara.binder.recycler.RecyclerBinderAdapter;

public class SampleFragment extends Fragment {

    public static  SampleFragment newInstance() {
        return new  SampleFragment();
    }

    @InjectView(R.id.recycler_view_main)
    RecyclerView recyclerView;
    private StaggeredGridLayoutManager mStaggeredLayoutManager;
    private final RecyclerBinderAdapter<TitleSection, CardViewType> adapter
            = new RecyclerBinderAdapter<>();

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_cards, container, false);
        ButterKnife.inject(this, v);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);





        mStaggeredLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mStaggeredLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        CardPic cardPic=new CardPic(getActivity(),new PicData("Title","Desc in Section 1","https://pixabay.com/static/uploads/photo/2015/04/10/00/41/yellow-715540_960_720.jpg"));

        adapter.add(TitleSection.SECTION_1, cardPic);
        adapter.add(TitleSection.SECTION_1, cardPic);
        adapter.add(TitleSection.SECTION_1, cardPic);

       cardPic=new CardPic(getActivity(),new PicData("Title","Desc in Section 2","https://pixabay.com/static/uploads/photo/2014/06/10/16/57/flowers-366155_960_720.jpg"));
        adapter.add(TitleSection.SECTION_2, cardPic);
        adapter.add(TitleSection.SECTION_2, cardPic);

        cardPic=new CardPic(getActivity(),new PicData("Title","Desc in Section 3","https://pixabay.com/static/uploads/photo/2012/02/24/16/46/dandelion-16656_960_720.jpg"));
        adapter.add(TitleSection.SECTION_3, cardPic);
        adapter.add(TitleSection.SECTION_3, cardPic);
        cardPic=new CardPic(getActivity(),new PicData("Title","Desc in Section 3","https://pixabay.com/static/uploads/photo/2013/04/05/21/20/bee-100928_960_720.jpg"));
        adapter.add(TitleSection.SECTION_3, cardPic);


    }

    public  void changeLayoutStaggered(int span)
    {
        mStaggeredLayoutManager.setSpanCount(span);
        mStaggeredLayoutManager.invalidateSpanAssignments();
    }

}
