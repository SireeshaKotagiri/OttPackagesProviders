package com.onnet.ott.service.impl;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.onnet.ott.controller.ProvidersController;
import com.onnet.ott.dto.ProviderRequest;
import com.onnet.ott.dto.ProviderResponse;
import com.onnet.ott.entity.LookupKeysMapping;
import com.onnet.ott.entity.PackageProviderMapping;
import com.onnet.ott.entity.PackagesInfo;
import com.onnet.ott.entity.ProvidersInfo;
import com.onnet.ott.exception.UserAlreadyExistException;
import com.onnet.ott.exception.UserNotFoundException;
import com.onnet.ott.repository.LookupKeysMappingRepository;
import com.onnet.ott.repository.PackageProviderMappingRepository;
import com.onnet.ott.repository.PackagesRepository;
import com.onnet.ott.repository.ProvidersRepository;
import com.onnet.ott.service.ProvidersInterface;

@Service
public class ProvidersService implements ProvidersInterface {

	Logger logger = LoggerFactory.getLogger(ProvidersController.class);

	@Autowired
	MongoTemplate mongoTemplate;

	@Autowired
	private ProvidersRepository providersRepository;

	@Autowired
	private LookupKeysMappingRepository lookupKeysMappingRepository;

	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;

	@Autowired
	private PackageProviderMappingRepository packageProviderMappingRepository;

	@Autowired
	private PackagesRepository packageRepository;

