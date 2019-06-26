package com.briller.acess.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.briller.acess.configs.audit.AuditFields;

@Entity
@Table(name = "RETAIL_CLIENT")
public class RetailClient extends AuditFields<String> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id")
	private int accountId;
	
	@Column(name = "domain_name")
	private String domainName;

	@Column(name = "status")
	private String status;

	@Version
	private Integer versionNum;

	@OneToOne
	@JoinColumn(name = "account_id")
	private CrmAccountData crmAccountData;
	
	@OneToOne
	@JoinColumn(name = "account_id")
	private RetailAccountCsatSummary retailAccountCsatSummary;


	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getVersionNum() {
		return versionNum;
	}

	public void setVersionNum(Integer versionNum) {
		this.versionNum = versionNum;
	}

	public CrmAccountData getCrmAccountData() {
		return crmAccountData;
	}

	public void setCrmAccountData(CrmAccountData crmAccountData) {
		this.crmAccountData = crmAccountData;
	}

	public RetailAccountCsatSummary getRetailAccountCsatSummary() {
		return retailAccountCsatSummary;
	}

	public void setRetailAccountCsatSummary(RetailAccountCsatSummary retailAccountCsatSummary) {
		this.retailAccountCsatSummary = retailAccountCsatSummary;
	}

}
