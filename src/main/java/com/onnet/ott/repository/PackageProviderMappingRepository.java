package com.onnet.ott.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.onnet.ott.entity.PackageProviderMapping;

@Repository
public interface PackageProviderMappingRepository extends MongoRepository<PackageProviderMapping, Long> {

}