	@Override
	public ProviderResponse save(ProviderRequest provider) {

		ProvidersInfo providerData = providersRepository.findById(provider.getProviderId());
		if (ObjectUtils.isEmpty(providerData)) {
			providerData = new ProvidersInfo();
			providerData.setProviderId(sequenceGeneratorService.generateSequence(ProvidersInfo.SEQUENCE_NAME));
		}
		logger.info("<< request in service persisted package >>", providerData);

		ProvidersInfo providerEntity = new ProvidersInfo((provider.getProviderId()), provider.getProviderName(),
				provider.getProvideTier(), provider.getConcurrentViews(), provider.getOfferedPrice(),
				provider.getEnduserPrice(), provider.getProviderStatus(), provider.getStagingKey(),
				provider.getProductionKey(), provider.getProviderEmail(), provider.getProviderPhone(),
				provider.getApi_documentPath(), provider.getLogoPath(), provider.getDeleteFlag(),
				new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()),
				new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()));

		ProviderResponse packageResponse = responsePayload(providerEntity);
		providersRepository.save(providerEntity);
		PackagesInfo packagesInfo = packageRepository.findById(providerEntity.getProviderId());
		PackageProviderMapping packageProviderMapping = new PackageProviderMapping();
		if (!ObjectUtils.isEmpty(packagesInfo)) {
			packageProviderMapping.setPackageId(packagesInfo.getPackageId());
		}
		packageProviderMapping.setProviderId(providerEntity.getProviderId());
		packageProviderMapping.setCreatedDate(providerEntity.getCreatedDate());
		packageProviderMapping.setUpdatedDate(providerEntity.getUpdatedDate());
		packageProviderMappingRepository.save(packageProviderMapping);
		return packageResponse;

	}

	@Override
	public List<ProviderResponse> getProvider() {
		List<ProvidersInfo> packageEntityList = providersRepository.findAll();
		List<ProviderResponse> responseList = new ArrayList<>();
		for (ProvidersInfo packageEntity : packageEntityList) {
			ProviderResponse packageResponse = new ProviderResponse();
			packageResponse = responsePayload(packageEntity);
			responseList.add(packageResponse);
		}
		return responseList;
	}

	@Override
	public ProviderResponse getProviderById(long pId) {
		ProvidersInfo packageentity = providersRepository.findById(pId);
		if (packageentity == null) {
			throw new UserNotFoundException("id Not Found : " + pId);
		}
		ProviderResponse packageResponse = responsePayload(packageentity);
		return packageResponse;
	}

	@Override
	public ProviderResponse updateProvider(ProviderRequest provider) {
		ProvidersInfo packageentity = providersRepository.findById(provider.getProviderId());
		if (packageentity == null) {
			throw new UserNotFoundException("package Not Found : " + provider.getProviderId());
		} else {
			ProviderResponse packageResponse = save(provider);
			return packageResponse;
		}
	}

	@Override
	public String deleteProvider(long pId) {
		ProvidersInfo providersInfo = providersRepository.findById(pId);
		if (providersInfo == null) {
			throw new UserNotFoundException("id Not Found : " + pId);
		}
		providersRepository.delete(providersInfo);
		return "provider deleted successfully " + pId;
		
	}

	private ProviderResponse responsePayload(ProvidersInfo providerEntity) {
		ProviderResponse packageResponse = new ProviderResponse();
		packageResponse.setProviderId(providerEntity.getProviderId());
		packageResponse.setProviderName(providerEntity.getProviderName());
		packageResponse.setProvideTier(providerEntity.getProvideTier());
		packageResponse.setConcurrentViews(providerEntity.getConcurrentViews());
		packageResponse.setOfferedPrice(providerEntity.getOfferedPrice());
		packageResponse.setEnduserPrice(providerEntity.getEnduserPrice());
		packageResponse.setValidFrom(new Timestamp(System.currentTimeMillis()));
		packageResponse.setValidTo(new Timestamp(System.currentTimeMillis()));
		packageResponse.setProviderStatus(providerEntity.getProviderStatus());
		packageResponse.setStagingKey(providerEntity.getStagingKey());
		packageResponse.setProductionKey(providerEntity.getProductionKey());
		packageResponse.setProviderEmail(providerEntity.getProviderEmail());
		packageResponse.setProviderPhone(providerEntity.getProviderPhone());
		packageResponse.setApi_documentPath(providerEntity.getApi_documentPath());
		packageResponse.setLogoPath(providerEntity.getLogoPath());
		packageResponse.setDeleteFlag(providerEntity.getDeleteFlag());
		packageResponse.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		packageResponse.setUpdatedDate(new Timestamp(System.currentTimeMillis()));

		return packageResponse;

	}

	@Override
	public LookupKeysMapping save(LookupKeysMapping lookupKeys) {
		ProvidersInfo providersInfo = providersRepository.findById(lookupKeys.getProviderId());
		if (!ObjectUtils.isEmpty(providersInfo)) {
			LookupKeysMapping lookupKeysMapping = new LookupKeysMapping();
			lookupKeysMapping.setProviderId(providersInfo.getProviderId());
			lookupKeysMapping.setProviderName(providersInfo.getProviderName());
			lookupKeysMapping.setCreatedDate(new Timestamp(System.currentTimeMillis()));
			lookupKeysMapping.setUpdatedDate(new Timestamp(System.currentTimeMillis()));

			try {
				JSONParser parser = new JSONParser();
				FileReader reader = new FileReader("src/main/resources/master.json");
				Object data = parser.parse(reader);
				JSONObject jsonObject = (JSONObject) data;
				 Document doc = Document.parse(data.toString());
				jsonObject.put("master", doc);
				lookupKeysMapping.setKeysMapping(jsonObject);

			} catch (IOException | ParseException e) {
				e.printStackTrace();
			}

			return lookupKeysMappingRepository.save(lookupKeysMapping);
		} else {
			logger.info("<< request in service persisted  >>", lookupKeys);
			throw new UserAlreadyExistException("User not Exists, Try with other Id");
		}
	}

	
	/*
	 * @Override public List<LookupKeysMapping> getLookup() {
	 * List<LookupKeysMapping> keys = lookupKeysMappingRepository.findAll(); for
	 * (LookupKeysMapping lookUp : keys) { JSONObject obj = new
	 * JSONObject(lookUp.getKeysMapping());
	 * 
	 * JSONArray jsonArr = (JSONArray) obj.get("keysMapping"); for (int k = 0; k <
	 * jsonArr.size(); k++) {
	 * 
	 * if (jsonArr.get(k) instanceof JSONObject) { jsonArr.get(k); } else {
	 * System.out.println(jsonArr.get(k)); }
	 * 
	 * } }
	 * 
	 * return keys; }
	 */
	  @Override public List<LookupKeysMapping> getLookup() {
		  List<LookupKeysMapping> keys = lookupKeysMappingRepository.findAll();
		  for(LookupKeysMapping lookUp : keys) 
		  {
			  JSONObject obj = new  JSONObject(lookUp.getKeysMapping()); 
		  JSONArray jsonArr = (JSONArray) obj.get("keysMapping"); 
		  for (int k = 0; k < jsonArr.size(); k++) 
		  {
		  if (jsonArr.get(k) instanceof JSONObject) 
		  { 
			  jsonArr.get(k);
			  } 
		  else {
		  System.out.println(jsonArr.get(k)); }
		  
		  } }
		  
		  return keys; 
		  }

	}
