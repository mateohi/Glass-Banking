package uy.infocorp.banking.glass.integration.publicapi.news;

import uy.infocorp.banking.glass.R;
import uy.infocorp.banking.glass.integration.publicapi.PublicUrls;
import uy.infocorp.banking.glass.integration.publicapi.news.dto.NewsDTO;
import uy.infocorp.banking.glass.util.http.RestExecutionBuilder;
import uy.infocorp.banking.glass.util.resources.ResourceUtils;

public class NewsClient {

    private static NewsClient instance;
    private RestExecutionBuilder builder;

    private NewsClient() {
        this.builder = RestExecutionBuilder.get(PublicUrls.GET_NEWSFEED_URL);
    }

    public static NewsClient instance() {
        if (instance == null) {
            instance = new NewsClient();
        }
        return instance;
    }

    public NewsDTO getNewsFeed() {
        if (ResourceUtils.offline()) {
            return ResourceUtils.jsonToObject(R.raw.news_feed, NewsDTO.class);
        }

        return this.builder.execute(NewsDTO.class);
    }
}
