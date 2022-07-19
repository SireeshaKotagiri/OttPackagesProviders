package com.onnet.ott.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "providersInfo")
public class ProvidersInfo {
	@Transient
	public static final String SEQUENCE_NAME = "provider_sequence";
	@Id
	@Field(name = "provider_id")
	private long providerId;
	@Field(name = "provider_name")
	private String providerName;
	@Field(name = "provider_tier")
	private int provideTier;
	@Field(name = "concurrent_views")
	private int concurrentViews;
	@Field(name = "offered_price")
	private int offeredPrice;
	@Field(name = "enduser_price")
	private int enduserPrice;
	@Field(name = "provider_status")
	private int providerStatus;
	@Field(name = "staging_key")
	private String stagingKey;
	@Field(name = "production_key")
	private String productionKey;
	@Field(name = "provider_email")
	private String providerEmail;
	@Field(name = "provider_phone")
	private String providerPhone;
	@Field(name = "api_document_path")
	private String api_documentPath;
	@Field(name = "logo_path")
	private String logoPath;
	@Field(name = "delete_flag")
	private int deleteFlag;
	@Field(name = "created_date")
	private Date createdDate;
	@Field(name = "updated_date")
	private Date updatedDate;
	@Field(name = "valid_from")
	private Date validFrom;
	@Field(name = "valid_to")
	private Date validTo;

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

	public int getProvideTier() {
		return provideTier;
	}

	public void setProvideTier(int provideTier) {
		this.provideTier = provideTier;
	}

	public int getConcurrentViews() {
		return concurrentViews;
	}

	public void setConcurrentViews(int concurrentViews) {
		this.concurrentViews = concurrentViews;
	}

	public int getOfferedPrice() {
		return offeredPrice;
	}

	public void setOfferedPrice(int offeredPrice) {
		this.offeredPrice = offeredPrice;
	}

	public int getEnduserPrice() {
		return enduserPrice;
	}

	public void setEnduserPrice(int enduserPrice) {
		this.enduserPrice = enduserPrice;
	}

	public int getProviderStatus() {
		return providerStatus;
	}

	public void setProviderStatus(int providerStatus) {
		this.providerStatus = providerStatus;
	}

	public String getStagingKey() {
		return stagingKey;
	}

	public void setStagingKey(String stagingKey) {
		this.stagingKey = stagingKey;
	}

	public String getProductionKey() {
		return productionKey;
	}

	public void setProductionKey(String productionKey) {
		this.productionKey = productionKey;
	}

	public String getProviderEmail() {
		return providerEmail;
	}

	public void setProviderEmail(String providerEmail) {
		this.providerEmail = providerEmail;
	}

	public String getProviderPhone() {
		return providerPhone;
	}

	public void setProviderPhone(String providerPhone) {
		this.providerPhone = providerPhone;
	}

	public String getApi_documentPath() {
		return api_documentPath;
	}

	public void setApi_documentPath(String api_documentPath) {
		this.api_documentPath = api_documentPath;
	}

	public String getLogoPath() {
		return logoPath;
	}

	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}

	public int getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
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

	public Date getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidTo() {
		return validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	public ProvidersInfo(long providerId, String providerName, int provideTier, int concurrentViews, int offeredPrice,
			int enduserPrice, int providerStatus, String stagingKey, String productionKey, String providerEmail,
			String providerPhone, String api_documentPath, String logoPath, int deleteFlag, Date createdDate,
			Date updatedDate, Date validFrom, Date validTo) {
		super();
		this.providerId = providerId;
		this.providerName = providerName;
		this.provideTier = provideTier;
		this.concurrentViews = concurrentViews;
		this.offeredPrice = offeredPrice;
		this.enduserPrice = enduserPrice;
		this.providerStatus = providerStatus;
		this.stagingKey = stagingKey;
		this.productionKey = productionKey;
		this.providerEmail = providerEmail;
		this.providerPhone = providerPhone;
		this.api_documentPath = api_documentPath;
		this.logoPath = logoPath;
		this.deleteFlag = deleteFlag;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.validFrom = validFrom;
		this.validTo = validTo;
	}

	public ProvidersInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ProvidersInfo [providerId=" + providerId + ", providerName=" + providerName + ", provideTier="
				+ provideTier + ", concurrentViews=" + concurrentViews + ", offeredPrice=" + offeredPrice
				+ ", enduserPrice=" + enduserPrice + ", providerStatus=" + providerStatus + ", stagingKey=" + stagingKey
				+ ", productionKey=" + productionKey + ", providerEmail=" + providerEmail + ", providerPhone="
				+ providerPhone + ", api_documentPath=" + api_documentPath + ", logoPath=" + logoPath + ", deleteFlag="
				+ deleteFlag + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + ", validFrom="
				+ validFrom + ", validTo=" + validTo + "]";
	}

}
