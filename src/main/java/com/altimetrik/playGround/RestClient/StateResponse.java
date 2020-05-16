package com.altimetrik.playGround.RestClient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The response POJO capturing the metrics returned by the CDC for a state
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
public class StateResponse {

    private int positive;
    private int negative;
    private int pending;
    private int hospitalizedCurrently;
    private int hospitalizedCumulative;
    private int inIcuCumulative;
    private int inIcuCurrently;
    private int onVentilatorCurrently;
    private int onVentilatorCumulative;
    private int recovered;
    private String hash;
    private String lastModified;
    private int death;
    private int hospitalized;
    private int total;
    private int totalTestResults;
    private int posNeg;
    private String notes;

}
