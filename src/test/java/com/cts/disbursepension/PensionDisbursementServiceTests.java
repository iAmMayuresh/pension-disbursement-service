package com.cts.disbursepension;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.cts.disbursepension.controller.DisbursePensionController;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;

 // Test Cases to check all the necessary class is loaded

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class PensionDisbursementServiceTests {
	
	@Autowired
	private DisbursePensionController controller;

	@LocalServerPort
	private int port;
	
	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}

