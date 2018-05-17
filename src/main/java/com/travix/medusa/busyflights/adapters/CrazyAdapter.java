package com.travix.medusa.busyflights.adapters;

import com.travix.medusa.busyflights.adapters.dispatcher.Adapter;
import com.travix.medusa.busyflights.adapters.dispatcher.Lines;
import com.travix.medusa.busyflights.repositories.CrazyRepository;
import com.travix.medusa.busyflights.repositories.Repository;
import com.travix.medusa.busyflights.request.CrazyAirRequest;
import com.travix.medusa.busyflights.response.CrazyAirResponse;
import com.travix.medusa.busyflights.search.SearchRequest;
import com.travix.medusa.busyflights.search.SearchResponse;

import java.util.Collection;
import java.util.Set;

public class CrazyAdapter implements Adapter {

    public Collection<SearchResponse> adapt(SearchRequest searchRequest) {

        Repository repository = new CrazyRepository();
        Set<CrazyAirResponse> crazyAirResponses = repository.search(new SearchRequestToCrazyAirRequest().convert(searchRequest));

        return new CrazyAirResponseToSearchResponse().convertCollection(crazyAirResponses);
    }

    class SearchRequestToCrazyAirRequest extends AbstractConverter<SearchRequest, CrazyAirRequest> {

        @Override
        protected CrazyAirRequest convertNotNull(SearchRequest source) {
            return CrazyAirRequest.builder()
                    .origin(source.getOrigin())
                    .destination(source.getDestination())
                    .departureDate(source.getDepartureDate())
                    .returnDate(source.getReturnDate())
                    .passengerCount(source.getNumberOfPassengers()).build();
        }
    }

    class CrazyAirResponseToSearchResponse extends AbstractConverter<CrazyAirResponse, SearchResponse> {

        @Override
        protected SearchResponse convertNotNull(CrazyAirResponse source) {
            return SearchResponse.builder()
                    .carrier(Lines.CRAZY.name())
                    .basePrice(source.getPrice())
                    .departureAirportName(source.getDepartureAirportCode())
                    .arrivalAirportName(source.getDestinationAirportCode())
                    .outboundDateTime(source.getArrivalDate())
                    .build();
        }
    }
}
