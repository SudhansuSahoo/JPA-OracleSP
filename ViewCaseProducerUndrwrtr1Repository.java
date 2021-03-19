package com.hig.oracleformsmigration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hig.oracleformsmigration.casemanagement.model.ViewCaseProducerUndrwrtr1;

@Repository
public interface ViewCaseProducerUndrwrtr1Repository extends JpaRepository<ViewCaseProducerUndrwrtr1, String>{
	
	@Query(value = "SELECT vndrId,producer,undrwrtr FROM VIEW_CASE_PRODUCER_UNDRWRTR1 e WHERE e.undrwrtr IN (:ids) ORDER BY e.producer", nativeQuery = true)
    List<ViewCaseProducerUndrwrtr1> getProducerBasedonUW(@Param("ids") String ids);

}
