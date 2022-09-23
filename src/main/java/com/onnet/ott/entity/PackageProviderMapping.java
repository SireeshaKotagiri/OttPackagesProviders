package com.onnet.ott.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "package_provider_mapping")
public class PackageProviderMapping {

	@Column(name="package_id")
	private long packageId;
	@Column(name="provider_id")
	private long providerId;
	@Column(name="created_date")
	private Date createdDate;
	@Column(name="updated_date")
	private Date updatedDate;
	
	@DBRef
	private List<ProvidersInfo> providersInfo;
	@DBRef
	private List<PackagesInfo> packagesInfo;


	public long getPackageId() {
		return packageId;
	}

	public void setPackageId(long packageId) {
		this.packageId = packageId;
	}

	public long getProviderId() {
		return providerId;
	}

	public void setProviderId(long providerId) {
		this.providerId = providerId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}
