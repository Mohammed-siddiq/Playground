package com.altimetrik.playGround.RestClient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CDCUSResponse {

    private int positive;
    private int negative;
    private int pending;
    private int hospitalizedCurrently;
    private int hospitalizedCumulative;
    private int inIcuCumulative;
    private int onVentilatorCurrently;





}
