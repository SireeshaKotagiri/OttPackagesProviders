package com.onnet.ott.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.onnet.ott.entity.LookupKeysMapping;

@Repository
public interface LookupKeysMappingRepository extends MongoRepository<LookupKeysMapping, Long> {
	LookupKeysMappingRepository findById(long pId);
}
