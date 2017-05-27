package com.wang.green.view;

import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.view.AbstractView;

public class JxlsxFileView extends AbstractView {
	
	private static Logger logger=LoggerFactory.getLogger(JxlsxFileView.class);
	
	public static final String EXCEL_MODEL_VIEW ="jxlsxFileView";
	public static final String FILE_NAME = "fileName";
	private static final String CONTENT_TYPE = "application/vnd.ms-excel";
	private static final String EXTENSION = ".xlsx";

	public JxlsxFileView() {
		setContentType(CONTENT_TYPE);
	}

	protected boolean generatesDownloadContent() {
		return true;
	}

	protected final void renderMergedOutputModel(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType(getContentType());
		String fileName = (String)model.get(FILE_NAME);
		if(null!=fileName) {
			response.setHeader("Content-Disposition","attachment; "+encodingFileName(fileName, request));
		}
		ServletOutputStream out = response.getOutputStream();
		byte [] fileByte = (byte[]) model.get("fileByte");
		out.write(fileByte);
		out.flush();	
		
	}
	
	private String encodingFileName(String fileName,HttpServletRequest request){
		String agent = request.getHeader("USER-AGENT").toLowerCase();
		try {
			if(StringUtils.hasText(fileName)){
				String newFileName = URLEncoder.encode(fileName,"UTF-8");
				if (null != agent && (-1 != agent.indexOf("msie"))) { //IE
					newFileName = StringUtils.replace(newFileName, "+", "%20");
					if(newFileName.length() > 150){
						newFileName = new String(newFileName.getBytes("GB2312"),"ISO8859-1");
						newFileName = StringUtils.replace(newFileName, " ", "%20");
					}
					return "filename=\""+newFileName + EXTENSION + "\"";
				}else if(null != agent && (-1 != agent.indexOf("opera"))){ //OPERA
					return "filename*=UTF-8''" + EXTENSION + newFileName;
				}else { // chrome safiri or firefox
					return "filename=\"" + new String(fileName.getBytes("UTF-8"),"ISO8859-1") + EXTENSION + "\"";
				}
			}
			return fileName;
		} catch (Exception e) {
			logger.error("[encodingFileName][fileName={}]",fileName,e);
			return fileName;
		}
	}
	
	
	/*jxls 2.0
	protected final void renderMergedOutputModel(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Context jxlsContext = new Context(model);
		response.setContentType(getContentType());

		ServletOutputStream out = response.getOutputStream();
		String templateName = (String)model.get(TEMPLATE_NAME);
		InputStream in = getClass().getResourceAsStream(xlsTemplateLocation+templateName+EXTENSION);
		JxlsHelper.getInstance().processTemplate(in, out, jxlsContext);
		in.close();
		out.flush();	
		
		
	}*/

}