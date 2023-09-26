package kr.co.kmarket.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReviewDTO {
	
	private int revNo;
	private int prodNo;
	private String content;
	private String uid;
	private int rating;
	private String regip;
	private String rdate;
	
	// 추가 필드 
	private String name;
	private String prodName;
	
	public int getRevNo() {
		return revNo;
	}
	public void setRevNo(int revNo) {
		this.revNo = revNo;
	}
	public void setRevNo(String revNo) {
		this.revNo = Integer.parseInt(revNo);
	}
	public int getProdNo() {
		return prodNo;
	}
	public void setProdNo(int prodNo) {
		this.prodNo = prodNo;
	}
	public void setProdNo(String prodNo) {
		this.prodNo = Integer.parseInt(prodNo);
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getRegip() {
		return regip;
	}
	public void setRegip(String regip) {
		this.regip = regip;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	// 추가 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	
	// 추가 
    public String formatDate() {
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = inputFormat.parse(rdate);
            return outputFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return rdate;
        }
    }
    
    
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReviewDTO [revNo=").append(revNo).append(", prodNo=").append(prodNo).append(", content=")
				.append(content).append(", uid=").append(uid).append(", rating=").append(rating).append(", regip=")
				.append(regip).append(", rdate=").append(rdate).append("]");
		return builder.toString();
	}

}
