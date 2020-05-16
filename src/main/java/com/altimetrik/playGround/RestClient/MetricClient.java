package com.altimetrik.playGround.RestClient;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

import java.util.List;

/**
 * Rest Client to hit CDC server with GET Requests
 */
public interface MetricClient {

    /**
     * Make a http get request to fetch US metrics from the URL
     *
     * @param URI the URI : sample-> us/current.json
     * @return
     */
    @GET
    Call<List<CountryResponse>> getUSMetrics(@Url String URI);

    /**
     * Make a Http post request to fetch state wide requests make sure the url has the  state
     * ex: states/{STATE}/current.json, replace {STATE} with a valid state
     *
     * @param url
     * @return
     */
    @GET
    Call<StateResponse> getStateMetrics(@Url String url);


}
