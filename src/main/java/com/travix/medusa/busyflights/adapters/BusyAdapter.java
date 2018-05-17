package com.travix.medusa.busyflights.adapters;

import com.travix.medusa.busyflights.adapters.dispatcher.Adapter;
import com.travix.medusa.busyflights.adapters.dispatcher.Lines;
import com.travix.medusa.busyflights.response.BusyFlightsResponse;
import com.travix.medusa.busyflights.request.BusyRequestRequest;
import com.travix.medusa.busyflights.repositories.BusyRepository;
import com.travix.medusa.busyflights.search.SearchRequest;
import com.travix.medusa.busyflights.search.SearchResponse;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public class BusyAdapter implements Adapter {

    public Collection<SearchResponse> adapt(SearchRequest searchRequest) {

        BusyRepository repository = new BusyRepository();
        Set<BusyFlightsResponse> busyFlightsResponses = repository.search(new SearchRequestToBusyRequestRequest().convert(searchRequest));

        return new BusyFlightsResponseToSearchResponse().convertCollection(busyFlightsResponses);

    }

    class SearchRequestToBusyRequestRequest extends AbstractConverter<SearchRequest, BusyRequestRequest> {

        @Override
        protected BusyRequestRequest convertNotNull(SearchRequest source) {
            return BusyRequestRequest.builder()
                    .departureDate(source.getDepartureDate())
                    .destination(source.getDestination())
                    .numberOfPassengers(source.getNumberOfPassengers())
                    .origin(source.getOrigin())
                    .returnDate(source.getReturnDate()).build();
        }
    }

    class BusyFlightsResponseToSearchResponse extends AbstractConverter<BusyFlightsResponse, SearchResponse> {

        @Override
        protected SearchResponse convertNotNull(BusyFlightsResponse source) {
            return SearchResponse.builder()
                    .carrier(Lines.BUSY.name())
                    .inboundDateTime(source.getDepartureDate())
                    .outboundDateTime(source.getReturnDate())
                    .arrivalAirportName(source.getDestination())
                    .departureAirportName(source.getOrigin())
                    .build();
        }
    }

}



