package com.briller.acess.dashboard.repositories;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.briller.acess.dto.EmployeeCsatSummary;

@Repository
public interface EmployeeCsatSummaryRepo extends CrudRepository<EmployeeCsatSummary, Integer> {

//	@Query(value = "select * from employee_csat_summary where employee_id=?1", nativeQuery = true)
//	List<EmployeeCsatSummary>  findByEmployeeId(Integer empId);
	
	List<EmployeeCsatSummary>  findByEmployeeId(Integer empId);

	List<EmployeeCsatSummary> findByAccountId(Integer accountId);
	
	List<EmployeeCsatSummary> findByEmployeeEmail(String empEmail);
	
	String totalCsat = "select avg(csat) as avg from employee_csat_summary where employee_csat_summary.employee_id=?1";
	@Query(value = totalCsat, nativeQuery = true)
	public double getAvgCsatScore(int empId);
	
	//for a particular account
	@Query(value ="select avg(csat) as avg from employee_csat_summary where employee_id=?1 and account_id=?2", nativeQuery = true)
	public double getAvgScore(int empId,int accId);

	String Distinct_Employee_Query = "select distinct employee_id from employee_csat_summary where account_id=?1";

	@Query(value = Distinct_Employee_Query, nativeQuery = true)
	List<Integer> findDistinctEmployees(int accountId);
	
	@Query(value ="select account_id,account_name from accounts where account_id=?1", nativeQuery = true)
	Map<Integer,String> getAllClients(int accountId);
	

	String Distinct_acc_id="select distinct account_id from employee_csat_summary where employee_csat_summary.employee_email=?1";
	
	@Query(value = Distinct_acc_id, nativeQuery = true)
	List<Integer> findDistictAccountId(String email);
	

}
