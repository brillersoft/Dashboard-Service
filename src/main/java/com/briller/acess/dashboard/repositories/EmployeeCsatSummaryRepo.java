package com.briller.acess.dashboard.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.briller.acess.dto.EmployeeCsatSummary;

@Repository
public interface EmployeeCsatSummaryRepo extends CrudRepository<EmployeeCsatSummary, Integer> {

	@Query(value = "select * from employee_csat_summary where employee_id=?1", nativeQuery = true)
	List<EmployeeCsatSummary>  getAllEmpById(Integer empId);
	
	List<EmployeeCsatSummary>  findByEmployeeId(Integer empId);

	List<EmployeeCsatSummary> findByAccountId(Integer accountId);
	
	List<EmployeeCsatSummary> findByEmployeeEmail(String empEmail);

	String Distinct_Employee_Query = "select distinct employee_id from employee_csat_summary where account_id=?1";

	@Query(value = Distinct_Employee_Query, nativeQuery = true)
	List<Integer> findDistinctEmployees(int accountId);

	String Distinct_acc_id="select distinct account_id from employee_csat_summary where employee_csat_summary.employee_email=?1";
	
	@Query(value = Distinct_acc_id, nativeQuery = true)
	List<Integer> findDistictAccountId(String email);
	
// @Query( value = "select distinct * from employee_csat_summary e where e.=?1")
// List<EmployeeCsatSummary> getList(Integer accountId);

}
