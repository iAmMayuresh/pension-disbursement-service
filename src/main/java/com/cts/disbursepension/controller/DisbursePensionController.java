package com.cts.disbursepension.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import com.cts.disbursepension.exception.InvalidTokenException;
import com.cts.disbursepension.feign.AuthorisationClient;
import com.cts.disbursepension.model.ProcessPensionInput;
import com.cts.disbursepension.model.ProcessPensionResponse;
import com.cts.disbursepension.service.IDisbursePensionService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;


 // DisbursePension Controller which handles request to verify pension amount and bank charges

@RestController
@Slf4j
public class DisbursePensionController {
	@Autowired
	IDisbursePensionService disbursePensionService;
	
	@Autowired
	AuthorisationClient authorisationClient;

	
	@GetMapping("/HealthCheck")
	@ApiOperation(value = "healthCheck", notes = "Check whether microservice is up and running or not", httpMethod = "GET", response = String.class)
	public ResponseEntity<String> healthCheck() {
		log.info("Health-Check: OK");
		return new ResponseEntity<>("Pension disbursement microservice running successfully", HttpStatus.OK);
	}

	
	@PostMapping("/DisbursePension")
	@ApiOperation(value = "disbursePension", notes = "Verify pension amount and bank service charge for given aadhaar", httpMethod = "POST", response = ProcessPensionResponse.class)
	public ResponseEntity<ProcessPensionResponse> disbursePension( @RequestHeader(name = "Authorization") String token,
			@RequestBody @Valid ProcessPensionInput processPensionInput) throws InvalidTokenException {
		log.debug("Start");
		if (!authorisationClient.validate(token)) {
			throw new InvalidTokenException("You are not allowed to access this resource");
		}
		log.debug("End");
		return new ResponseEntity<>(disbursePensionService.verifyPension(processPensionInput), HttpStatus.OK);
	}

}
