package com.travix.medusa.busyflights.search;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SearchRequest {

    private String origin;
    private String destination;
    private String departureDate;
    private String returnDate;
    private int numberOfPassengers;


}
