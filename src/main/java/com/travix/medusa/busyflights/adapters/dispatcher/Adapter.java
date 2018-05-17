package com.travix.medusa.busyflights.adapters.dispatcher;

import com.travix.medusa.busyflights.search.SearchRequest;
import com.travix.medusa.busyflights.search.SearchResponse;

import java.util.Collection;

public interface Adapter {

    Collection<SearchResponse> adapt(SearchRequest searchRequest);
}
