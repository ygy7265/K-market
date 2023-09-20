package kr.co.kmarket.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public enum FileService {
	INSTANCE;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public String getFilePath(HttpServletRequest req) {
		ServletContext ctx = req.getServletContext();
		String path = ctx.getRealPath("admin/thumbAll");

		return path;
	} // getFilePath END
	
	public String renameToFile(HttpServletRequest req, String fName) {
		String path = getFilePath(req);
		logger.debug("리네임패스 찐임  : "+path);
		int i = fName.lastIndexOf(".");
		String ext = fName.substring(i);
		
		String uuid = UUID.randomUUID().toString();
		String sName = uuid + ext;
		
		File f1 = new File(path+"/"+fName);
		File f2 = new File(path+"/"+sName);
		
		logger.debug("path : " + path);
		
		// File명 수정
		f1.renameTo(f2);
		
		logger.debug("fileRename : " + sName);
		
		return sName;
	} // renameToFile END
	
	public MultipartRequest uploadFile(HttpServletRequest req) {
		// 파일 경로 구하기
		String path = getFilePath(req);
		logger.debug("path 이거다 찐임 : "+path);
		// Max Upload File Size
		int maxsize = 1024 * 1024 * 10;
		
		// File Upload
		MultipartRequest mr = null;
		try {
			mr = new MultipartRequest(req, path, maxsize, "UTF-8", new DefaultFileRenamePolicy());
		} catch (IOException e) {
			logger.error("uploadFile erro : " + e.getMessage());
		}
		logger.debug("파일저장완료 : "+mr);
		return mr;
	} // uploadFile END

}
