package com.travix.medusa.busyflights.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BusyRequestRequest {

    private String origin;
    private String destination;
    private String departureDate;
    private String returnDate;
    private int numberOfPassengers;

}

