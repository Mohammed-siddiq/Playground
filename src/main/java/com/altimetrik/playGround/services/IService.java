package com.altimetrik.playGround.services;


import com.altimetrik.playGround.dtos.ImpactResponse;

/**
 * Interface defining the services being offered
 */
public interface IService {

    ImpactResponse getImpactedMetricsForState(String country, String state);
    ImpactResponse getImpactedMetrics(String country);



}
