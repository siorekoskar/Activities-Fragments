package pl.edu.agh.activities_fragments;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ActivityItemsList extends AppCompatActivity implements ItemsListFragment.OnListItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items_list);
    }

    @Override
    public void onItemSelected(Item item) {
        // For phone, launch detail activity using intent
        Intent i = new Intent(this, ItemDetailActivity.class);
        // Embed the serialized item
        i.putExtra("item", item);
        // Start the activity
        startActivity(i);
    }
}
