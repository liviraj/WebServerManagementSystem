package com.wms.model;

import java.sql.Date;

public class ServerBeen {
	private int serverId;
	private String serverName;
	private String operatingSystem;
	private String ram;
	private String hardDiskSize;
	private String availability;
	private Date expiryDate;

	public ServerBeen() {
		super();
	}

	public int getServerId() {
		return serverId;
	}

	public void setServerId(int serverId) {
		this.serverId = serverId;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public String getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getHardDiskSize() {
		return hardDiskSize;
	}

	public void setHardDiskSize(String hardDiskSize) {
		this.hardDiskSize = hardDiskSize;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Override
	public String toString() {
		return "ServerBeen [serverId=" + serverId + ", serverName=" + serverName + ", operatingSystem="
				+ operatingSystem + ", ram=" + ram + ", hardDiskSize=" + hardDiskSize + ", availability=" + availability
				+ ", expiryDate=" + expiryDate + "]";
	}

}
