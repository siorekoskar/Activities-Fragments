package pl.edu.agh.activities_fragments.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import pl.edu.agh.activities_fragments.R;
import pl.edu.agh.activities_fragments.domain.News;

public class NewsListActivity extends AppCompatActivity {
    private ArrayAdapter<News> adapterItems;
    private ListView lvItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items_list);

        ArrayList<News> news = News.getItems();
        adapterItems = new ArrayAdapter<News>(this,
                android.R.layout.simple_list_item_activated_1, news);

        lvItems = (ListView) findViewById(R.id.lvItems);
        lvItems.setAdapter(adapterItems);
        lvItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View item,
                                    int position, long rowId) {
                System.out.println(position);
            }
        });
    }

}
