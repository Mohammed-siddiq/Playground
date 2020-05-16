package com.altimetrik.playGround.services;

import com.altimetrik.playGround.dtos.ImpactResponse;
import com.altimetrik.playGround.utils.ImpactServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The service implementation for the impactMetrics
 */
@Service
public class ImpactService implements IService {

    private final ImpactServiceUtil serviceUtil;

    @Autowired
    public ImpactService(ImpactServiceUtil serviceUtil) {
        this.serviceUtil = serviceUtil;
    }

    @Override
    public ImpactResponse getImpactedMetrics(String country, String state) {

        if(serviceUtil.validateState(state,country))
            return new ImpactResponse();
        return new ImpactResponse();
    }
}
