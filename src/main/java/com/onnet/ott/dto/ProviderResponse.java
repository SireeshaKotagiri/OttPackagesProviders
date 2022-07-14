package com.onnet.ott.dto;

import java.util.Date;

public class ProviderResponse
{
	private long providerId;
	private String providerName;
	private int provideTier;
	private int concurrentViews;
	private int offeredPrice;
	private int enduserPrice;
	private int providerStatus;
	private String stagingKey;
	private String productionKey;
	private String providerEmail;
	private String providerPhone;
	private String api_documentPath;
	private String logoPath;
	private int deleteFlag;
	private Date createdDate;
	private Date updatedDate;
	private Date validFrom;
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
	public ProviderResponse(long providerId, String providerName, int provideTier, int concurrentViews,
			int offeredPrice, int enduserPrice, int providerStatus, String stagingKey, String productionKey,
			String providerEmail, String providerPhone, String api_documentPath, String logoPath, int deleteFlag,
			Date createdDate, Date updatedDate, Date validFrom, Date validTo) {
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
	public ProviderResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ProviderResponse [providerId=" + providerId + ", providerName=" + providerName + ", provideTier="
				+ provideTier + ", concurrentViews=" + concurrentViews + ", offeredPrice=" + offeredPrice
				+ ", enduserPrice=" + enduserPrice + ", providerStatus=" + providerStatus + ", stagingKey=" + stagingKey
				+ ", productionKey=" + productionKey + ", providerEmail=" + providerEmail + ", providerPhone="
				+ providerPhone + ", api_documentPath=" + api_documentPath + ", logoPath=" + logoPath + ", deleteFlag="
				+ deleteFlag + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + ", validFrom="
				+ validFrom + ", validTo=" + validTo + "]";
	}
	
	
}
