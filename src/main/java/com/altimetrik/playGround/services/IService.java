package com.altimetrik.playGround.services;


import com.altimetrik.playGround.dtos.ImpactResponse;

/**
 * Interface defining the services being offered
 */
public interface IService {

    /**
     * Returns the metrics for the given country and state
     *
     * @param country the country whose covid metrics are required
     * @param state   the state code
     * @return {@link ImpactResponse}
     */
    ImpactResponse getImpactedMetricsForState(String country, String state);

    /**
     * Returns the metrics for the given country
     *
     * @param country the country whose covid metrics are required //For now supporting only US
     * @return {@link ImpactResponse}
     */
    ImpactResponse getImpactedMetricsForCountry(String country);


}
