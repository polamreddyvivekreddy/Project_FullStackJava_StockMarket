package com.example.stockAppCompanyDetails.model;



import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
public class CompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer companyId;
    private String companyName;
    private String companyCEO;
    private String companyTurnover;
    private String companyBoardOfDirectors;
    private String companySector;
    private String companyBriefWriteUp;
    
    
	public CompanyEntity() {

	}


	public CompanyEntity(Integer companyId, String companyName, String companyCEO, String companyTurnover,
			String companyBoardOfDirectors, String companySector, String companyBriefWriteUp) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.companyCEO = companyCEO;
		this.companyTurnover = companyTurnover;
		this.companyBoardOfDirectors = companyBoardOfDirectors;
		this.companySector = companySector;
		this.companyBriefWriteUp = companyBriefWriteUp;
	}


	public Integer getCompanyId() {
		return companyId;
	}


	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}


	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public String getCompanyCEO() {
		return companyCEO;
	}


	public void setCompanyCEO(String companyCEO) {
		this.companyCEO = companyCEO;
	}


	public String getCompanyTurnover() {
		return companyTurnover;
	}


	public void setCompanyTurnover(String companyTurnover) {
		this.companyTurnover = companyTurnover;
	}


	public String getCompanyBoardOfDirectors() {
		return companyBoardOfDirectors;
	}


	public void setCompanyBoardOfDirectors(String companyBoardOfDirectors) {
		this.companyBoardOfDirectors = companyBoardOfDirectors;
	}


	public String getCompanySector() {
		return companySector;
	}


	public void setCompanySector(String companySector) {
		this.companySector = companySector;
	}


	public String getCompanyBriefWriteUp() {
		return companyBriefWriteUp;
	}


	public void setCompanyBriefWriteUp(String companyBriefWriteUp) {
		this.companyBriefWriteUp = companyBriefWriteUp;
	}




	
    

}
