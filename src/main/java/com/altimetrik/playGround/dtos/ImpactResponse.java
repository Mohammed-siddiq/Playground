package com.altimetrik.playGround.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data transfer object for returning the success response
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImpactResponse {

    private boolean success;
    private String message;
    private String country;
    private String state;
    private ImpactMetrics impactedMetrics;

}
