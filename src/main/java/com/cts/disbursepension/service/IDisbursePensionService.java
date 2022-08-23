package com.cts.disbursepension.service;

import com.cts.disbursepension.model.PensionerDetail;
import com.cts.disbursepension.model.ProcessPensionInput;
import com.cts.disbursepension.model.ProcessPensionResponse;


 //Interface for Disburse Pension service
 
public interface IDisbursePensionService {

	
	 //find bank charges for a particular bank type in local repository
	
	public double findBankCharges(String bankType);

	
	 // verify pension amount and bank charges in ProcessPensionInput
	
	public ProcessPensionResponse verifyPension(ProcessPensionInput processPensionInput);

	
	 // verify pension amount by calculation pension amount using details in pensionerDetail
	
	public boolean verifyPensionAmount(PensionerDetail pensionerDetail, double pensionAmount);


	 // verify bankCharges for given bankType
	
	public boolean verifyBankCharges(String bankType, double bankCharges);

	
	 // get pensioner detail from pensioner-detail-microservice using given aadhaarNumber
	
	public PensionerDetail getPensionerDetail(String aadhaarNumber);

}
