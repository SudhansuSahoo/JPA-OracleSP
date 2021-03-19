package com.hig.oracleformsmigration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hig.oracleformsmigration.lossprocessing.model.PlBatchReportDistributionList;

@Repository
public interface PlBatchReportDistListRepository extends JpaRepository<PlBatchReportDistributionList, Long>{
	
	@Query(value = "select EMLDSTNTN, USRNM, EMLTYPCD, PRCSSDT, PRCSRID from PL_BATCH_REPORT_DIST_LIST where PL_BATCH_REPORT_DIST_LIST.emldstntn like %:emailDistribution%", nativeQuery = true)
    List<PlBatchReportDistributionList> getReportDL(@Param("emailDistribution")String emailDistribution);

	/*
	 * @Modifying
	 * 
	 * @Query(value =
	 * "DELETE FROM PL_BATCH_REPORT_DIST_LIST where USRNM = :usrnm and EMLDSTNTN =:emldstntn"
	 * , nativeQuery = true) public void deleteByUserNameDL(@Param("usrnm") String
	 * usrnm,@Param("emldstntn") String emldstntn);
	 */
}
