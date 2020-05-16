package com.altimetrik.playGround.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO representing the impacts counts the service is currently tracking
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImpactMetrics {
    private long totalTestResults;
    private long positiveCases;
    private long negativeCases;
    private long death;
}
