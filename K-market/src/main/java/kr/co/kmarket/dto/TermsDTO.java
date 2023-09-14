package kr.co.kmarket.dto;
/*
 * 	날짜 : 2023/09/13
 *  이름 : 이현정
 * 	내용 : Terms 약관 페이지 내용 출력 및 약관 동의 기능 추가 
 * 
 * */
public class TermsDTO {
	private String terms;
	private String privacy;
	private String location;
	private String finance;
	private String tax;
	private String type;
	
	public String getTerms() {
		return terms;
	}
	public void setTerms(String terms) {
		this.terms = terms;
	}
	public String getPrivacy() {
		return privacy;
	}
	public void setPrivacy(String privacy) {
		this.privacy = privacy;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getFinance() {
		return finance;
	}
	public void setFinance(String finance) {
		this.finance = finance;
	}
	public String getTax() {
		return tax;
	}
	public void setTax(String tax) {
		this.tax = tax;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	
	
	
}
