package com.briller.acess.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import com.briller.acess.configs.audit.AuditFields;

@Entity
@Table(name = "employee_csat_summary")
public class EmployeeCsatSummary extends AuditFields<String>  {
	
	
	@Id
	@Column(name = "CLIENT_ID")
	private Integer clientId;
	
	@Column(name = "TOTAL_EMAILS")
	private Integer totalEmails;
	
	@Column(name = "TOTAL_INTERACTIONS")
	private Integer totalInteractions;
	
	@Column(name = "NEGATIVE_INTERACTIONS")
	private Integer negativeInteractions;
	
	@Column(name = "EMPLOYEE_EMAIL")
	private String employeeEmail;
	
	@Column(name = "EMPLOYEE_ID")
	private Integer employeeId;
	
	@Column(name = "ACCOUNT_ID")
	private int accountId;

	@Column(name = "CSAT")
	private double csat;
	
	@Version
	private Integer versionNum;

	public Integer getTotalInteractions() {
		return totalInteractions;
	}

	public void setTotalInteractions(Integer totalInteractions) {
		this.totalInteractions = totalInteractions;
	}

	public Integer getTotalEmails() {
		return totalEmails;
	}

	public void setTotalEmails(Integer totalEmails) {
		this.totalEmails = totalEmails;
	}

	public String getEmployeEmail() {
		return employeeEmail;
	}

	public void setEmployeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public Integer getNegativeInteractions() {
		return negativeInteractions;
	}

	public void setNegativeInteractions(Integer negativeInteractions) {
		this.negativeInteractions = negativeInteractions;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public double getCsat() {
		return csat;
	}

	public void setCsat(double csat) {
		this.csat = csat;
	}

	public Integer getVersionNum() {
		return versionNum;
	}

	public void setVersionNum(Integer versionNum) {
		this.versionNum = versionNum;
	}
	
}
