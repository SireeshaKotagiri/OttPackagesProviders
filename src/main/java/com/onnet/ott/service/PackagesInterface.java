package com.onnet.ott.service;

import java.util.List;



import com.onnet.ott.dto.PackageRequest;
import com.onnet.ott.dto.PackageResponse;



public interface PackagesInterface 
{
	PackageResponse save(PackageRequest packages);

	List<PackageResponse> getPackage();

	PackageResponse getPackagesById(long pId);

	PackageResponse updatePackage(PackageRequest packages);

	String deletePackage(long pId);

	
	
	

}
