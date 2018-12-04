package pl.edu.agh.activities_fragments.activities;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import pl.edu.agh.activities_fragments.domain.News;
import pl.edu.agh.activities_fragments.R;
import pl.edu.agh.activities_fragments.fragments.NewsDetailFragment;
import pl.edu.agh.activities_fragments.fragments.NewsListFragment;

public class NewsListActivity extends AppCompatActivity implements NewsListFragment.OnListItemSelectedListener {

    // Flag determines if this is a one or two pane layout
    private boolean isTwoPane = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items_list);
        // Call this to determine which layout we are in (tablet or phone)
        determinePaneLayout();
    }

    private void determinePaneLayout() {
        FrameLayout fragmentItemDetail = (FrameLayout) findViewById(R.id.flDetailContainer);
        // If there is a second pane for details
        if (fragmentItemDetail != null) {
            isTwoPane = true;
        }
    }

    @Override
    public void onItemSelected(News news) {
        if (isTwoPane) { // single activity with list and detail
            // Replace framelayout with new detail fragment
            NewsDetailFragment fragmentItem = NewsDetailFragment.newInstance(news);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flDetailContainer, fragmentItem);
            ft.commit();
        } else { // go to separate activity
            // launch detail activity using intent
            Intent i = new Intent(this, NewsDetailActivity.class);
            i.putExtra("news", news);
            startActivity(i);
        }
    }
}
