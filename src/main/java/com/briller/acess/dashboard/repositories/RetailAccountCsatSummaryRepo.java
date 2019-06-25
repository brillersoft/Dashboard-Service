package com.briller.acess.dashboard.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.briller.acess.dto.RetailAccountCsatSummary;
@Repository
public interface RetailAccountCsatSummaryRepo extends CrudRepository<RetailAccountCsatSummary, Integer> {

	RetailAccountCsatSummary findByAccountId(int accountId);
}
