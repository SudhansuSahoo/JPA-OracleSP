/*
 * package com.hig.oracleformsmigration.repository;
 * 
 * import org.springframework.data.jpa.repository.Query; import
 * org.springframework.data.jpa.repository.query.Procedure; import
 * org.springframework.data.repository.CrudRepository; import
 * org.springframework.data.repository.query.Param;
 * 
 * import com.hig.oracleformsmigration.model.Employee;
 * 
 * public interface MyTableRepository extends CrudRepository<Employee, Long> {
 * 
 * @Procedure(name = "employee_prc") String saveEmployeesp(@Param("pid") int
 * id,@Param("pname") String name,@Param("page") int age,@Param("pdept_id") int
 * dept_id);
 * 
 * 
 * @Query(nativeQuery = true, value = "SELECT testfunc(:pname) FROM dual")
 * String callFunction(@Param("pname") String name);
 * 
 * @Query(nativeQuery = true, value = "SELECT getDBDate() FROM dual") String
 * callFunctionToGetDate(); }
 */