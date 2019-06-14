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
	

	@Column(name = "NUM_OF_INTERACTIONS")
	private Integer num_of_interactions;
	
	@Column(name = "NUM_OF_EMAILS")
	private Integer num_of_emails;
	
	@Column(name = "NEGATIVE_INTERACTIONS")
	private Integer negative_interactions;
	
	@Column(name = "EMPLOYEE_ID")
	private Integer employeeId;
	
	@Id
	@Column(name = "CLIENT_ID")
	private Integer clientId;

	@Column(name = "ACCOUNT_ID")
	private int accountId;

	@Column(name = "CSAT")
	private int csat;
	
	@Version
	private Integer versionNum;
	
	
	public Integer getNum_of_interactions() {
		return num_of_interactions;
	}

	public void setNum_of_interactions(Integer num_of_interactions) {
		this.num_of_interactions = num_of_interactions;
	}

	public Integer getNum_of_emails() {
		return num_of_emails;
	}

	public void setNum_of_emails(Integer num_of_emails) {
		this.num_of_emails = num_of_emails;
	}

	public Integer getNegative_interactions() {
		return negative_interactions;
	}

	public void setNegative_interactions(Integer negative_interactions) {
		this.negative_interactions = negative_interactions;
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

	public int getCsat() {
		return csat;
	}

	public void setCsat(int csat) {
		this.csat = csat;
	}

	public Integer getVersionNum() {
		return versionNum;
	}

	public void setVersionNum(Integer versionNum) {
		this.versionNum = versionNum;
	}
}
