/**
 * @Author Amit Kumar Singh
 * Mumbai
 */
package com.aks.runner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;

import com.aks.dto.EmployeeDashboardDTO;
import com.aks.service.EmployeeService;
import com.aks.service.impl.EmployeeServiceImpl;

/**
 * @author shilpisingh
 *
 */
public class EmployeeDashboardDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EmployeeService empService=new EmployeeServiceImpl();
		List<EmployeeDashboardDTO> employeeList = empService.getEmployeeList();
		
		List<String> headerList= new ArrayList<String>();
		headerList.add("Step Name");
		headerList.add("Step No");
		headerList.add("Reference Duration");
		
		
		headerList.add("T-9");
		headerList.add("T-8");
		headerList.add("T-7");
		headerList.add("T-6");
		headerList.add("T-5");
		headerList.add("T-4");
		headerList.add("T-3");
		headerList.add("T-2");
		headerList.add("T-1");
		headerList.add("T");
		
		
	    createEmployeeSheet(employeeList,headerList);
		
		

	}

	/**
	 * @param employeeList
	 */
	private static void createEmployeeSheet(List<EmployeeDashboardDTO> employeeList,List<String> headerList) {
		// TODO Auto-generated method stub
		HSSFWorkbook workbook= new HSSFWorkbook();
		HSSFSheet myWorkSheet = workbook.createSheet("Performance Sheet");
		
		int rowNum=0;
		
		
		Row row = myWorkSheet.createRow(rowNum++);
		
		int cellnum=0;
		
		Cell cell = row.createCell(0);
		cell.setCellValue("Performance Dashboard List");
		
		myWorkSheet.addMergedRegion(new CellRangeAddress(
	            0, //first row (0-based)
	            0, //last row  (0-based)
	            0, //first column (0-based)
	            12  //last column  (0-based)
	    ));
		
		
		HSSFCellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setBorderBottom(CellStyle.BORDER_MEDIUM);
		cellStyle.setBorderTop(CellStyle.BORDER_MEDIUM);
		cellStyle.setBorderLeft(CellStyle.BORDER_MEDIUM);
		cellStyle.setBorderRight(CellStyle.BORDER_MEDIUM);
		cell.setCellStyle(cellStyle);
		
		row=myWorkSheet.createRow(rowNum++);
		
		for (String header : headerList)
		{
			
			System.out.println("For "+cellnum +" value is "+header);
			cell= row.createCell(cellnum++);
			cell.setCellValue(header);
		}
		
		
		
		for (EmployeeDashboardDTO dto : employeeList)
		{
			cellnum=0;
			row=myWorkSheet.createRow(rowNum++);
			Cell cell0 = row.createCell(cellnum++);
			cell0.setCellValue(dto.getStepName());
			
			Cell cell1 = row.createCell(cellnum++);
			cell1.setCellValue(dto.getStepNo());
			
			Cell cell2 = row.createCell(cellnum++);
			cell2.setCellValue(dto.getReferenceDuration());
			
			for (Integer runTime:dto.getDeviationList())
			{
				
				cell= row.createCell(cellnum++);
				
				HSSFCellStyle cellStyleRed = workbook.createCellStyle();
				HSSFPalette paletteRed = workbook.getCustomPalette();
				// get the color which most closely matches the color you want to use
				HSSFColor myColorRed = paletteRed.findSimilarColor(255, 0, 0);
				// get the palette index of that color 
				short palIndexRed = myColorRed.getIndex();
				// code to get the style for the cell goes here
				cellStyleRed.setFillForegroundColor(palIndexRed);
				cellStyleRed.setFillPattern(CellStyle.SOLID_FOREGROUND);
				cellStyleRed.setBorderBottom(CellStyle.BORDER_MEDIUM);
				cellStyleRed.setBorderTop(CellStyle.BORDER_MEDIUM);
				cellStyleRed.setBorderLeft(CellStyle.BORDER_MEDIUM);
				cellStyleRed.setBorderRight(CellStyle.BORDER_MEDIUM);
				//cellStyleRed.setBottomBorderColor(myColorRed.getIndex());
				
				HSSFCellStyle cellStyleGreen = workbook.createCellStyle();
				HSSFPalette paletteGreen = workbook.getCustomPalette();
				// get the color which most closely matches the color you want to use
				HSSFColor myColorGreen = paletteGreen.findSimilarColor(0, 255, 0);
				// get the palette index of that color 
				short palIndexGreen = myColorGreen.getIndex();
				// code to get the style for the cell goes here
				cellStyleGreen.setFillForegroundColor(palIndexGreen);
				cellStyleGreen.setFillPattern(CellStyle.SOLID_FOREGROUND);
				cellStyleGreen.setBorderBottom(CellStyle.BORDER_MEDIUM);
				cellStyleGreen.setBorderTop(CellStyle.BORDER_MEDIUM);
				cellStyleGreen.setBorderLeft(CellStyle.BORDER_MEDIUM);
				cellStyleGreen.setBorderRight(CellStyle.BORDER_MEDIUM);
				
				
				HSSFCellStyle cellStyleYellow = workbook.createCellStyle();
				HSSFPalette paletteYellow = workbook.getCustomPalette();
				// get the color which most closely matches the color you want to use
				HSSFColor myColorYellow = paletteYellow.findSimilarColor(255, 255, 0);
				// get the palette index of that color 
				short palIndexYellow = myColorYellow.getIndex();
				// code to get the style for the cell goes here
				cellStyleYellow.setFillForegroundColor(palIndexYellow);
				cellStyleYellow.setFillPattern(CellStyle.SOLID_FOREGROUND);
				
				cellStyleYellow.setBorderBottom(CellStyle.BORDER_MEDIUM);
				cellStyleYellow.setBorderTop(CellStyle.BORDER_MEDIUM);
				cellStyleYellow.setBorderLeft(CellStyle.BORDER_MEDIUM);
				cellStyleYellow.setBorderRight(CellStyle.BORDER_MEDIUM);
				
				if (runTime >5  && runTime<=10 )
				{
				cell.setCellValue(runTime);
				cell.setCellType(CellStyle.ALIGN_CENTER);
				cell.setCellStyle(cellStyleYellow);
				
				}
				else if (runTime >10   )
				{
				cell.setCellValue(runTime);
				cell.setCellStyle(cellStyleRed);
				}
				else 
				{
				cell.setCellValue(runTime);
				cell.setCellStyle(cellStyleGreen);
				}
			}
			
	}

	
		try {
		    FileOutputStream out = 
		            new FileOutputStream(new File("D:\\Amit\\Files\\Performance.xls"));
		    workbook.write(out);
		    out.close();
		    workbook.close();
		    System.out.println("Excel written successfully..");
		     
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}

		
		
		
		
		
		
		
		
		
	}

}
