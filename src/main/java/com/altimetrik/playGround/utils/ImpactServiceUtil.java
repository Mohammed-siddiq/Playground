package com.altimetrik.playGround.utils;

import com.altimetrik.playGround.RestClient.StateResponse;
import com.altimetrik.playGround.RestClient.CountryResponse;
import com.altimetrik.playGround.dtos.ImpactMetrics;
import com.altimetrik.playGround.dtos.ImpactResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

/**
 * Impact service utility having helper methods
 */
@Component
public class ImpactServiceUtil {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Validates the given state and country
     *
     * @param state   the state to be validated
     * @param country the country
     * @return validity boolean
     */

    public boolean validateState(String country, String state) {

        if (country.trim().length() == 0 || !Configs.supportedCountries.contains(country.trim().toUpperCase()))
            return false;

        // if state is more than two chars and unknown us state
        return state.trim().length() == 2 && Configs.supportedUSStates.contains(state.trim().toUpperCase());

    }

    /**
     * Constructs US country's response metrics from the raw response object
     *
     * @param response
     * @return
     * @throws IOException
     */


    public ImpactResponse constructImpactResponse(Response<List<CountryResponse>> response) throws IOException {

        ImpactResponse impactResponse = new ImpactResponse();
        if (response.isSuccessful()) {
            impactResponse.setSuccess(true);
            logger.debug("Response us: {}", response.body());
            impactResponse.setCountry("US");
            ImpactMetrics metrics = extractSupportedMetrics(response.body().get(0));
            impactResponse.setImpactedMetrics(metrics);
            return impactResponse;

        }

        impactResponse.setSuccess(false);
        impactResponse.setMessage(response.errorBody().string());
        return impactResponse;
    }

    /**
     * Constructs state response with metrics from the raw response object
     *
     * @param response
     * @return
     * @throws IOException
     */

    public ImpactResponse constructStateImpactResponse(Response<StateResponse> response) throws IOException {

        ImpactResponse impactResponse = new ImpactResponse();
        if (response.isSuccessful()) {
            impactResponse.setSuccess(true);
            logger.debug("Response us: {}", response.body());

            ImpactMetrics impactMetric = extractStateSupportedMetrics(response.body());
            impactResponse.setImpactedMetrics(impactMetric);
            return impactResponse;
        }

        impactResponse.setSuccess(false);
        impactResponse.setMessage(response.errorBody().string());
        return impactResponse;
    }

    /**
     * Extracts metrics that are of concern from the State's response object
     *
     * @param response the response returned from the CDC
     * @return {@link ImpactMetrics}
     */
    private ImpactMetrics extractStateSupportedMetrics(StateResponse response) {
        ImpactMetrics impactMetrics = new ImpactMetrics();
        impactMetrics.setTotalTestResults(response.getTotalTestResults());
        impactMetrics.setPositiveCases(response.getPositive());
        impactMetrics.setDeath(response.getDeath());
        impactMetrics.setNegativeCases(response.getNegative());


        return impactMetrics;
    }


    /**
     * Extracts metrics that are of concern from the country's response object
     *
     * @param usResponse the response returned from the CDC
     * @return {@link ImpactMetrics}
     */
    private ImpactMetrics extractSupportedMetrics(CountryResponse usResponse) {
        ImpactMetrics impactMetrics = new ImpactMetrics();
        impactMetrics.setNegativeCases(usResponse.getNegative());
        impactMetrics.setTotalTestResults(usResponse.getTotalTestResults());
        impactMetrics.setPositiveCases(usResponse.getPositive());
        impactMetrics.setDeath(usResponse.getDeath());
        return impactMetrics;

    }


    /**
     * Validates the country
     *
     * @param country country string to be validated
     * @return
     */
    public boolean validateCountry(String country) {
        return !(country.trim().length() == 0 || !Configs.supportedCountries.contains(country.trim().toUpperCase()));

    }
}
