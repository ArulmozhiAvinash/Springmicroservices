package io.avinash.microservices.limitsservices.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.avinash.microservices.limitsservices.config.LimitsConfigurationDetails;
import io.avinash.microservices.limitsservices.enitites.LimitsConfiguration;

@RestController
public class LimitsController {
	
	@Autowired
	LimitsConfigurationDetails limitsConfigurationDetails;
	
	@GetMapping("/limits")
	public LimitsConfiguration retriveLimitsInformation() {
		LimitsConfiguration config = new LimitsConfiguration(limitsConfigurationDetails.getMinimum(),limitsConfigurationDetails.getMaximum());
		return config;
	}
	

}
