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
        News news = (News) getIntent().getSerializableExtra("news");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(news.getTitle());
        
        if (savedInstanceState == null) {
            fragmentItemDetail = NewsDetailFragment.newInstance(news);
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
