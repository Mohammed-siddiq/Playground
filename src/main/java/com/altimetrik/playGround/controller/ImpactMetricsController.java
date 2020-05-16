package com.altimetrik.playGround.controller;


import com.altimetrik.playGround.dtos.ImpactResponse;
import com.altimetrik.playGround.services.IService;
import com.altimetrik.playGround.utils.ErrorConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/playground/impact-metrics")
public class ImpactMetricsController {


    @Autowired
    private IService impactService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @GetMapping("/hello-world")
    public String helloWorld() {
        return "helloWorld";
    }

    @GetMapping("/us")
    public ResponseEntity<ImpactResponse> getCountryMetrics() {

        logger.info("Recieved request to get US metrics");
        ImpactResponse response;
        try {
            response = impactService.getImpactedMetrics("US");
            if (response.isSuccess()) {
                logger.info("Returning successful response");
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
            } else {
                logger.info("Returning bad request response..");
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

            }
        } catch (Exception ex) {
            response = new ImpactResponse();
            response.setMessage(ErrorConstants.GENERIC_ERROR_MESSAGE);
            logger.error("Exception occured", ex.getCause());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/state")
    public ResponseEntity<ImpactResponse> getStateMetrics(@RequestParam String state) {
        logger.info("Recieved request to get metrics for state : {}", state);
        ImpactResponse response;
        try {
            response = impactService.getImpactedMetricsForState("US", state);
            if (response.isSuccess()) {

                logger.info("Returning successful response");

                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

            } else {
                logger.info("Returning bad request ");

                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

            }
        } catch (Exception ex) {
            response = new ImpactResponse();
            response.setMessage(ErrorConstants.GENERIC_ERROR_MESSAGE);
            logger.error("Exception occured", ex.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
