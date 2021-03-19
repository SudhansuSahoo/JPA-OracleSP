package com.hig.oracleformsmigration.lossprocessing.service;


import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import java.util.List;



import javax.persistence.ParameterMode;

import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.hig.oracleformsmigration.lossprocessing.model.BatchSponsorDistributionReportRelationship;
import com.hig.oracleformsmigration.lossprocessing.model.BenefitDescription;
import com.hig.oracleformsmigration.repository.BenefitDescriptionDetailsRepository;

import com.hig.oracleformsmigration.lossprocessing.model.CaseManagementResponse;
import com.hig.oracleformsmigration.lossprocessing.model.LpGetBenefitDtlsRequest;
import com.hig.oracleformsmigration.lossprocessing.model.LpGetBenefitDtlsResponse;
import com.hig.oracleformsmigration.lossprocessing.model.PlBatchReportDistList;

import com.hig.oracleformsmigration.lossprocessing.model.PlBatchReportDistributionList;
import com.hig.oracleformsmigration.lossprocessing.model.PlBatchSponsorReport;
import com.hig.oracleformsmigration.lossprocessing.model.PlBenefitLog;
import com.hig.oracleformsmigration.lossprocessing.model.PlBenefitLogResponse;
import com.hig.oracleformsmigration.lossprocessing.model.PlCorrectionLog;
import com.hig.oracleformsmigration.lossprocessing.model.PlCorrectionResponseLog;
import com.hig.oracleformsmigration.lossprocessing.model.PolicyDetails;

import com.hig.oracleformsmigration.lossprocessing.model.Sponsor;
import com.hig.oracleformsmigration.lossprocessing.model.SponsorPolicy;
import com.hig.oracleformsmigration.lossprocessing.model.SponsorPolicyResponse;
import com.hig.oracleformsmigration.lossprocessing.model.SponsorResponse;
import com.hig.oracleformsmigration.lossprocessing.model.SponsorTaxListResponse;

import com.hig.oracleformsmigration.repository.BatchSponsorDistributionReportRelationshipRepository;

import com.hig.oracleformsmigration.repository.CaseManagementRepository;
import com.hig.oracleformsmigration.repository.CaseReportRequestRepository;
import com.hig.oracleformsmigration.repository.CaseStatUnderWriterMainRelationshipRepository;
import com.hig.oracleformsmigration.repository.CaseStatusCodeRepository;


import com.hig.oracleformsmigration.repository.PlBatchReportDistListRepository;
import com.hig.oracleformsmigration.repository.PlBatchSponsorReportRepository;

import com.hig.oracleformsmigration.repository.SponsorRepository;

import com.hig.oracleformsmigration.repository.ViewPolicyNumberUndrwrtrRepository;


import com.hig.oracleformsmigration.repository.PLBenefitLogDeleteRepository;
import com.hig.oracleformsmigration.util.GetConnection;
import com.hig.oracleformsmigration.util.GetEntityManager;

import oracle.jdbc.OracleTypes;


@Service
public class LossProcessingService  {

	
	@Autowired
	private GetEntityManager getEntityManager;
	@Autowired
	private CaseManagementRepository caseManagementRepository;
	@Autowired
	private CaseStatUnderWriterMainRelationshipRepository caseStatUnderWriterMainRelationshipRepository;
	@Autowired
	private CaseStatusCodeRepository caseStatusCodeRepository;
	@Autowired
	private ViewPolicyNumberUndrwrtrRepository viewPolicyNumberUndrwrtrRepository;
	@Autowired
	private SponsorRepository sponsorRepository;
	@Autowired
	private PlBatchSponsorReportRepository plBatchSponsorReportRepository;
	@Autowired
	private PlBatchReportDistListRepository plBatchReportDistListRepository;
	@Autowired
	private BatchSponsorDistributionReportRelationshipRepository batchSponsorDistributionReportRelationshipRepository;
	@Autowired
	private CaseReportRequestRepository caseReportRequestRepository;
	@Autowired 
	private PLBenefitLogDeleteRepository PLBenefitLogDeleteRepository;
	@Autowired
	private BenefitDescriptionDetailsRepository benefitDescriptionDetailsRepository;
	
