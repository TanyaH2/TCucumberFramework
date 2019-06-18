package com.syntax.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public FileInputStream fis;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	
	/**
	 * method that will open specified xlFile and sheet 
	* @param xlFilePath
	 * @param sheetName
	 */
	
	public void openExcel(String xlFilePath, String sheetName) {
		
		try {
		 fis = new FileInputStream(xlFilePath);
		 workbook = new XSSFWorkbook(fis);
		 sheet=workbook.getSheet(sheetName);		
		} catch(FileNotFoundException e)	{
			e.printStackTrace();
		} catch(IOException e)	{
			e.printStackTrace();
		}
		
	}
	
	/**
	 * method that will return String value of specified row and cell 
	 * @param rowIndex
	 * @param cellIndex
	 */
	
	public String getCellData(int rowIndex, int cellIndex) {
		return sheet.getRow(rowIndex).getCell(cellIndex).toString();
	}
	
	/**
	 * method that will return number of actual used rows 
	 * @param int
	 */
	
	public int getRowNum() {
		return sheet.getPhysicalNumberOfRows();
	}
	
	
	/**
	 * method will return number of last columns
	 * @param rowIndex
	 * @return
	 */
	public int getColNumber(int rowIndex) {
		return sheet.getRow(rowIndex).getLastCellNum();
	}
	
	

}