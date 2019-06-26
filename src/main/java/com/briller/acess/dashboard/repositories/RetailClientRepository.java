package com.briller.acess.dashboard.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.briller.acess.dto.RetailClient;

public interface RetailClientRepository extends CrudRepository<RetailClient, Integer> {

	@Override
	List<RetailClient> findAll();

	RetailClient findByDomainName(String account);

	RetailClient findByAccountId(int accountId);

	@Query(nativeQuery = true, value = "SELECT * FROM retail_client WHERE account_id IN (:listOfaccountId)")
	List<RetailClient> getAllClients(@Param("listOfaccountId") List<Integer> listOfaccountId);

}
