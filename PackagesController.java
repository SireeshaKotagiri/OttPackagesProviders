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

import com.onnet.ott.dto.PackageRequest;
import com.onnet.ott.dto.PackageResponse;
import com.onnet.ott.entity.PackagesInfo;
import com.onnet.ott.service.PackagesInterface;
import com.onnet.ott.service.impl.SequenceGeneratorService;

@RestController
@RequestMapping("/packageProviders")
public class PackagesController {
	Logger logger = LoggerFactory.getLogger(PackagesController.class);

	@Autowired
	private PackagesInterface iPackage;
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;

	@PostMapping("/addPackage")
	public PackageResponse addPackageEntity(@RequestBody PackageRequest packages) {

		logger.info("<< request in controller save packages >>", packages);
		packages.setPackageId(sequenceGeneratorService.generateSequence(PackagesInfo.SEQUENCE_NAME));
		return iPackage.save(packages);
	}

	@GetMapping("/getPackages")
	public List<PackageResponse> findAllPackageEntity() {
		logger.info("<< request in controller get packages >>");
		return iPackage.getPackage();
	}

	@GetMapping("/getPackagesById/{id}")
	public PackageResponse findById(@PathVariable long id) {
		logger.info("<< request in controller get packages by id >>", id);
		return iPackage.getPackagesById(id);
	}

	@PutMapping("/updatePackage")
	public PackageResponse updatePackageEntity(@RequestBody PackageRequest packages) {
		logger.info("<< request in controller update packages >>", packages);
		return iPackage.updatePackage(packages);
	}

	@DeleteMapping("/deletePackage/{id}")
	public String deletePackage(@PathVariable long id) {
		logger.info("<< request in controller delete packages >>", id);
		return iPackage.deletePackage(id);
	}

	
}
