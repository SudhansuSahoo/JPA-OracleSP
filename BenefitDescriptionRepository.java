package com.hig.oracleformsmigration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hig.oracleformsmigration.lossprocessing.model.BenefitDescription;
//import com.hig.oracleformsmigration.model.Employee;
import com.hig.oracleformsmigration.lossprocessing.model.PlBatchSponsorReport;
import com.hig.oracleformsmigration.casemanagement.model.ViewHigRep;

@Repository
public interface BenefitDescriptionRepository extends JpaRepository<BenefitDescription, String>{
	
	@Query(value = "SELECT BNFTCD, DSCRPTN, TXBLBNFTIND, CVRGCTGRYCD, LSSEXPRNCCD, SBCLMTYPCD, MJRLNCD, LSSRPRTNGGRPNGCD FROM PL_BENEFIT_CODE WHERE BNFTCD = :bnftcd", nativeQuery = true)
	BenefitDescription getBenefitCode(@Param("bnftcd")String bnftcd); 
	
	//@Query(value = "Select RPT_NM, ELECT_MAIL_DSTRIB_LIST, RPT_DESC, RPT_FREQ  from PL_BATCH_SPONSOR_REPORT where BUS_SPNSR_ID = :busspnsrId", nativeQuery = true)
    //List<PlBatchSponsorReport> getBasedOnSponsorSelected(@Param("busspnsrId")String busspnsrId);
	
	//@Query(value = "SELECT ID,NAME, AGE, DEPT_ID FROM Employee where id = :id", nativeQuery = true)
    //List<Employee> getSalesRepresentive(@Param("id")int id);
}
