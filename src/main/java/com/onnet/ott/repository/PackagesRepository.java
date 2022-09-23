package com.onnet.ott.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.onnet.ott.entity.PackagesInfo;

public interface PackagesRepository extends MongoRepository<PackagesInfo, Long> {
	
	 @Query(value = "{ 'packageId' : ?0 }")
		
		PackagesInfo findById(long pId);   
	 
}
