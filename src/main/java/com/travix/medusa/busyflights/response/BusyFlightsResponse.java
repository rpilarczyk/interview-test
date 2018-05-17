package com.travix.medusa.busyflights.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class BusyFlightsResponse {

    private String airline;
    private double price;
    private String origin;
    private String destination;
    private String departureDate;
    private String returnDate;
    private int numberOfPassengers;

}
