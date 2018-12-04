package pl.edu.agh.activities_fragments.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import pl.edu.agh.activities_fragments.domain.News;
import pl.edu.agh.activities_fragments.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsDetailFragment extends android.support.v4.app.Fragment {

    private News news;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        news = (News) getArguments().getSerializable("news");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_detail,
                container, false);
        TextView tvTitle = (TextView) view.findViewById(R.id.tvTitle);
        TextView tvBody = (TextView) view.findViewById(R.id.tvBody);
        tvTitle.setText(news.getTitle());
        tvBody.setText(news.getBody());
        return view;
    }

    public NewsDetailFragment() {
        // Required empty public constructor
    }

    // NewsDetailFragment.newInstance(news)
    public static NewsDetailFragment newInstance(News news) {
        NewsDetailFragment fragmentDemo = new NewsDetailFragment();
        Bundle args = new Bundle();
        args.putSerializable("news", news);
        fragmentDemo.setArguments(args);
        return fragmentDemo;
    }
}
