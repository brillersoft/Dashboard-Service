package com.briller.acess.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import com.briller.acess.configs.audit.AuditFields;
/**
 * @author shubham gaur
 *
 */

@Entity
@Table(name = "RETAIL_EMPLOYEE_CSAT_SUMMARY")
public class RetailEmployeeCsatSummary extends AuditFields<String> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_NUM")
	private Integer idNum;
	
	@Column(name = "ACCOUNT_ID")
	private int accountId;

	@Column(name = "TOTAL_EMAILS")
	private Integer totalEmails;

	@Column(name = "TOTAL_INTERACTIONS")
	private Integer totalInteractions;

	@Column(name = "NEGATIVE_INTERACTIONS")
	private Integer negativeInteractions;

	@Column(name = "CSAT")
	private double csat;

	@Column(name = "EMPLOYEE_EMAIL")
	private String employeeEmail;

	@Version
	private Integer versionNum;

	public Integer getIdNum() {
		return idNum;
	}

	public void setIdNum(Integer idNum) {
		this.idNum = idNum;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public Integer getTotalEmails() {
		return totalEmails;
	}

	public void setTotalEmails(Integer totalEmails) {
		this.totalEmails = totalEmails;
	}

	public Integer getTotalInteractions() {
		return totalInteractions;
	}

	public void setTotalInteractions(Integer totalInteractions) {
		this.totalInteractions = totalInteractions;
	}

	public Integer getNegativeInteractions() {
		return negativeInteractions;
	}

	public void setNegativeInteractions(Integer negativeInteractions) {
		this.negativeInteractions = negativeInteractions;
	}

	public double getCsat() {
		return csat;
	}

	public void setCsat(double csat) {
		this.csat = csat;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public Integer getVersionNum() {
		return versionNum;
	}

	public void setVersionNum(Integer versionNum) {
		this.versionNum = versionNum;
	}


}
