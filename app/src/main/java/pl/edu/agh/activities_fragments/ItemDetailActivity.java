package pl.edu.agh.activities_fragments;


import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class ItemDetailActivity extends AppCompatActivity {

    ItemDetailFragment fragmentItemDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);


        // Fetch the item to display from bundle
        Item item = (Item) getIntent().getSerializableExtra("item");


        // if null pointer then activity has a different theme
        // and getActionBar() may be good
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(item.getTitle());
        
        if (savedInstanceState == null) {
            // Insert detail fragment based on the item passed
            fragmentItemDetail = ItemDetailFragment.newInstance(item); // <-------
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
