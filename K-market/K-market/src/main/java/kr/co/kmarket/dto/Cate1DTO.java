package kr.co.kmarket.dto;

public class Cate1DTO {

	private int cate1;
	private String c1Name;
	
	public int getCate1() {
		return cate1;
	}
	public void setCate1(int cate1) {
		this.cate1 = cate1;
	}
	public void setCate1(String cate1) {
		this.cate1 = Integer.parseInt(cate1);
	}
	public String getC1Name() {
		return c1Name;
	}
	public void setC1Name(String c1Name) {
		this.c1Name = c1Name;
	}
	
	@Override
	public String toString() {
		return "Cate1DTO [cate1=" + cate1 + ", c1Name=" + c1Name + "]";
	}
	
}
