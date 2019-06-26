package com.briller.acess.dashboard.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.briller.acess.dto.RetailAccountCsatSummary;
@Repository
public interface RetailAccountCsatSummaryRepo extends CrudRepository<RetailAccountCsatSummary, Integer> {

	RetailAccountCsatSummary findByAccountId(int accountId);
	
	@Query(nativeQuery =true,value = "select avg(escalations) from retail_account_csat_summary where account_id=?1") 
	int getAvgEscalations(int acc_id);

	@Query(nativeQuery =true,value = "select avg(total_interactions) from retail_account_csat_summary where account_id=?1") 
	int getAvgTotalInteractions(int acc_id);
	
	@Query(nativeQuery =true,value = "select avg(negative_interactions) from retail_account_csat_summary where account_id=?1") 
	int getAvgNegativeInteractions(int acc_id);
	
	@Query(nativeQuery =true,value = "select avg(csat) from retail_account_csat_summary where account_id=?1") 
	int getAvgCsat(int acc_id);
}
