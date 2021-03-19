package com.hig.oracleformsmigration.repository;

import java.util.List;

import javax.persistence.Column;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hig.oracleformsmigration.lossprocessing.model.PlBatchSponsorReport;

@Repository
public interface PlBatchSponsorReportRepository extends JpaRepository<PlBatchSponsorReport, Long>{

	/*
	 * @Query(value =
	 * "select STTSCD,DSCRPTN from CASE_STATUS_CODE ORDER BY DSCRPTN", nativeQuery =
	 * true) List<PlBatchSponsorReport> getStatusCode();
	 */
	
	@Query(value = "Select RPT_NM, ELECT_MAIL_DSTRIB_LIST, RPT_DESC, RPT_FREQ  from PL_BATCH_SPONSOR_REPORT where BUS_SPNSR_ID = :busspnsrId", nativeQuery = true)
    List<PlBatchSponsorReport> getBasedOnSponsorSelected(@Param("busspnsrId")String busspnsrId);
	
}
