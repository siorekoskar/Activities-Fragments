package pl.edu.agh.activities_fragments.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import pl.edu.agh.activities_fragments.domain.News;
import pl.edu.agh.activities_fragments.R;

/**
 * Created by karl on 12/3/2018.
 */

public class NewsListFragment extends Fragment {
    private ArrayAdapter<News> adapterItems;
    private ListView lvItems;

    private OnListItemSelectedListener listener;

    public interface OnListItemSelectedListener {
        public void onItemSelected(News news);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnListItemSelectedListener) {
            listener = (OnListItemSelectedListener) activity;
        } else {
            throw new ClassCastException(
                    activity.toString()
                            + " must implement NewsListFragment.OnListItemSelectedListener");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Create arraylist from item fixtures
        ArrayList<News> news = News.getItems();
        // Create adapter based on news
        adapterItems = new ArrayAdapter<News>(getActivity(),
                android.R.layout.simple_list_item_activated_1, news);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate view
        View view = inflater.inflate(R.layout.fragment_items_list, container,
                false);
        // Bind adapter to ListView
        lvItems = (ListView) view.findViewById(R.id.lvItems);
        lvItems.setAdapter(adapterItems);
        lvItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View item,
                                    int position, long rowId) {
                // Retrieve item based on position
                News news2 = adapterItems.getItem(position);
                // Fire selected listener event with item
                listener.onItemSelected(news2); // <--------------
            }
        });
        return view;
    }
}
