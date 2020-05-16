package com.altimetrik.playGround;

import com.altimetrik.playGround.utils.ErrorConstants;
import com.altimetrik.playGround.dtos.ImpactResponse;
import com.altimetrik.playGround.services.IService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PlaygroundApplicationTests {

    @Autowired
    private IService impactService;

    @Test
    void contextLoads() {
    }

    @Test
    public void verifyValidUSResults() {

        ImpactResponse response = impactService.getImpactedMetricsForCountry("US");
        Assertions.assertNotNull(response);
        Assertions.assertTrue(response.isSuccess());
        Assertions.assertTrue(response.getImpactedMetrics().getNegativeCases() > 0);
    }


    @Test
    public void verifyInValidUSResults() {

        ImpactResponse response = impactService.getImpactedMetricsForCountry("invlaidCountry");
        Assertions.assertNotNull(response);
        Assertions.assertTrue(!response.isSuccess());
        Assertions.assertEquals(response.getMessage(), ErrorConstants.INVALID_COUNTRY);
    }

    @Test
    void verifyValidStateResult() {
        ImpactResponse response = impactService.getImpactedMetricsForState("US", "AZ");
        Assertions.assertNotNull(response);
        Assertions.assertTrue(response.isSuccess());
        Assertions.assertTrue(response.getImpactedMetrics().getNegativeCases() > 0);
        Assertions.assertTrue(response.getImpactedMetrics().getTotalTestResults() > 0);
        Assertions.assertTrue(response.getImpactedMetrics().getPositiveCases() > 0);

    }

    @Test
    void verifyAnotherValidStateResult() {
        ImpactResponse response = impactService.getImpactedMetricsForState("US", "IL");
        Assertions.assertNotNull(response);
        Assertions.assertTrue(response.isSuccess());
        Assertions.assertTrue(response.getImpactedMetrics().getNegativeCases() > 0);
        Assertions.assertTrue(response.getImpactedMetrics().getTotalTestResults() > 0);
        Assertions.assertTrue(response.getImpactedMetrics().getPositiveCases() > 0);

    }

    @Test
    void verifyInValidStateResult() {
        ImpactResponse response = impactService.getImpactedMetricsForState("US", "invalidState");
        Assertions.assertNotNull(response);
        Assertions.assertTrue(!response.isSuccess());
        Assertions.assertEquals(response.getMessage(), ErrorConstants.INVALID_STATE);


    }

}
