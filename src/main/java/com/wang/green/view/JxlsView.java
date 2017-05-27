package com.wang.green.view;

import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jxls.transformer.XLSTransformer;

import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.view.AbstractView;

public class JxlsView extends AbstractView {
	
	private static Logger logger=LoggerFactory.getLogger(JxlsView.class);
	
	public static final String EXCEL_MODEL_VIEW ="jxlsView";
	public static final String EXCEL_MODEL_LIST = "excelModelList";
	public static final String TEMPLATE_NAME = "templateName";
	public static final String TEMPLATE_TYPE = "templateType";//如果模板�?07版本的就传该参数，�?�为xlsx;如果�?03版本就不用传该参�?
	public static final String FILE_NAME = "fileName";
	public static final String DEFAULT_TEMPLATE_NAME = "common-table";
	private static final String CONTENT_TYPE = "application/vnd.ms-excel";
	private static final String EXTENSION = ".xls";
	private static final String EXTENSION07 = ".xlsx";
	private String xlsTemplateLocation;

	public JxlsView() {
		setContentType(CONTENT_TYPE);
	}

	public void setXlsTemplateLocation(String xlsTemplateLocation) {
		this.xlsTemplateLocation = xlsTemplateLocation;
	}

	protected boolean generatesDownloadContent() {
		return true;
	}

	protected final void renderMergedOutputModel(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		XLSTransformer transformer = new XLSTransformer();
//		transformer.setJexlInnerCollectionsAccess(true);
		response.setContentType(getContentType());
		String fileName = (String)model.get(FILE_NAME);
		String templateType = (String)model.get(TEMPLATE_TYPE);
		if(null!=fileName) {
			if(null!=templateType){
				response.setHeader("Content-Disposition","attachment; "+encoding07FileName(fileName, request));
			}else{
				response.setHeader("Content-Disposition","attachment; "+encodingFileName(fileName, request));
			}
			
		}
		
		ServletOutputStream out = response.getOutputStream();
		String templateName = (String)model.get(TEMPLATE_NAME);
		if(null==templateName) {
			templateName = DEFAULT_TEMPLATE_NAME;
		}
		//TODO cache the template
		InputStream in= null;
		if(null== templateType){
			in = getClass().getResourceAsStream(xlsTemplateLocation+templateName+EXTENSION);
		}else{
			in = getClass().getResourceAsStream(xlsTemplateLocation+templateName+EXTENSION07);
		}
		
		Workbook workbook = transformer.transformXLS(in, model);
		workbook.write(out);
		in.close();
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
	
	private String encoding07FileName(String fileName,HttpServletRequest request){
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
					return "filename=\""+newFileName + EXTENSION07 + "\"";
				}else if(null != agent && (-1 != agent.indexOf("opera"))){ //OPERA
					return "filename*=UTF-8''" + EXTENSION07 + newFileName;
				}else { // chrome safiri or firefox
					return "filename=\"" + new String(fileName.getBytes("UTF-8"),"ISO8859-1") + EXTENSION07 + "\"";
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
		//TODO cache the template
		InputStream in = getClass().getResourceAsStream(xlsTemplateLocation+templateName+EXTENSION);
		JxlsHelper.getInstance().processTemplate(in, out, jxlsContext);
		in.close();
		out.flush();	
		
		
	}*/

}