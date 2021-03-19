/*
 * package com.hig.oracleformsmigration.repository;
 * 
 * import java.math.BigDecimal; import java.util.List;
 * 
 * import org.springframework.data.jpa.repository.JpaRepository; import
 * org.springframework.data.jpa.repository.Modifying; import
 * org.springframework.data.jpa.repository.Query; import
 * org.springframework.data.jpa.repository.query.Procedure; import
 * org.springframework.data.repository.query.Param; import
 * org.springframework.stereotype.Repository; import
 * org.springframework.transaction.annotation.Transactional;
 * 
 * import com.hig.oracleformsmigration.casemanagement.model.
 * CaseStatUnderWriterMaintRelationshipEntityResponse;
 * 
 * import com.hig.oracleformsmigration.casemanagement.model.ViewGloMod; import
 * com.hig.oracleformsmigration.casemanagement.model.ViewHigRep;
 * 
 * @Repository public interface MigrationRepository extends
 * JpaRepository<Employee, Long>{
 * 
 * //@Query(value = "SELECT ID,NAME, AGE, DEPT_ID FROM Employee where id = :id",
 * nativeQuery = true) //List<Employee> getSalesRepresentive(@Param("id")int
 * id);
 * 
 * //@Query(value =
 * "SELECT DISTINCT ID, NAME,AGE, DEPT_ID FROM Employee WHERE id IN (:ids) ORDER BY NAME"
 * , nativeQuery = true) //List<Employee>
 * getSalesRepsOrderbyName(@Param("ids")List<Integer> ids);
 * 
 * //@
 * Query("SELECT t.ID, t.NAME FROM Employee t WHERE t.NAME = :names order by t.NAME"
 * )
 * 
 * //@Query(value = "SELECT ID,NAME,AGE, DEPT_ID FROM Employee where id != :id",
 * nativeQuery = true) //List<Employee> getSalesRepsIDNotEquals(@Param("id")int
 * id);
 * 
 * 
 * //@Query(value =
 * "SELECT new com.hig.oracleformsmigration.model.ViewGloMod2(c.optnId,c.caseId,c.vndrId, c.slsoffccd, c.salesrep,c.slsrepId,c.svcrepId,c.casename,c.serviceteam, "
 * // +
 * "c.salesoffice, c.producer, c.servicerep) FROM VIEW_GLO_MOD1 c where c.salesrep = :salesrep ORDER BY CASENAME"
 * , nativeQuery = true)
 * 
 * //@Query(value = "SELECT ID,NAME,AGE, DEPT_ID FROM Employee where id = :id",
 * nativeQuery = true) //public Employee findById(@Param("id") int id);
 * 
 * //@Modifying //@Query(value = "DELETE FROM Employee where id = :id",
 * nativeQuery = true) //public void deleteById(@Param("id") int id);
 * 
 * 
 * //Working on below query //@Query(value =
 * "SELECT e.id,e.name,e.age,e.dept FROM employee e, department d on e.dept=d.dept"
 * ,nativeQuery = true) //public List<EmployeeDeptResponse>
 * getFromJoiningDeptEmployeebyDept();
 * 
 * //@Query(value =
 * "SELECT new com.hig.oracleformsmigration.model.EmployeeDeptResponse(e.id,e.name,e.age,e.dept,d.name) FROM employee e where e.dept= d"
 * ) //@
 * Query("select new com.hig.oracleformsmigration.model.EmployeeDeptResponse(c.id, c.name, c.age, c.dept_id, p.dept) from Employee c INNER JOIN c.department p"
 * ) //@
 * Query("select new com.jpa.springjpahibernateexample.model.OrderResponse(c.name,p.productName) from Customer c JOIN c.products p"
 * ) //public List<EmployeeDeptResponse> getFromJoiningDeptEmployeebyDept();
 * 
 * //@
 * Query("select new com.hig.oracleformsmigration.model.CaseStatUnderWriterMaintRelationshipEntityResponse(p.statUnderwriter, c.name) from ViewCmUnderwriterMaint c INNER JOIN c.CaseStatUnderwriter p"
 * ) //public List<CaseStatUnderWriterMaintRelationshipEntityResponse>
 * getunderwritermaintenanceInfo();
 * 
 * 
 * 
 * @Query(value =
 * "SELECT DISTINCT REPID, NAME FROM Employee WHERE id IN (:ids) ORDER BY NAME",
 * nativeQuery = true) List<ViewHigRep> getViewHigRep(@Param("ids")List<String>
 * ids);
 * 
 * }
 */