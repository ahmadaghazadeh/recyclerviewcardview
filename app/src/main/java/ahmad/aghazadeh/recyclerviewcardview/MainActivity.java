package ahmad.aghazadeh.recyclerviewcardview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import ahmad.aghazadeh.recyclerviewcardview.business.PicData;
import ahmad.aghazadeh.recyclerviewcardview.fragments.FragmentActivityExt;
import ahmad.aghazadeh.recyclerviewcardview.fragments.SampleFragment;


public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;

    private Menu menu;
    private boolean isListView;
    private RecyclerView mRecyclerView;
    private static String LOG_TAG = "CardViewActivity";
    SampleFragment sampleFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setUpActionBar();
        sampleFragment= (SampleFragment) FragmentActivityExt
                .setContentFragment(this, R.id.container, SampleFragment.newInstance());
       isListView = true;
    }


    private void setUpActionBar() {
        if (toolbar != null) {
            //setActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            getSupportActionBar().setDisplayShowTitleEnabled(true);
            getSupportActionBar().setElevation(5);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        this.menu = menu;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_toggle) {
            toggle();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void toggle() {
        MenuItem item = menu.findItem(R.id.action_toggle);
        if (isListView) {
            sampleFragment.changeLayoutStaggered(2);
            item.setIcon(R.drawable.ic_action_list);
            item.setTitle("Show as list");
            isListView = false;
        } else {
            sampleFragment.changeLayoutStaggered(1);
            item.setIcon(R.drawable.ic_action_grid);
            item.setTitle("Show as grid");
            isListView = true;
        }

    }

    @Override
    protected void onResume() {
        super.onResume();

    }


}
