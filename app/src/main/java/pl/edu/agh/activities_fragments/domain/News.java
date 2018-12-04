package pl.edu.agh.activities_fragments.domain;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by karl on 12/3/2018.
 */

public class News implements Serializable {
    private static final long serialVersionUID = -1213949467658913456L;
    private String title;
    private String body;

    public News(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return getTitle();
    }

    public static ArrayList<News> getItems() {
        ArrayList<News> news = new ArrayList<News>();
        news.add(new News("News 1", "This is the first item"));
        news.add(new News("News 2", "This is the second item"));
        news.add(new News("News 3", "This is the third item"));
        return news;
    }
}
