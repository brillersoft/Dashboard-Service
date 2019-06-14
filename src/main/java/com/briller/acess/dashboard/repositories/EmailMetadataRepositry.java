package com.briller.acess.dashboard.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.briller.acess.dto.EmailMetaDataDto;

@Repository
public interface EmailMetadataRepositry extends CrudRepository<EmailMetaDataDto, Integer> {

}
