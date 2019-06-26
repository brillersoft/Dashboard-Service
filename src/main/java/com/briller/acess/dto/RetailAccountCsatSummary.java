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
@Table(name = "retail_account_csat_summary")
public class RetailAccountCsatSummary extends AuditFields<String> {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_NUM")	
	private Integer idNum;

	@Column(name = "ACCOUNT_ID")
	private Integer accountId;

	@Column(name = "ESCALATIONS")
	private int escalations;

	@Column(name = "TOTAL_INTERACTIONS")
	private int totalInteractions;

	@Column(name = "NEGATIVE_INTERACTIONS")
	private int negativeInteractions;

	@Column(name = "CSAT")
	private double csat;
	
	@Version
	private Integer versionNum;
	
	public Integer getIdNum() {
		return idNum;
	}

	public void setIdNum(Integer idNum) {
		this.idNum = idNum;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public int getEscalations() {
		return escalations;
	}

	public void setEscalations(int escalations) {
		this.escalations = escalations;
	}

	public int getTotalInteractions() {
		return totalInteractions;
	}

	public void setTotalInteractions(int totalInteractions) {
		this.totalInteractions = totalInteractions;
	}

	public int getNegativeInteractions() {
		return negativeInteractions;
	}

	public void setNegativeInteractions(int negativeInteractions) {
		this.negativeInteractions = negativeInteractions;
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