	//@Transactional
	//public CaseManagementData saveRelationship(CaseManagementData caseManagementData) {
	//	CaseManagementData caseManagementDataResponse = caseManagementRepository.save(caseManagementData);
	//	return caseManagementDataResponse;
	//}
	
	//public List<CaseStatUnderWriterMaintRelationshipEntityResponse> getJoinInformation(){
	//	List<CaseStatUnderWriterMaintRelationshipEntityResponse> ltEmp = caseStatUnderWriterMainRelationshipRepository.getJoinInformation();
	//	return ltEmp;
	//}
	
	//public List<CaseStatusCode> getStatusCode(){
	//	List<CaseStatusCode> ltEmp = caseStatusCodeRepository.getStatusCode();
	//	return ltEmp;
	//}
	//public List<ViewPolicyNumberUndrwrtr> getViewPolicyNumber(){
	//	List<ViewPolicyNumberUndrwrtr> ltEmp = viewPolicyNumberUndrwrtrRepository.getViewPolicyNumber();
	//	return ltEmp;
	//}
	
	public List<Sponsor> getSponsor(){
		List<Sponsor> ltEmp = sponsorRepository.getSponsor();
		return ltEmp;
	}
	public List<PlBatchSponsorReport> getBasedOnSponsorSelected(String sponsorID){
		List<PlBatchSponsorReport> ltEmp = plBatchSponsorReportRepository.getBasedOnSponsorSelected(sponsorID);
		return ltEmp;
	}
	public List<PlBatchReportDistributionList> getReportDL(String emailId){
		List<PlBatchReportDistributionList> ltEmp = plBatchReportDistListRepository.getReportDL(emailId);
		return ltEmp;
	}
	public List<BatchSponsorDistributionReportRelationship> getBatchSponsorDistributionReportRelationship(){
		List<BatchSponsorDistributionReportRelationship> ltEmp = batchSponsorDistributionReportRelationshipRepository.getBatchSponsorDistributionReportRelationship();
		return ltEmp;
	}
	
	public List<SponsorResponse> getSponsorBasedOnCaseReport(){
		List<SponsorResponse> ltEmp = caseReportRequestRepository.getSponsorBasedOnCaseReport();
		return ltEmp;
	}

