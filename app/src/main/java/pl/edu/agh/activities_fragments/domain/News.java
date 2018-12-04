package pl.edu.agh.activities_fragments.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import pl.edu.agh.activities_fragments.R;

/**
 * Created by karl on 12/3/2018.
 */

public class News implements Serializable {
    private static final long serialVersionUID = -1213949467658913456L;
    private String title;
    private String body;
    private String imageRef;

    final Map<String, Integer> imagesMap = new HashMap<String, Integer>() {{
        put("modric", R.drawable.modric);
        put("judge", R.drawable.judge);
        put("thief", R.drawable.thief);
        put("whatsapp", R.drawable.whatsapp);
        put("apple", R.drawable.apple);
    }};

    public News(String title, String imageRef, String body) {
        this.title = title;
        this.imageRef = imageRef;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public Integer getImage() {
        return imagesMap.get(imageRef);
    }

    @Override
    public String toString() {
        return getTitle();
    }

    public static ArrayList<News> getItems() {
        ArrayList<News> news = new ArrayList<News>();
        news.add(new News("Croatia captain Modrić wins Ballon d'Or to end Ronaldo, Messi era", "modric", "Midfielder Luka Modrić, who led Croatia to their first-ever FIFA World Cup final, won this year's Ballon d'Or on Monday. The 33-year-old was named 2018 FIFA World Cup's best player and had also won this year's The Best FIFA Men's Player award. This is the first time since 2007 that neither Cristiano Ronaldo nor Lionel Messi won the Ballon d'Or."));
        news.add(new News("Court rejects man's request to reduce his age by 20 yrs for Tinder", "judge", "Dutch court has rejected a 69-year-old man named Emile Ratelband's request to reduce his official age by 20 years to get more matches on dating app Tinder. Emile argued his official age didn't reflect his emotional state and made it difficult for him to find love. \"Amending his age would cause 20 years of records to vanish,\" the court said."));
        news.add(new News("Thief uses Google Maps to find rich houses, takes flights to rob", "thief", "Hyderabad Police has arrested an Andhra Pradesh-based thief named Sathiya Reddy, who took help of Google Maps to find posh areas in Chennai and took flights to commit robberies. Reddy visited the targeted areas and zeroed-in on houses which were either locked or whose residents were mostly outside. He then broke into the targeted houses wearing mask and gloves."));
        news.add(new News("WhatsApp launches first-ever TV campaign to fight fake news", "whatsapp", "WhatsApp on Monday launched its first-ever television campaign in India called 'Share Joy, Not Rumours' to address fake news ahead of 2019 general elections. It comprises three 60-second films that convey scenarios about dangerous rumours that spread via spam among user groups. “The campaign is timed to start just prior to the elections in Rajasthan and Telangana,” WhatsApp said."));
        news.add(new News("Apple to wait till 2020 to release first 5G iPhone: Report", "apple", "Apple will reportedly wait till 2020 to release its first 5G iPhone. The decision reportedly could be a result of Apple’s dispute with Qualcomm and its switch to Intel as its sole provider of chips. Intel’s current 5G chip is reportedly facing problems with heat dissipation and power consumption and it would not have a viable chip ready before 2020. "));
        return news;
    }
}
