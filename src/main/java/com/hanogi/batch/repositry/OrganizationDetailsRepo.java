package com.hanogi.batch.repositry;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hanogi.batch.entity.OrganizationDetails;

public interface OrganizationDetailsRepo extends CrudRepository<OrganizationDetails, Integer> {
	
	@Override
	public List<OrganizationDetails> findAll();

}
