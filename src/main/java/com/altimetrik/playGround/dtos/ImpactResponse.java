package com.altimetrik.playGround.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Data transfer object for returning the success response
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class ImpactResponse {

    private boolean success;
    private String message;
    private String country;
    private String state;
    private ImpactMetrics impactedMetrics;

}
