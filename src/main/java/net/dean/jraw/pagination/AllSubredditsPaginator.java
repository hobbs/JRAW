package net.dean.jraw.pagination;

import net.dean.jraw.EndpointImplementation;
import net.dean.jraw.Endpoints;
import net.dean.jraw.RedditClient;
import net.dean.jraw.http.NetworkException;
import net.dean.jraw.models.core.Listing;
import net.dean.jraw.models.core.Subreddit;

/**
 * This paginator will iterate through the newest and most popular subreddits
 */
public class AllSubredditsPaginator extends GenericPaginator<Subreddit, AllSubredditsPaginator.Where, AllSubredditsPaginator> {

    private AllSubredditsPaginator(Builder b) {
        super(b);
    }

    @Override
    @EndpointImplementation({
            Endpoints.SUBREDDITS_POPULAR,
            Endpoints.SUBREDDITS_NEW,
            Endpoints.SUBREDDITS_WHERE
    })
    protected Listing<Subreddit> getListing(boolean forwards) throws NetworkException {
        // Just call super so that we can add the @EndpointImplementation annotation
        return super.getListing(forwards);
    }

    @Override
    public String getUriPrefix() {
        return "/subreddits/";
    }

    public static enum Where {
        POPULAR,
        NEW
    }

    public static class Builder extends GenericPaginator.Builder<Subreddit, Where, AllSubredditsPaginator> {

        /**
         * Instantiates a new Builder
         *
         * @param reddit The RedditClient to send requests with
         * @param where  The enum that will be appended to the
         */
        public Builder(RedditClient reddit, Where where) {
            super(reddit, Subreddit.class, where);
        }

        @Override
        public AllSubredditsPaginator build() {
            return new AllSubredditsPaginator(this);
        }
    }
}
