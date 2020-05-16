package com.altimetrik.playGround.utils;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Config loader and config container for the service
 */
public class Configs {
    static Config config = ConfigFactory.load("service.conf");
    public static final List<String> CLIENTS = config.getStringList("USER_NAME");
    public static final Set<String> supportedUSStates = new HashSet<>(config.getStringList("SUPPORTED_US_STATES"));
    public static final Set<String> supportedCountries = new HashSet<>(config.getStringList("SUPPORTED_COUNTIRES"));


}
