package kr.co.kmarket.dto;

public class QnaDTO {
	private int qnaNo;
	private String cate1;
	private String cate2;
	private String title;
	private String content;
	private String writer;
	private String status;
	private String reply;
	private String rdate;
	private String ip;
	
	public int getQnaNo() {
		return qnaNo;
	}
	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
	}
	public String getCate1() {
		return cate1;
	}
	public void setCate1(String cate1) {
		this.cate1 = cate1;
	}
	public String getCate2() {
		return cate2;
	}
	public void setCate2(String cate2) {
		this.cate2 = cate2;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	@Override
	public String toString() {
		return "QnaDTO [qnaNo=" + qnaNo + ", cate1=" + cate1 + ", cate2=" + cate2 + ", title=" + title + ", content="
				+ content + ", writer=" + writer + ", status=" + status + ", reply=" + reply + ", rdate=" + rdate
				+ ", ip=" + ip + "]";
	}
	
	
	
	
	
}