	@Transactional
	public CaseManagementResponse saveInsDelMailDistsp(PlBatchReportDistList insDelMailDist) {
		
		CaseManagementResponse respMessage = new CaseManagementResponse();
		StoredProcedureQuery storedProcedure = getEntityManager.fetchEntityManager().createStoredProcedureQuery("LP_INS_DEL_MAILDIST_1");
		System.out.println("storedProcedure>>>" +storedProcedure);
        // set parameters
        storedProcedure.registerStoredProcedureParameter("pmailid", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("pmaildistribution", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("puserid", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("paction", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("errorcode", Integer.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("errormessage", String.class, ParameterMode.OUT);
        storedProcedure.setParameter("pmailid", insDelMailDist.getPmailid());//EMLDSTNTN//pmailid
        storedProcedure.setParameter("pmaildistribution", insDelMailDist.getPmaildistribution());//USRNM//pmaildistribution
        storedProcedure.setParameter("puserid", insDelMailDist.getPuserid());//PRCSRID//puserid
        storedProcedure.setParameter("paction", insDelMailDist.getPaction());//EMLTYPCD//paction
        // execute SP
        storedProcedure.execute();
		respMessage.setStatusCode(storedProcedure.getOutputParameterValue("errorcode").toString());
		System.out.println("errorcode" +storedProcedure.getOutputParameterValue("errorcode"));
		if (insDelMailDist.getPaction().equals("I")) {
			respMessage.setMessage(storedProcedure.getOutputParameterValue("errormessage").toString());
			}
		else {
			respMessage.setMessage(storedProcedure.getOutputParameterValue("errormessage").toString());
		}
		
		System.out.println("15");
		return respMessage;
	}
	

	public LpGetBenefitDtlsResponse cmLpGetBenefitDtlssp(LpGetBenefitDtlsRequest lpGetBenefitDtlsRequest) {
		LpGetBenefitDtlsResponse respMessage = new LpGetBenefitDtlsResponse();
		StoredProcedureQuery storedProcedure = getEntityManager.fetchEntityManager().createStoredProcedureQuery("LP_GET_BENEFIT_DTLS");
		System.out.println("storedProcedure>>>" +storedProcedure);
		// set parameters
		
        storedProcedure.registerStoredProcedureParameter("ppolicyno", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("ppolicynotype", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("pcheckno", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("peftno", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("psptxnno", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("pcheckamt", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("psponsorid", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("psponsorname", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("ppolicyholdername", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("pinsuredname", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("pinsuredssn", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("pBNFTCD1", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("pBNFTAMT1", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("BNFTDSC1", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("pBNFTCD2", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("pBNFTAMT2", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("BNFTDSC2", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("pBNFTCD3", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("pBNFTAMT3", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("BNFTDSC3", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("pBNFTCD4", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("pBNFTAMT4", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("BNFTDSC4", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("pBNFTCD5", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("pBNFTAMT5", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("BNFTDSC5", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("pBNFTCD6", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("pBNFTAMT6", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("BNFTDSC6", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("pBNFTCD7", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("pBNFTAMT7", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("BNFTDSC7", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("pBNFTCD8", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("pBNFTAMT8", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("BNFTDSC8", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("errorcode", String.class, ParameterMode.OUT);
        storedProcedure.registerStoredProcedureParameter("errormessage", String.class, ParameterMode.OUT);
       
        storedProcedure.setParameter("ppolicyno", lpGetBenefitDtlsRequest.getPpolicyno());
        storedProcedure.setParameter("ppolicynotype", lpGetBenefitDtlsRequest.getPpolicynotype());
        storedProcedure.setParameter("pcheckno", lpGetBenefitDtlsRequest.getPcheckno());
        storedProcedure.setParameter("peftno", lpGetBenefitDtlsRequest.getPeftno());
        storedProcedure.setParameter("psptxnno", lpGetBenefitDtlsRequest.getPsptxnno());
        // execute SP
        storedProcedure.execute();
        //respMessage.setMessage(storedProcedure.getOutputParameterValue("errorcode").toString());
        
        //respMessage.setMessage(storedProcedure.getOutputParameterValue("errormessage").toString());
        
        return respMessage;
	}
	
	
	
	public SponsorPolicyResponse getSponsorPolicysp(SponsorPolicy sponsorPolicy) throws SQLException {
		SponsorPolicyResponse respMessage = new SponsorPolicyResponse();
        	
		try {
			Connection con = GetConnection.getDBConnection();
			//Create Callable Statement
			CallableStatement cs = con.prepareCall("call LP_GET_REPORT_POLICYNO(?,?,?,?,?)");
			//cs.registerOutParameter(12, OracleTypes.CURSOR);
			//Set the values to params
			cs.setString(1, sponsorPolicy.getpSponsor());
			cs.setString(2, sponsorPolicy.getpMode());
			cs.registerOutParameter(3, OracleTypes.CURSOR);
			cs.registerOutParameter(4, java.sql.Types.VARCHAR);
			cs.registerOutParameter(5, java.sql.Types.VARCHAR);
			cs.execute();
			//respMessage.setMessage(String.valueOf(cs.getInt("errorcode")));
	        //respMessage.setStatusCode(cs.getString("errormessage"));
			
			Object obj = cs.getObject(3);
			ResultSet rs = (ResultSet)obj;
			
			while (rs.next()) {
				System.out.println(rs.getString(1));//prvtlblplcynbr m,prvtlblplcynbr n
				System.out.println(rs.getString(2));
			}
			System.out.println("Print Resultset>>>"+rs.getFetchSize());
			rs.close();
			cs.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
			
		
        return respMessage;
	}
	public SponsorPolicyResponse getSponsorhigPolicysp(SponsorPolicy sponsorPolicy) throws SQLException {
		SponsorPolicyResponse respMessage = new SponsorPolicyResponse();
		try {
			Connection con = GetConnection.getDBConnection();
		
			//Create Callable Statement
			CallableStatement cs = con.prepareCall("call LP_GET_REPORT_HIGPOLICYNO(?,?,?,?,?)");
			//cs.registerOutParameter(12, OracleTypes.CURSOR);
			//Set the values to params
			cs.setString(1, sponsorPolicy.getpSponsor());
			cs.setString(2, sponsorPolicy.getpMode());
			cs.registerOutParameter(3, OracleTypes.CURSOR);
			cs.registerOutParameter(4, java.sql.Types.VARCHAR);
			cs.registerOutParameter(5, java.sql.Types.VARCHAR);
			cs.execute();GetConnection.closeDBConnection(con);
			//respMessage.setMessage(String.valueOf(cs.getInt("errorcode")));
	        //respMessage.setStatusCode(cs.getString("errormessage"));
			
			Object obj = cs.getObject(3);
			ResultSet rs = (ResultSet)obj;
			
			while (rs.next()) {
				System.out.println(rs.getString(1));//prvtlblplcynbr m,prvtlblplcynbr n
				System.out.println(rs.getString(2));
			}
			
			rs.close();
			cs.close();
			GetConnection.closeDBConnection(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
        return respMessage;
	}
	
	public PlBenefitLogResponse plBenefitInsertLogsp(PlBenefitLog plBenefitLog) throws SQLException {
		PlBenefitLogResponse respMessage = new PlBenefitLogResponse();
        
		try {
			Connection con = GetConnection.getDBConnection();
			//Create Callable Statement
			CallableStatement cs = con.prepareCall("call LP_insertBenefitLog(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			//cs.registerOutParameter(12, OracleTypes.CURSOR);
			//Set the values to params
			cs.setString(1, plBenefitLog.getPpolicyno());
			cs.setString(2, plBenefitLog.getPpolicynotype());
			cs.setString(3, plBenefitLog.getPcheckno());
			cs.setString(4, plBenefitLog.getPeftno());
			cs.setString(5, plBenefitLog.getPsptxnno());
			cs.setInt(6, plBenefitLog.getPcheckamt());
			cs.setString(7, plBenefitLog.getPsponsorid());
			cs.setString(8, plBenefitLog.getPsponsorname());
			cs.setString(9, plBenefitLog.getPpolicyholdername());
			cs.setString(10, plBenefitLog.getPinsuredname());
			cs.setString(11, plBenefitLog.getPinsuredssn());
			cs.setString(12, plBenefitLog.getpBNFTCD1());
			cs.setInt(13, plBenefitLog.getpBNFTAMT1());
			cs.setString(14, plBenefitLog.getBNFTDSC1());
			cs.setString(15, plBenefitLog.getpBNFTCD2());
			cs.setInt(16, plBenefitLog.getpBNFTAMT2());
			cs.setString(17, plBenefitLog.getBNFTDSC2());
			cs.setString(18, plBenefitLog.getpBNFTCD3());
			cs.setInt(19, plBenefitLog.getpBNFTAMT3());
			cs.setString(20, plBenefitLog.getBNFTDSC3());
			cs.setString(21, plBenefitLog.getpBNFTCD4());
			cs.setInt(22, plBenefitLog.getpBNFTAMT4());
			cs.setString(23, plBenefitLog.getBNFTDSC4());
			cs.setString(24, plBenefitLog.getpBNFTCD5());
			cs.setInt(25, plBenefitLog.getpBNFTAMT5());
			cs.setString(26, plBenefitLog.getBNFTDSC5());
			cs.setString(27, plBenefitLog.getpBNFTCD6());
			cs.setInt(28, plBenefitLog.getpBNFTAMT6());
			cs.setString(29, plBenefitLog.getBNFTDSC6());
			cs.setString(30, plBenefitLog.getpBNFTCD7());
			cs.setInt(31, plBenefitLog.getpBNFTAMT7());
			cs.setString(32, plBenefitLog.getBNFTDSC7());
			cs.setString(33, plBenefitLog.getpBNFTCD8());
			cs.setInt(34, plBenefitLog.getpBNFTAMT8());
			cs.setString(35, plBenefitLog.getBNFTDSC8());
			cs.setString(36, plBenefitLog.getPuserid());
			
			cs.registerOutParameter(37, java.sql.Types.VARCHAR);
			cs.registerOutParameter(38, java.sql.Types.VARCHAR);
			cs.registerOutParameter(39, java.sql.Types.VARCHAR);
			
			cs.execute();
			
			respMessage.setPlogid(cs.getObject(37).toString());
			respMessage.setErrorcode(cs.getObject(38).toString());
			//respMessage.setSage(cs.getObject(39).toString());//data is not returning
	        
	        //respMessage.setMessage(storedProcedure.getOutputParameterValue("errormessage").toString());
			//rs.close();
			cs.close();
			GetConnection.closeDBConnection(con);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return respMessage;
	}
	
	public PlCorrectionResponseLog cmLpGetCorrectionLogDetail(PlCorrectionLog plCorrectionLog) throws SQLException {
		PlCorrectionResponseLog respMessage = new PlCorrectionResponseLog();
		PolicyDetails policyDetailsInternal = new PolicyDetails();
        
		try {
			Connection con = GetConnection.getDBConnection();
			//Create Callable Statement
			CallableStatement cs = con.prepareCall("call LP_GET_CORRECTIONLOG_DTLS(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			//cs.registerOutParameter(12, OracleTypes.CURSOR);
			//Set the values to params
			cs.setString(1, plCorrectionLog.getPlogid());
			cs.setString(2, plCorrectionLog.getPpolicyno());
			cs.setString(3, plCorrectionLog.getPpolicynotype());
			cs.setString(4, plCorrectionLog.getPcheckno());
			cs.setString(5, plCorrectionLog.getPeftno());
			cs.setString(6, plCorrectionLog.getPsptxnno());
			
			cs.registerOutParameter(7, java.sql.Types.INTEGER);
			cs.registerOutParameter(8, java.sql.Types.VARCHAR);
			cs.registerOutParameter(9, java.sql.Types.VARCHAR);
			cs.registerOutParameter(10, java.sql.Types.VARCHAR);
			cs.registerOutParameter(11, java.sql.Types.VARCHAR);
			cs.registerOutParameter(12, java.sql.Types.VARCHAR);
			
			cs.registerOutParameter(13, OracleTypes.CURSOR);
			
			cs.registerOutParameter(14, java.sql.Types.VARCHAR);
			cs.registerOutParameter(15, java.sql.Types.VARCHAR);			
			
			
			cs.execute();
			
			respMessage.setPcheckamt(cs.getInt(7));
			respMessage.setPsponsorid(cs.getString(8));
			respMessage.setPsponsorname(cs.getString(9));
			respMessage.setPpolicyholdername(cs.getString(10));
			respMessage.setPinsuredname(cs.getString(11));
			respMessage.setPinsuredssn(cs.getString(12));
			
			Object obj = cs.getObject(13);
			ResultSet rs = (ResultSet)obj;
					
			while (rs.next()) {
				//desc.add(rs.getString(1));
				policyDetailsInternal.setLOGID(rs.getString(1));
				policyDetailsInternal.setPLCYNBR(rs.getString(2));
				policyDetailsInternal.setPLCYSYMBLTYP(rs.getString(3));
				policyDetailsInternal.setCHCKNBR(rs.getString(4));
				policyDetailsInternal.setBACISEFTID(rs.getString(5));
				policyDetailsInternal.setBNFTCD1(rs.getString(6));
				policyDetailsInternal.setBNFTAMT1(rs.getString(7));
				policyDetailsInternal.setBNFTCD2(rs.getString(8));
				policyDetailsInternal.setBNFTAMT2(rs.getString(9));
				policyDetailsInternal.setBNFTCD3(rs.getString(10));
				policyDetailsInternal.setBNFTAMT3(rs.getString(11));
				policyDetailsInternal.setBNFTCD4(rs.getString(12));
				policyDetailsInternal.setBNFTAMT4(rs.getString(13));
				policyDetailsInternal.setBNFTCD5(rs.getString(14));
				policyDetailsInternal.setBNFTAMT5(rs.getString(15));
				policyDetailsInternal.setBNFTCD6(rs.getString(16));
				policyDetailsInternal.setBNFTAMT6(rs.getString(17));
				policyDetailsInternal.setBNFTCD7(rs.getString(18));
				policyDetailsInternal.setBNFTAMT7(rs.getString(19));
				policyDetailsInternal.setBNFTCD8(rs.getString(20));
				policyDetailsInternal.setBNFTAMT8(rs.getString(21));
				policyDetailsInternal.setPRCSRID(rs.getString(22));
				policyDetailsInternal.setPRCSSDTTM(rs.getString(23));
				policyDetailsInternal.setSPNSRID(rs.getString(24));
				policyDetailsInternal.setUPDTIND(rs.getString(25));
			}
			respMessage.setPolicyDetails(policyDetailsInternal);;
			respMessage.setErrorCode(cs.getObject(14).toString());
			//respMessage.setErrorMessage(cs.getObject(15).toString());
			
			//respMessage.setSage(cs.getObject(39).toString());//data is not returning
	        
	        //respMessage.setMessage(storedProcedure.getOutputParameterValue("errormessage").toString());
			//rs.close();
			cs.close();
			GetConnection.closeDBConnection(con);
		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return respMessage;
		
	}

	@Transactional
	public void deletePlBenefitLog(String id) {
		PLBenefitLogDeleteRepository.deleteById(id);
	}
	public SponsorTaxListResponse getSponsorTaxListsp() throws Exception {
		SponsorTaxListResponse respMessage = new SponsorTaxListResponse();
		
		List<String> desc = new ArrayList<String>();
        
		try {
			//Connection con = DriverManager.getConnection("jdbc:oracle:thin:@oramigr.cy4nbk6ruiaf.us-west-2.rds.amazonaws.com:1521:oramigr","admin","BigDataAnalytics6");
			Connection con = GetConnection.getDBConnection();
			//Create Callable Statement
			CallableStatement cs = con.prepareCall("call LP_GET_SPONSORSTAXLIST(?,?,?)");
			//Set the values to params
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.registerOutParameter(2, java.sql.Types.VARCHAR);
			cs.registerOutParameter(3, java.sql.Types.VARCHAR);
			
			cs.execute();
			
			Object obj = cs.getObject(1);
			ResultSet rs = (ResultSet)obj;
			
			respMessage.setErrorCode(cs.getObject(2).toString());
			//respMessage.setErrorMessage(cs.getObject(3).toString());
			while (rs.next()) {
				desc.add(rs.getString(1));
			}
			respMessage.setDesription(desc);
			
			rs.close();
			cs.close();
			GetConnection.closeDBConnection(con);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return respMessage;
	}
	
	
	@Transactional
	public List<BenefitDescription> getBenefitCode(String id){
		System.out.println("id>>" +id);
		List<BenefitDescription> ltEmp = benefitDescriptionDetailsRepository.getBenefitCode(id);
		return ltEmp;
	}
	
}
