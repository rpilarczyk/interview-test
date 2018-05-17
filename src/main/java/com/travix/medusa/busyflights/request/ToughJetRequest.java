package com.travix.medusa.busyflights.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class ToughJetRequest {

    private String from;
    private String to;
    private String outboundDate;
    private String inboundDate;
    private int numberOfAdults;

}
