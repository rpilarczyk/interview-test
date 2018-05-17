package com.travix.medusa.busyflights.adapters;

import com.travix.medusa.busyflights.adapters.dispatcher.Adapter;
import com.travix.medusa.busyflights.adapters.dispatcher.Lines;
import com.travix.medusa.busyflights.repositories.Repository;
import com.travix.medusa.busyflights.repositories.ToughRepository;
import com.travix.medusa.busyflights.request.ToughJetRequest;
import com.travix.medusa.busyflights.response.ToughJetResponse;
import com.travix.medusa.busyflights.search.SearchRequest;
import com.travix.medusa.busyflights.search.SearchResponse;

import java.util.Collection;
import java.util.Set;

public class ToughtAdapter implements Adapter {

    public Collection<SearchResponse> adapt(SearchRequest searchRequest) {

        Repository repository = new ToughRepository();
        Set<ToughJetResponse> toughJetResponses = repository.search(new SearchRequestToToughJetRequest().convert(searchRequest));

        return new ToughJetResponseToSearchResponse().convertCollection(toughJetResponses);
    }

    class SearchRequestToToughJetRequest extends AbstractConverter<SearchRequest, ToughJetRequest> {

        @Override
        protected ToughJetRequest convertNotNull(SearchRequest source) {
            return ToughJetRequest.builder()
                    .from(source.getOrigin())
                    .to(source.getDestination())
                    .outboundDate(source.getDepartureDate())
                    .inboundDate(source.getReturnDate())
                    .numberOfAdults(source.getNumberOfPassengers())
                    .build();
        }
    }

    class ToughJetResponseToSearchResponse extends AbstractConverter<ToughJetResponse, SearchResponse> {

        @Override
        protected SearchResponse convertNotNull(ToughJetResponse source) {
            return SearchResponse.builder()
                    .carrier(Lines.TOUGHT.name())
                    .basePrice(source.getBasePrice())
                    .tax(source.getTax())
                    .discount(source.getDiscount())
                    .departureAirportName(source.getDepartureAirportName())
                    .arrivalAirportName(source.getArrivalAirportName())
                    .outboundDateTime(source.getOutboundDateTime())
                    .inboundDateTime(source.getInboundDateTime())
                    .build();
        }


    }

}
