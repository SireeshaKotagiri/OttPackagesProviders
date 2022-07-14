package com.onnet.ott.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "LookupKeysMapping")
public class LookupKeysMapping {

	@Id
	 @Column(name="provider_id")
	private long providerId;
	 @Column(name="provider_name")
	private String providerName;
	 @Column(name="keys_mapping")
	private String keysMapping;
	 @Column(name="created_date")
	private Date createdDate;
	 @Column(name="updated_date")
	private Date updatedDate;

	@DBRef
	private List<ProvidersInfo> providersInfo;

	public long getProviderId() {
		return providerId;
	}

	public void setProviderId(long providerId) {
		this.providerId = providerId;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public String getKeysMapping() {
		return keysMapping;
	}

	public void setKeysMapping(String keysMapping) {
		this.keysMapping = keysMapping;
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

	public List<ProvidersInfo> getProvidersInfo() {
		return providersInfo;
	}

	public void setProvidersInfo(List<ProvidersInfo> providersInfo) {
		this.providersInfo = providersInfo;
	}

	public LookupKeysMapping(long providerId, String providerName, String keysMapping, Date createdDate,
			Date updatedDate, List<ProvidersInfo> providersInfo) {
		super();
		this.providerId = providerId;
		this.providerName = providerName;
		this.keysMapping = keysMapping;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.providersInfo = providersInfo;
	}

	public LookupKeysMapping() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "LookupKeysMapping [providerId=" + providerId + ", providerName=" + providerName + ", keysMapping="
				+ keysMapping + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + ", providersInfo="
				+ providersInfo + "]";
	}

}
