package com.wang.green.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.wang.green.common.ExcelSerializeable;


public class ExcelView extends AbstractExcelView {
	
	public static final String EXCEL_MODEL_VIEW ="excelView";
	public static final String EXCEL_MODEL_LIST ="excelModelList";

	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<ExcelSerializeable> excelModelList = (List<ExcelSerializeable>)model.get(EXCEL_MODEL_LIST);
		final HSSFSheet sheet = workbook.createSheet();
		
		final HSSFCellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
		headerCellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		headerCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		headerCellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		headerCellStyle.setWrapText(false);
		
		HSSFFont headerFont = workbook.createFont();
		headerFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
		headerFont.setColor(HSSFColor.WHITE.index);
		headerCellStyle.setFont(headerFont);
		
		final HSSFCellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		cellStyle.setWrapText(false);
		
		
		for(int i=0, listSize=excelModelList.size();i<listSize;i++) {
			ExcelSerializeable excelModel = excelModelList.get(i);
			String[] headers = excelModel.excelHeaders();
			if(0==i) {//å†™excelå¤?
				final HSSFRow headerRow = sheet.createRow(0);
				headerRow.setHeightInPoints(25f);
				for(int j=0;j<headers.length;j++) {
					HSSFCell headCell = headerRow.createCell(j);
					headCell.setCellStyle(headerCellStyle);
					headCell.setCellValue(headers[j]);
				}
			}
			final HSSFRow dataRow = sheet.createRow(i+1);
			dataRow.setHeightInPoints(20f);
			String[] rowData = excelModel.serializeable();
			for(int j=0;j<rowData.length;j++) {
				HSSFCell cell = dataRow.createCell(j);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(rowData[j]);
			}
		}
		for(int i=0, listSize=excelModelList.size();i<listSize;i++) {
			sheet.autoSizeColumn(i);
		}
	}

}

