package com.travix.medusa.busyflights.search;

import com.travix.medusa.busyflights.adapters.dispatcher.AdapterFactory;
import com.travix.medusa.busyflights.adapters.dispatcher.Lines;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SearchAdapter {

    @Autowired
    AdapterFactory adapterFactory;

    public List<SearchResponse> search(SearchRequest searchRequest) {

        List<SearchResponse> assembleResultList = new ArrayList();

        assembleResultList.addAll(adapterFactory.getAdapter(Lines.BUSY).get().adapt(searchRequest));
        assembleResultList.addAll(adapterFactory.getAdapter(Lines.CRAZY).get().adapt(searchRequest));
        assembleResultList.addAll(adapterFactory.getAdapter(Lines.TOUGHT).get().adapt(searchRequest));

        return assembleResultList;

    }

}
