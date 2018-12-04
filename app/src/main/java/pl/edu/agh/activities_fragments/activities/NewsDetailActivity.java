package pl.edu.agh.activities_fragments.activities;


import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import pl.edu.agh.activities_fragments.domain.News;
import pl.edu.agh.activities_fragments.R;
import pl.edu.agh.activities_fragments.fragments.NewsDetailFragment;

public class NewsDetailActivity extends AppCompatActivity {

    NewsDetailFragment fragmentItemDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);


        // Fetch the news to display from bundle
        News news = (News) getIntent().getSerializableExtra("news");


        // if null pointer then activity has a different theme
        // and getActionBar() may be good
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(news.getTitle());
        
        if (savedInstanceState == null) {
            // Insert detail fragment based on the news passed
            fragmentItemDetail = NewsDetailFragment.newInstance(news); // <-------
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flDetailContainer, fragmentItemDetail);
            ft.commit();
        }

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
