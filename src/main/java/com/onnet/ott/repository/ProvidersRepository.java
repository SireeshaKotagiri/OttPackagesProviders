package com.onnet.ott.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.onnet.ott.entity.ProvidersInfo;

@Repository
public interface ProvidersRepository extends MongoRepository<ProvidersInfo, Long> {

	 @Query("{ 'providerId' : ?0 }")
	ProvidersInfo findById(long pId);

	 @Query("{ 'providerId' : ?0 }")
	void deleteByProviderId(long providerId);


}
