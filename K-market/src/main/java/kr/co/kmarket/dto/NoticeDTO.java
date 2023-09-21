package kr.co.kmarket.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NoticeDTO {
	
	private int noticeNo;
	private String cate;
	private String title;
	private String content;
	private String writer;
	private int hit;
	private String rdate;
	private String catename;
	
	public int getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}
	public void setNoticeNo(String noticeNo) {
		this.noticeNo = Integer.parseInt(noticeNo);
	}
	public String getCate() {
		return cate;
	}
	public void setCate(String cate) {
		this.cate = cate;
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
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	
	
	// 추가 
    public String formatDate() {
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat outputFormat = new SimpleDateFormat("yy-MM-dd");
            Date date = inputFormat.parse(rdate);
            return outputFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return rdate;
        }
    }

 
    
	public String getCatename() {
		return catename;
	}
	public void setCatename(String catename) {
		this.catename = catename;
	}
	@Override
	public String toString() {
		return "NoticeDAO [noticeNo=" + noticeNo + ", cate=" + cate + ", title=" + title + ", content=" + content
				+ ", writer=" + writer + ", hit=" + hit + " ]";
	}
	
}
