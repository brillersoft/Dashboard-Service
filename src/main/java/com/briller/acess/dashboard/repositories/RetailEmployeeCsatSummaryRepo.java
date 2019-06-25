package com.briller.acess.dashboard.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.briller.acess.dto.RetailEmployeeCsatSummary;
@Repository
public interface RetailEmployeeCsatSummaryRepo  extends CrudRepository<RetailEmployeeCsatSummary, Integer> {
	List<RetailEmployeeCsatSummary> findByAccountId(Integer accountId);

	List<RetailEmployeeCsatSummary> findByEmployeeEmail(String empEmail);

	String totalCsat = "select avg(csat) as avg from retail_employee_csat_summary where retail_employee_csat_summary.employee_email=?1";
	@Query(value = totalCsat, nativeQuery = true)
	public double getAvgCsatScore(String empEmail);

	// for a particular account
	@Query(value = "select avg(csat) as avg from retail_employee_csat_summary where employee_email=?1 and account_id=?2", nativeQuery = true)
	public double getAvgScoreOfAccount(String email, int accId);

	String Distinct_Employee_Query = "select distinct employee_email from retail_employee_csat_summary where account_id=?1";
	@Query(value = Distinct_Employee_Query, nativeQuery = true)
	List<String> findDistinctEmployees(int accountId);

	String Distinct_acc_id = "select distinct account_id from retail_employee_csat_summary where retail_employee_csat_summary.employee_email=?1";
	@Query(value = Distinct_acc_id, nativeQuery = true)
	List<Integer> findDistictAccountId(String email);
}
