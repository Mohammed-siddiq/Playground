package com.altimetrik.playGround.RestClient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CountryResponse {

    private int positive;
    private int negative;
    private int pending;
    private int hospitalizedCurrently;
    private int hospitalizedCumulative;
    private int inIcuCumulative;
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
