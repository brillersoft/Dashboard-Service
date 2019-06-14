package com.briller.acess.dashboard.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.briller.acess.dto.IndividualTone;

@Repository
public interface IndividualToneRepositry extends CrudRepository<IndividualTone, Integer> {

	IndividualTone findByIndividualToneId(int individualToneId);
}
