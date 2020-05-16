package com.altimetrik.playGround.services;

import com.altimetrik.playGround.RestClient.StateResponse;
import com.altimetrik.playGround.RestClient.CountryResponse;
import com.altimetrik.playGround.RestClient.MetricClient;
import com.altimetrik.playGround.utils.ErrorConstants;
import com.altimetrik.playGround.dtos.ImpactResponse;
import com.altimetrik.playGround.utils.Configs;
import com.altimetrik.playGround.utils.ImpactServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

/**
 * The service implementation for the impactMetrics
 */
@Service
public class ImpactService implements IService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final ImpactServiceUtil serviceUtil;
    private Retrofit retrofit; // reftrofit client
    private MetricClient cdcClient;

    @Autowired
    public ImpactService(ImpactServiceUtil serviceUtil) {
        this.serviceUtil = serviceUtil;
        this.retrofit = new Retrofit.Builder().baseUrl(Configs.CDC_BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        cdcClient = retrofit.create(MetricClient.class);

    }

    @Override
    public ImpactResponse getImpactedMetrics(String country) {


        logger.info("getting metrics for country: {} ", country);

        ImpactResponse impactResponse = new ImpactResponse();
        if (!serviceUtil.validateCountry(country)) {
            impactResponse.setCountry(country);
            impactResponse.setMessage(ErrorConstants.INVALID_COUNTRY);
            return impactResponse;
        }

        if (serviceUtil.validateCountry(country)) {
            try {
                Call<List<CountryResponse>> usMetricRequest = cdcClient.getUSMetrics(Configs.CDC_US_ENDPOINT);
                logger.debug("Making request for us");
                Response<List<CountryResponse>> response = usMetricRequest.execute();
                logger.info("response recieved {} ", response.body());
                impactResponse = serviceUtil.constructImpactResponse(response);
                impactResponse.setCountry(country);

                logger.info("Returning respose {}", impactResponse);

                return impactResponse;

            } catch (IOException e) {
                e.printStackTrace();
                logger.error("Error {}", e.getCause());

            }

        }


        return impactResponse;
    }

    @Override
    public ImpactResponse getImpactedMetricsForState(String country, String state) {
        logger.info("getting metrics for country: {} and state{} ", country, state);

        ImpactResponse impactResponse = new ImpactResponse();
        if (!serviceUtil.validateState(country, state)) {
            impactResponse.setState(state);
            impactResponse.setCountry(country);
            impactResponse.setMessage(ErrorConstants.INVALID_STATE);
            return impactResponse;
        }

        try {
            Call<StateResponse> usMetricRequest = cdcClient.getStateMetrics(Configs.CDC_STATE_ENDPOINT.replace("{STATE}", state));
            logger.info("Making request for us");
            Response<StateResponse> response = usMetricRequest.execute();
            logger.info("response recieved {} ", response.body());
            impactResponse = serviceUtil.constructStateImpactResponse(response);
            impactResponse.setCountry(country);
            impactResponse.setState(state);
            logger.info("Returning respose {}", impactResponse);
            return impactResponse;

        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Error {}", e.getCause());

        }
        return impactResponse;

    }

}
