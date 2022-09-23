package com.onnet.ott.dto;

import java.util.Date;


public class PackageResponse {
	public static final String SEQUENCE_NAME = null;
	private long packageId;
	private String packageName;
	private float calculatedPrice;
	private float sellingPrice;
	private int packageStatus;
	private int deleteFlag;
	private Date createdDate;
	private Date updatedDate;
	//private List<ProviderEntity> provider;
	public long getPackageId() {
		return packageId;
	}
	public void setPackageId(long packageId) {
		this.packageId = packageId;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public float getCalculatedPrice() {
		return calculatedPrice;
	}
	public void setCalculatedPrice(float calculatedPrice) {
		this.calculatedPrice = calculatedPrice;
	}
	public float getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(float sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	public int getPackageStatus() {
		return packageStatus;
	}
	public void setPackageStatus(int packageStatus) {
		this.packageStatus = packageStatus;
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
	public PackageResponse(long packageId, String packageName, float calculatedPrice, float sellingPrice,
			int packageStatus, int deleteFlag, Date createdDate, Date updatedDate) {
		super();
		this.packageId = packageId;
		this.packageName = packageName;
		this.calculatedPrice = calculatedPrice;
		this.sellingPrice = sellingPrice;
		this.packageStatus = packageStatus;
		this.deleteFlag = deleteFlag;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}
	public PackageResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "PackageResponse [packageId=" + packageId + ", packageName=" + packageName + ", calculatedPrice="
				+ calculatedPrice + ", sellingPrice=" + sellingPrice + ", packageStatus=" + packageStatus
				+ ", deleteFlag=" + deleteFlag + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "]";
	}

	
}
