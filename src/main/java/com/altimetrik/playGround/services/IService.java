package com.altimetrik.playGround.services;


import com.altimetrik.playGround.dtos.ImpactResponse;

/**
 * Interface defining the services being offered
 */
public interface IService {

    ImpactResponse getImpactedMetrics(String country, String state);


}
