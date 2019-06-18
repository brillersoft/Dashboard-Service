package com.briller.acess.dto;

public class RequestParamDashboard {

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getLoginEmail() {
		return loginEmail;
	}

	public void setLoginEmail(String loginEmail) {
		this.loginEmail = loginEmail;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	private String fromDate;

	@Override
	public String toString() {
		return "RequestParamDashboard [fromDate=" + fromDate + ", toDate=" + toDate + ", loginEmail=" + loginEmail
				+ ", client=" + client + ", employeeEmail=" + employeeEmail + "]";
	}

	private String toDate;

	private String loginEmail;

	private String client;
	
	private String employeeEmail;
	
}
