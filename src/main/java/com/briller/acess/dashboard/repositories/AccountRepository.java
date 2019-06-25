package com.briller.acess.dashboard.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.briller.acess.dto.Account;
@Repository
public interface AccountRepository extends CrudRepository<Account, Integer> {
	@Override
	List<Account> findAll();
	
	 Account findByAccountName(String account);
	 Account findByAccountId(int accountId);
	 
	 
	@Query(nativeQuery =true,value = "SELECT * FROM account WHERE account.account_id IN (:listOfaccountId)")  
	List<Account> getAllClients(@Param("listOfaccountId") List<Integer> listOfaccountId);
	 
	 
	 
}
