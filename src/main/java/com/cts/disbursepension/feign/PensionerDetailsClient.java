package com.cts.disbursepension.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.disbursepension.model.PensionerDetail;


 // Feign Client which handles REST API calls to pension-detail-microservice
 
@FeignClient("PENSIONER-DETAIL-SERVICE")
public interface PensionerDetailsClient {
	
	 // method to get pensioner details by aadhaar number
	 
	@GetMapping("/pensionerDetailByAadhaar/{aadhaarNumber}")
	PensionerDetail pensionerDetailByAadhaar(@PathVariable String aadhaarNumber);

}
