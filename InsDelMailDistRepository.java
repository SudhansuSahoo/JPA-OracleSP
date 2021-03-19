package com.hig.oracleformsmigration.repository;

import java.util.HashMap;
import java.util.List;

import javax.persistence.StoredProcedureQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//import com.hig.oracleformsmigration.model.ErrorDetails;
import com.hig.oracleformsmigration.lossprocessing.model.PlBatchReportDistList;

@Repository
public interface InsDelMailDistRepository extends CrudRepository<PlBatchReportDistList, Long> {

	@Procedure(name = "LP_INS_DEL_MAILDIST")
	HashMap<String, String> saveInsDelMailDistsp(@Param("pmailid") String pmailid,
			@Param("pmaildistribution") String pmaildistribution, @Param("puserid") String puserid,	@Param("paction") String paction);
	/*
	 * String o_return=null; String o_str_auto=null; String o_test_auto=null;
	 * 
	 * try { o_return=usersService.saveQuarantine(send_no, send_qty); //Call the
	 * stored procedure pd_ka_strreportscanx (this name is not defined by the Users
	 * class in the database) StoredProcedureQuery store =
	 * this.entityManager.createNamedStoredProcedureQuery("pd_ka_strreportscanx");
	 * store.setParameter("i_send_no", send_no); store.setParameter("i_send_qty",
	 * send_qty); store.execute(); o_str_auto=(String)
	 * store.getOutputParameterValue("o_str_auto"); o_test_auto=(String)
	 * store.getOutputParameterValue("o_test_auto"); o_return=(String)
	 * store.getOutputParameterValue("o_return"); System.out.println(""+o_return); }
	 * catch (Exception e) { request.setAttribute(LoggerUtils.LOGGER_RETURN,"save"+
	 * send_no+"Receipt of materials to be inspected failed!"); }
	 */
	
	//@Query(value = "CALL LP_INS_DEL_MAILDIST(:pmailid,:pmaildistribution,:puserid,:paction);", nativeQuery = true)
	//ErrorDetails saveInsDelMailDistsp(@Param("pmailid") String pmailid,@Param("pmaildistribution") String pmaildistribution, @Param("puserid") String puserid,	@Param("paction") String paction);
}
