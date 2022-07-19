package com.onnet.ott.service;

import java.util.List;




import com.onnet.ott.dto.ProviderRequest;
import com.onnet.ott.dto.ProviderResponse;
import com.onnet.ott.entity.LookupKeysMapping;


public interface ProvidersInterface {
	
	ProviderResponse save(ProviderRequest provider);

	List<ProviderResponse> getProvider();

	ProviderResponse getProviderById(long pId);

	ProviderResponse updateProvider(ProviderRequest provider);

	String deleteProvider(long pId);
	
	LookupKeysMapping save(LookupKeysMapping provider);
	
	//List<LookupKeysMapping> getLookup();
	
	LookupKeysMapping getLookupById(long pId);


}
