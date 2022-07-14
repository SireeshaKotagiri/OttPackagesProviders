package com.onnet.ott.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.onnet.ott.entity.ProvidersInfo;

public interface ProvidersRepository extends MongoRepository<ProvidersInfo, Long> {

	@Query(value = "{ 'providerId' : ?0 }")
	ProvidersInfo findById(long pId);

}
