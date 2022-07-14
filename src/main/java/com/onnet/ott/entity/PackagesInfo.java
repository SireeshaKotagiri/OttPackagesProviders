package com.onnet.ott.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "packagesInfo")
public class PackagesInfo {
	@org.springframework.data.annotation.Transient
	public static final String SEQUENCE_NAME = "packages_sequence";
	@Id
	@Column(name="package_id")
	private long packageId;
	@Column(name="package_name")
	private String packageName;
	@Column(name="calculated_price")
	private float calculatedPrice;
	@Column(name="selling_price")
	private float sellingPrice;
	@Column(name="package_status")
	private int packageStatus;
	@Column(name="delete_flag")
	private int deleteFlag;
	@Column(name="created_date")
	private Date createdDate;
	@Column(name="updated_date")
	private Date updatedDate;
	

	@DBRef
	private List<ProvidersInfo> provider;

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

	public List<ProvidersInfo> getProvider() {
		return provider;
	}

	public void setProvider(List<ProvidersInfo> provider) {
		this.provider = provider;
	}

	public PackagesInfo(long packageId, String packageName, float calculatedPrice, float sellingPrice,
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

	@Override
	public String toString() {
		return "PackagesInfo [packageId=" + packageId + ", packageName=" + packageName + ", calculatedPrice="
				+ calculatedPrice + ", sellingPrice=" + sellingPrice + ", packageStatus=" + packageStatus
				+ ", deleteFlag=" + deleteFlag + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate
				+ ", provider=" + provider + "]";
	}

	public PackagesInfo() {
		super();
	}

}
