package com.briller.acess.dashboard.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.briller.acess.dto.EmailHeader;

@Repository
public interface EmailHeaderRepositry extends CrudRepository<EmailHeader, Integer> {

}
