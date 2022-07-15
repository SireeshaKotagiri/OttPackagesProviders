package com.onnet.ott.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.onnet.ott.controller.PackagesController;
import com.onnet.ott.dto.PackageRequest;
import com.onnet.ott.dto.PackageResponse;
import com.onnet.ott.entity.PackageProviderMapping;
import com.onnet.ott.entity.PackagesInfo;
import com.onnet.ott.entity.ProvidersInfo;
import com.onnet.ott.exception.UserNotFoundException;
import com.onnet.ott.repository.PackageProviderMappingRepository;
import com.onnet.ott.repository.PackagesRepository;
import com.onnet.ott.repository.ProvidersRepository;
import com.onnet.ott.service.PackagesInterface;

@Service
public class PackagesService implements PackagesInterface {

	Logger logger = LoggerFactory.getLogger(PackagesController.class);

	@Autowired
	MongoTemplate mongoTemplate;

	@Autowired
	private PackagesRepository packagesRepository;

	@Autowired
	private ProvidersRepository providersRepository;

	@Autowired
	private PackageProviderMappingRepository PackageProviderMappingRepository;

	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;

	@Override
	public PackageResponse save(PackageRequest packages) {
		PackagesInfo packageData = packagesRepository.findById(packages.getPackageId());
		if (ObjectUtils.isEmpty(packageData)) {
			 packageData = new PackagesInfo();
			packageData.setPackageId(packages.getPackageId());
		packages.setPackageId(sequenceGeneratorService.generateSequence(PackagesInfo.SEQUENCE_NAME));
		}
		logger.info("<< request in service persisted package >>", packageData);

		PackagesInfo packageEntity = new PackagesInfo();
		packageEntity = new PackagesInfo((packageData.getPackageId()), packages.getPackageName(),
				packages.getCalculatedPrice(), packages.getSellingPrice(), packages.getPackageStatus(),
				packages.getDeleteFlag(), new Timestamp(System.currentTimeMillis()),
				new Timestamp(System.currentTimeMillis()));

		PackageResponse packageResponse = responsePayload(packageEntity);
		PackageProviderMapping packageProviderMapping = new PackageProviderMapping();

		packagesRepository.save(packageEntity);
		/*
		 * ProvidersInfo providerInfo =
		 * providersRepository.findById(packageEntity.getPackageId()); if
		 * (!ObjectUtils.isEmpty(providerInfo)) {
		 * packageProviderMapping.setProviderId(providerInfo.getProviderId()); }
		 * packageProviderMapping.setPackageId(packageEntity.getPackageId());
		 * packageProviderMapping.setCreatedDate(packageEntity.getCreatedDate());
		 * packageProviderMapping.setUpdatedDate(packageEntity.getUpdatedDate());
		 * PackageProviderMappingRepository.save(packageProviderMapping);
		 * 
		 * List<ProvidersInfo> providerList = new ArrayList<>();
		 * packages.getProvider().forEach(id -> { long providerid = id.getProviderId();
		 * //ProvidersInfo providerEntity = new ProvidersInfo(); });
		 */
		return packageResponse;
	}

	@Override
	public List<PackageResponse> getPackage() {
		List<PackagesInfo> packageEntityList = packagesRepository.findAll();
		List<PackageResponse> responseList = new ArrayList<>();
		for (PackagesInfo packageEntity : packageEntityList) {
			PackageResponse packageResponse = new PackageResponse();
			packageResponse = responsePayload(packageEntity);
			responseList.add(packageResponse);
		}
		return responseList;
	}

	@Override
	public PackageResponse getPackagesById(long pId) {
		PackagesInfo packageentity = packagesRepository.findById(pId);
		if (packageentity == null) {
			throw new UserNotFoundException("id Not Found : " + pId);
		}
		PackageResponse packageResponse = responsePayload(packageentity);
		return packageResponse;
	}

	@Override
	public PackageResponse updatePackage(PackageRequest packages) {
		PackagesInfo packageentity = packagesRepository.findById(packages.getPackageId());
		if (packageentity == null) {
			throw new UserNotFoundException("package Not Found : " + packageentity.getPackageId());
		} else {
			PackageResponse packageResponse = save(packages);
			return packageResponse;
		}
	}

	@Override
	public String deletePackage(long pId) {
		PackagesInfo packagesInfo = packagesRepository.findById(pId);
		if (packagesInfo == null) {
			throw new UserNotFoundException("id Not Found : " + pId);
		}	
		packagesRepository.delete(packagesInfo);
		return "package deleted successfully " + pId;
		
	}

	private PackageResponse responsePayload(PackagesInfo packageEntity) {
		PackageResponse packageResponse = new PackageResponse();
		packageResponse.setPackageId(packageEntity.getPackageId());
		packageResponse.setPackageName(packageEntity.getPackageName());
		packageResponse.setCalculatedPrice(packageEntity.getCalculatedPrice());
		packageResponse.setPackageStatus(packageEntity.getPackageStatus());
		packageResponse.setSellingPrice(packageEntity.getSellingPrice());
		packageResponse.setDeleteFlag(packageEntity.getDeleteFlag());
		packageResponse.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		packageResponse.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
		return packageResponse;

	}

}
