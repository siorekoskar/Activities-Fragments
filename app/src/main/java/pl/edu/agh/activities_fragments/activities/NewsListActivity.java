package pl.edu.agh.activities_fragments.activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import pl.edu.agh.activities_fragments.R;
import pl.edu.agh.activities_fragments.domain.News;
import pl.edu.agh.activities_fragments.fragments.NewsDetailFragment;
import pl.edu.agh.activities_fragments.fragments.NewsListFragment;

public class NewsListActivity extends AppCompatActivity implements NewsListFragment.OnListItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items_list);
    }

    @Override
    public void onItemSelected(News news) {
        Intent i = new Intent(this, NewsDetailActivity.class);
        i.putExtra("news", news);
        startActivity(i);
    }
}
