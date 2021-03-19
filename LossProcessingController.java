package com.hig.oracleformsmigration.lossprocessing.web;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.hig.oracleformsmigration.lossprocessing.service.LossProcessingService;
import com.hig.oracleformsmigration.lossprocessing.model.PlBatchReportDistributionList;
import com.hig.oracleformsmigration.lossprocessing.model.PlBatchSponsorReport;
import com.hig.oracleformsmigration.lossprocessing.model.PlBenefitLog;
import com.hig.oracleformsmigration.lossprocessing.model.PlBenefitLogResponse;
import com.hig.oracleformsmigration.lossprocessing.model.PlCorrectionLog;
import com.hig.oracleformsmigration.lossprocessing.model.PlCorrectionResponseLog;
import com.hig.oracleformsmigration.lossprocessing.model.Sponsor;
import com.hig.oracleformsmigration.lossprocessing.model.SponsorPolicy;
import com.hig.oracleformsmigration.lossprocessing.model.SponsorPolicyResponse;
import com.hig.oracleformsmigration.lossprocessing.model.SponsorResponse;
import com.hig.oracleformsmigration.lossprocessing.model.SponsorTaxListResponse;
import com.hig.oracleformsmigration.lossprocessing.model.BatchSponsorDistributionReportRelationship;
import com.hig.oracleformsmigration.lossprocessing.model.BenefitDescription;
import com.hig.oracleformsmigration.lossprocessing.model.CaseManagementResponse;
import com.hig.oracleformsmigration.lossprocessing.model.LpGetBenefitDtlsRequest;
import com.hig.oracleformsmigration.lossprocessing.model.LpGetBenefitDtlsResponse;
import com.hig.oracleformsmigration.lossprocessing.model.PlBatchReportDistList;



@CrossOrigin
@RestController
@RequestMapping("/lossprocessing")
public class LossProcessingController {

	@Autowired
	LossProcessingService lossprocessingService;
	
	//@Autowired
	//CaseService caseService;
	
	//@PostMapping("/lossprocessing/submit")
	//public CaseManagementResponse updateCaseManagement(@RequestBody CaseManagement caseManagement) {
	//	return caseService.updateCaseManagement(caseManagement);
	//}

	@GetMapping("/getSponsorNames")
	public List<Sponsor> getSponsor(){
		List<Sponsor> ltEmp = lossprocessingService.getSponsor();
		return ltEmp;
	}
	
	@GetMapping("/Report/{sponsorID}")
	public List<PlBatchSponsorReport> getBasedOnSponsorSelected(@PathVariable String sponsorID){
		System.out.println("Path Variable" +sponsorID);
		List<PlBatchSponsorReport> ltEmp = lossprocessingService.getBasedOnSponsorSelected(sponsorID);
		return ltEmp;
	}
	@GetMapping("/getReportDL/{emailID}")
	public List<PlBatchReportDistributionList> getReportDL(@PathVariable String emailID){
		System.out.println("Path Variable" +emailID);
		List<PlBatchReportDistributionList> ltEmp = lossprocessingService.getReportDL(emailID);
		return ltEmp;
	}
	
	@GetMapping("/getEmailReceipient")
	public List<BatchSponsorDistributionReportRelationship> getBatchSponsorDistributionReportRelationship(){
		List<BatchSponsorDistributionReportRelationship> ltEmp = lossprocessingService.getBatchSponsorDistributionReportRelationship();
		return ltEmp;
	}
	
	
	@GetMapping("/getSponsor")
	public List<SponsorResponse> getSponsorBasedOnCaseReport(){
		List<SponsorResponse> ltEmp = lossprocessingService.getSponsorBasedOnCaseReport();
		return ltEmp;
	}
	

	@RequestMapping(value = "/addDelMailID", method = RequestMethod.POST)
	public CaseManagementResponse saveInsDelMailDistsp(@RequestBody PlBatchReportDistList insDelMailDist) {
		return lossprocessingService.saveInsDelMailDistsp(insDelMailDist);
	}

	@RequestMapping(value = "/getPolicyByPolicy", method = RequestMethod.POST)
	public SponsorPolicyResponse cmgetSponsorPolicysp(@RequestBody SponsorPolicy sponsorPolicy) throws Exception {
		return lossprocessingService.getSponsorPolicysp(sponsorPolicy);
	}
	@RequestMapping(value = "/getHIGPolicyByPolicy", method = RequestMethod.POST)
	public SponsorPolicyResponse cmgetSponsorhigPolicyspsp(@RequestBody SponsorPolicy sponsorPolicy) throws Exception {
		return lossprocessingService.getSponsorhigPolicysp(sponsorPolicy);
	}
	@RequestMapping(value = "/getBenefitDetails", method = RequestMethod.POST)
	public LpGetBenefitDtlsResponse cmLpGetBenefitDtlssp(@RequestBody LpGetBenefitDtlsRequest lpGetBenefitDtlsRequest) throws SQLException {
		return lossprocessingService.cmLpGetBenefitDtlssp(lpGetBenefitDtlsRequest);
	}
	@RequestMapping(value = "/plBenefitInsertLogsp", method = RequestMethod.POST)
	public PlBenefitLogResponse plBenefitInsertLogsp(@RequestBody PlBenefitLog plBenefitLog) throws SQLException {
		return lossprocessingService.plBenefitInsertLogsp(plBenefitLog);
	}
	
	@RequestMapping(value = "/deleteBenefitLog/{id}", method = RequestMethod.DELETE)
	public void deletePlBenefitLog(@PathVariable String id) throws SQLException {
		lossprocessingService.deletePlBenefitLog(id);
	}
	
	//
	@RequestMapping(value = "/getSponsorTax", method = RequestMethod.POST)
	public SponsorTaxListResponse getSponsorTaxListsp() throws Exception {
		return lossprocessingService.getSponsorTaxListsp();
	}

	@GetMapping("/getBenefitDescription/{id}")
	public List<BenefitDescription> getBenefitDescription(@PathVariable String id) throws SQLException{
		List<BenefitDescription> ltEmp = lossprocessingService.getBenefitCode(id);
		//return new ResponseEntity<>(ltEmp, HttpStatus.OK);
		return ltEmp;
		}
	
	@RequestMapping(value = "/getBenefitCorrectionDetails", method = RequestMethod.POST)
	public PlCorrectionResponseLog cmLpGetCorrectionLogDetail(@RequestBody PlCorrectionLog plCorrectionLog) throws SQLException {
		return lossprocessingService.cmLpGetCorrectionLogDetail(plCorrectionLog);
	}
}
