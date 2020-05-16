package com.altimetrik.playGround.utils;

import org.springframework.stereotype.Component;

/**
 * Impact service utility having helper methods
 */
@Component
public class ImpactServiceUtil {


    /**
     * Validates the given state and country
     *
     * @param state   the state to be validated
     * @param country the country
     * @return validity boolean
     */
    public boolean validateState(String state, String country) {

        if (country.trim().length() == 0 || !Configs.supportedCountries.contains(country.trim()))
            return false;

        // if state is more than two chars and unknown us state
        return state.trim().length() == 2 && Configs.supportedUSStates.contains(state.trim());

    }
}
