package com.onnet.ott.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onnet.ott.dto.ProviderRequest;
import com.onnet.ott.dto.ProviderResponse;
import com.onnet.ott.entity.LookupKeysMapping;
import com.onnet.ott.entity.ProvidersInfo;
import com.onnet.ott.service.ProvidersInterface;
import com.onnet.ott.service.impl.ProviderSequenceGenerator;

@RestController
@RequestMapping("/packageProviders")
public class ProvidersController {

	Logger logger = LoggerFactory.getLogger(PackagesController.class);

	@Autowired
	private ProvidersInterface iProvider;
	@Autowired
	private ProviderSequenceGenerator providerSequence;

	@PostMapping("/addProvider")
	public ProviderResponse addPackageEntity(@RequestBody ProviderRequest providers) {

		logger.info("<< request in controller save providers >>", providers);
		providers.setProviderId(providerSequence.generateSequence(ProvidersInfo.SEQUENCE_NAME));
		return iProvider.save(providers);
	}

	@GetMapping("/getProvider")
	public List<ProviderResponse> findAllProviderEntity() {
		logger.info("<< request in controller get providers >>");
		return iProvider.getProvider();
	}

	@GetMapping("/getProviderById/{id}")
	public ProviderResponse findById(@PathVariable long id) {
		logger.info("<< request in controller get providers by id >>", id);
		return iProvider.getProviderById(id);
	}

	@PutMapping("/updateProvider")
	public ProviderResponse updateProviderEntity(@RequestBody ProviderRequest provider) {
		logger.info("<< request in controller update providers >>", provider);
		return iProvider.updateProvider(provider);
	}

	@DeleteMapping("/deleteProvider/{id}")
	public String deletePackage(@PathVariable long id) {
		logger.info("<< request in controller delete providers >>", id);
		
		return iProvider.deleteProvider(id);
	}

	@PostMapping("/addLookupKeys")
	public LookupKeysMapping addPackageEntity(@RequestBody LookupKeysMapping packages) {
		logger.info("<< request in controller save lookup keys >>", packages);
		return iProvider.save(packages);
	}
//
//	@GetMapping("/getLookupKeys")
//	public List<LookupKeysMapping> findAllPackageEntity() {
//		logger.info("<< request in controller get packages >>");
//		return iProvider.getLookup();
//	}
	
	@GetMapping("/getLookupById/{id}")
	public LookupKeysMapping findLookById(@PathVariable long id) {
		logger.info("<< request in controller get lookupkeys by id >>", id);
		return iProvider.getLookupById(id);
	}

}
