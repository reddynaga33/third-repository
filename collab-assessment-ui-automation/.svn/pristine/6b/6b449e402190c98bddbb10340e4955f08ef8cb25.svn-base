package com.cisco.collabNextGen.utilities;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;

import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.*;


import java.io.*;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;

	

/**
 * Its a common excel utilities reusable methods which can be used for basic excel operation
 * 
 * @author Giri
 */
public class ExcelUtilities {

	public  String path;
	public  FileInputStream fis = null;
	public  FileOutputStream fileOut =null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row   =null;
	private XSSFCell cell = null;
	
	/**
	 * Parameterised Constructor for path setup and initialization
	 * @param path: The path of the excel file
	 */
	public ExcelUtilities(String path) {
		
		this.path=path;
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);
			fis.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
		
	}
	
	
	
	
	/**
	 * This method is used to get the total row count in the particular sheet
	 * 
	 * @param sheetName sheet name should be given as the parameter
	 * @return This method returns integer which is the total number of rows in the particular sheet
	 */
	public int getRowCount(String sheetName){
		int index = workbook.getSheetIndex(sheetName);
		if(index==-1)
			return 0;
		else{
		sheet = workbook.getSheetAt(index);
		int number=sheet.getLastRowNum()+1;
		return number;
		}
		
	}
	
	
	
	/**
	 * This method retrives the cell data as a string. Input should be Sheet name, Column Name
	 * and Row number
	 * 
	 * @param sheetName Sheet Name should be passed
	 * @param colName   Column Name which is at the index zero should be passed on
	 * @param rowNum   Row number should be given
	 * @return This method returns String as the cell data
	 */
	public String getCellData(String sheetName,String colName,int rowNum){
		try{
			if(rowNum <=0)
				return "";
		
		int index = workbook.getSheetIndex(sheetName);
		int col_Num=-1;
		if(index==-1)
			return "";
		
		sheet = workbook.getSheetAt(index);
		row=sheet.getRow(0);
		for(int i=0;i<row.getLastCellNum();i++){
			//System.out.println(row.getCell(i).getStringCellValue().trim());
			if(row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
				col_Num=i;
		}
		if(col_Num==-1)
			return "";
		
		sheet = workbook.getSheetAt(index);
		row = sheet.getRow(rowNum-1);
		if(row==null)
			return "";
		cell = row.getCell(col_Num);
		
		if(cell==null)
			return "";
		
		if(cell.getCellType()==Cell.CELL_TYPE_STRING)
			  return cell.getStringCellValue();
		else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC || cell.getCellType()==Cell.CELL_TYPE_FORMULA ){
			  
			  String cellText  = String.valueOf(cell.getNumericCellValue());
			  if (HSSFDateUtil.isCellDateFormatted(cell)) {
		           
				  double d = cell.getNumericCellValue();

				  Calendar cal =Calendar.getInstance();
				  cal.setTime(HSSFDateUtil.getJavaDate(d));
		            cellText =
		             (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
		           cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" +
		                      cal.get(Calendar.MONTH)+1 + "/" + 
		                      cellText;
		           
		          

		         }

			  
			  
			  return cellText;
		  }else if(cell.getCellType()==Cell.CELL_TYPE_BLANK)
		      return ""; 
		  else 
			  return String.valueOf(cell.getBooleanCellValue());
		
		}
		catch(Exception e){
			
			e.printStackTrace();
			return "row "+rowNum+" or column "+colName +" does not exist in xls";
		}
	}
	
	
	/**
	 * This is an overloaded method which fetch the data in the cell based on the Column number
	 * 
	 * @param sheetName  Sheet Name should be passed
	 * @param colNum     Column Number should be provided
	 * @param rowNum	 Row number should be given
	 * @return			 Returns String which is the cell data
	 */
	public String getCellData(String sheetName,int colNum,int rowNum){
		try{
			if(rowNum <=0)
				return "";
		
		int index = workbook.getSheetIndex(sheetName);

		if(index==-1)
			return "";
		
	
		sheet = workbook.getSheetAt(index);
		row = sheet.getRow(rowNum-1);
		if(row==null)
			return "";
		cell = row.getCell(colNum);
		if(cell==null)
			return "";
		
	  if(cell.getCellType()==Cell.CELL_TYPE_STRING)
		  return cell.getStringCellValue();
	  else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC || cell.getCellType()==Cell.CELL_TYPE_FORMULA ){
		  
		  String cellText  = String.valueOf(cell.getNumericCellValue());
		  if (HSSFDateUtil.isCellDateFormatted(cell)) {
	           // format in form of M/D/YY
			  double d = cell.getNumericCellValue();

			  Calendar cal =Calendar.getInstance();
			  cal.setTime(HSSFDateUtil.getJavaDate(d));
	            cellText =
	             (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
	           cellText = cal.get(Calendar.MONTH)+1 + "/" +
	                      cal.get(Calendar.DAY_OF_MONTH) + "/" +
	                      cellText;
	           
	         

	         }

		  
		  
		  return cellText;
	  }else if(cell.getCellType()==Cell.CELL_TYPE_BLANK)
	      return "";
	  else 
		  return String.valueOf(cell.getBooleanCellValue());
		}
		catch(Exception e){
			
			e.printStackTrace();
			return "row "+rowNum+" or column "+colNum +" does not exist  in xls";
		}
	}
	
	
	
	/**
	 * This method is used to set the data in the given cell
	 * 
	 * @param sheetName String: Sheet name should be provided as an input
	 * @param colName	String: Column name should be given as an input parameter
	 * @param rowNum	integer: row number should be given as input parameter
	 * @param data      String: Cell data should be given as String
	 * @return 			boolean: This returns true/false according to the status achieved 
	 */
	public boolean setCellData(String sheetName,String colName,int rowNum, String data){
		try{
		fis = new FileInputStream(path); 
		workbook = new XSSFWorkbook(fis);

		if(rowNum<=0)
			return false;
		
		int index = workbook.getSheetIndex(sheetName);
		int colNum=-1;
		if(index==-1)
			return false;
		
		
		sheet = workbook.getSheetAt(index);
		

		row=sheet.getRow(0);
		for(int i=0;i<row.getLastCellNum();i++){
			if(row.getCell(i).getStringCellValue().trim().equals(colName))
				colNum=i;
		}
		if(colNum==-1)
			return false;

		sheet.autoSizeColumn(colNum); 
		row = sheet.getRow(rowNum-1);
		if (row == null)
			row = sheet.createRow(rowNum-1);
		
		cell = row.getCell(colNum);	
		if (cell == null)
	        cell = row.createCell(colNum);

	    
	    cell.setCellValue(data);

	    fileOut = new FileOutputStream(path);

		workbook.write(fileOut);

	    fileOut.close();	

		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	/**
	 * This is overloaded method which can be used to set the data in the given cell as per the Column name 
	 * 
	 * @param sheetName		String: Sheet name should be provided as an input
	 * @param colName		String: This requires Column name as an input 
	 * @param rowNum		integer:Row number should be provided as an input parameter 
	 * @param data			String: Data to be set in the cell
	 * @param url			String: url as input to make it as a hyperlink
	 * @return				boolean: This returns true/false according to the status achieved 
	 */
	public boolean setCellData(String sheetName,String colName,int rowNum, String data,String url){
		
		try{
		fis = new FileInputStream(path); 
		workbook = new XSSFWorkbook(fis);

		if(rowNum<=0)
			return false;
		
		int index = workbook.getSheetIndex(sheetName);
		int colNum=-1;
		if(index==-1)
			return false;
		
		
		sheet = workbook.getSheetAt(index);
		
		row=sheet.getRow(0);
		for(int i=0;i<row.getLastCellNum();i++){
			
			if(row.getCell(i).getStringCellValue().trim().equalsIgnoreCase(colName))
				colNum=i;
		}
		
		if(colNum==-1)
			return false;
		sheet.autoSizeColumn(colNum); 
		row = sheet.getRow(rowNum-1);
		if (row == null)
			row = sheet.createRow(rowNum-1);
		
		cell = row.getCell(colNum);	
		if (cell == null)
	        cell = row.createCell(colNum);
			
	    cell.setCellValue(data);
	    XSSFCreationHelper createHelper = workbook.getCreationHelper();

	    //cell style for hyperlinks
	    
	    CellStyle hlink_style = workbook.createCellStyle();
	    XSSFFont hlink_font = workbook.createFont();
	    hlink_font.setUnderline(XSSFFont.U_SINGLE);
	    hlink_font.setColor(IndexedColors.BLUE.getIndex());
	    hlink_style.setFont(hlink_font);
	    //hlink_style.setWrapText(true);

	    XSSFHyperlink link = createHelper.createHyperlink(XSSFHyperlink.LINK_FILE);
	    link.setAddress(url);
	    cell.setHyperlink(link);
	    cell.setCellStyle(hlink_style);
	      
	    fileOut = new FileOutputStream(path);
		workbook.write(fileOut);

	    fileOut.close();	

		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	/**
	 * This method adds a sheet to the workbook
	 * 
	 * @param sheetname		String: sheet name as an parameter
	 * @return				boolean: This returns true/false according to the status achieved 
	 */
	public boolean addSheet(String  sheetname){		
		
		FileOutputStream fileOut;
		try {
			 workbook.createSheet(sheetname);	
			 fileOut = new FileOutputStream(path);
			 workbook.write(fileOut);
		     fileOut.close();		    
		} catch (Exception e) {			
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	/**
	 * This method helps to remove the particular sheet from the workbook. This returns true if the sheet is
	 * removed successfully and false if the sheet doesn't exists.  
	 * 
	 * @param sheetName		String: sheet name as an parameter
	 * @return				boolean: This returns true/false according to the status achieved
	 */
	public boolean removeSheet(String sheetName){		
		int index = workbook.getSheetIndex(sheetName);
		if(index==-1)
			return false;
		
		FileOutputStream fileOut;
		try {
			workbook.removeSheetAt(index);
			fileOut = new FileOutputStream(path);
			workbook.write(fileOut);
		    fileOut.close();		    
		} catch (Exception e) {			
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	/**
	 * This method is used to add a column in the sheet specified
	 * 
	 * @param sheetName		String: sheet name as an parameter
	 * @param colName		String: Column name as a parameter
	 * @return				boolean: This returns true/false according to the status achieved
	 */
	public boolean addColumn(String sheetName,String colName){
		
		
		try{				
			fis = new FileInputStream(path); 
			workbook = new XSSFWorkbook(fis);
			int index = workbook.getSheetIndex(sheetName);
			if(index==-1)
				return false;
			
		XSSFCellStyle style = workbook.createCellStyle();
		style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		
		sheet=workbook.getSheetAt(index);
		
		row = sheet.getRow(0);
		if (row == null)
			row = sheet.createRow(0);
		
		
		if(row.getLastCellNum() == -1)
			cell = row.createCell(0);
		else
			cell = row.createCell(row.getLastCellNum());
	        
	        cell.setCellValue(colName);
	        cell.setCellStyle(style);
	        
	        fileOut = new FileOutputStream(path);
			workbook.write(fileOut);
		    fileOut.close();		    

		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		return true;
		
		
	}
	
	
	
	/**
	 * This method is used to remove the column and all its contents from the sheet specified 
	 * 
	 * @param sheetName		String: sheet name as an parameter
	 * @param colNum		Integer: Column number as an input parameter
	 * @return				boolean: This returns true/false according to the status achieved
	 */
	public boolean removeColumn(String sheetName, int colNum) {
		try{
		if(!isSheetExist(sheetName))
			return false;
		fis = new FileInputStream(path); 
		workbook = new XSSFWorkbook(fis);
		sheet=workbook.getSheet(sheetName);
		XSSFCellStyle style = workbook.createCellStyle();
		style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
		style.setFillPattern(HSSFCellStyle.NO_FILL);
		
	    
	
		for(int i =0;i<getRowCount(sheetName);i++){
			row=sheet.getRow(i);	
			if(row!=null){
				cell=row.getCell(colNum);
				if(cell!=null){
					cell.setCellStyle(style);
					row.removeCell(cell);
				}
			}
		}
		fileOut = new FileOutputStream(path);
		workbook.write(fileOut);
	    fileOut.close();
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
		
	}
	
	/**
	 *This method removes the content of the column but not the Column. The heading/column name 
	 *of the column remains saved.
	 * 
	 * @param sheetName		String: sheet name as an parameter
	 * @param colNum		Integer: column index as an input parameter
	 * @return				boolean: This returns true/false according to the status achieved
	 */
	public boolean removeColumncontents(String sheetName, int colNum) {
		try{
		if(!isSheetExist(sheetName))
			return false;
		fis = new FileInputStream(path); 
		workbook = new XSSFWorkbook(fis);
		sheet=workbook.getSheet(sheetName);
		XSSFCellStyle style = workbook.createCellStyle();
		style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
		style.setFillPattern(HSSFCellStyle.NO_FILL);
		
	    
	
		for(int i =1;i<getRowCount(sheetName);i++){
			row=sheet.getRow(i);	
			if(row!=null){
				cell=row.getCell(colNum);
				if(cell!=null){
					cell.setCellStyle(style);
					row.removeCell(cell);
				}
			}
		}
		fileOut = new FileOutputStream(path);
		workbook.write(fileOut);
	    fileOut.close();
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
		
	}
	

	/**
	 * This method checks whether the sheet is present in the workbook
	 * 
	 * @param sheetName		String: sheet name as an parameter
	 * @return				boolean: This returns true/false according to the status achieved
	 */
	public boolean isSheetExist(String sheetName){
		int index = workbook.getSheetIndex(sheetName);
		if(index==-1){
			index=workbook.getSheetIndex(sheetName.toUpperCase());
				if(index==-1)
					return false;
				else
					return true;
		}
		else
			return true;
	}
	
	/**
	 * This method returns number of columns in the particular sheet
	 * 
	 * @param sheetName		String: sheet name as an parameter
	 * @return				Integer: returns the total number of columns present in the sheet
	 */
	public int getColumnCount(String sheetName){
		// check if sheet exists
		if(!isSheetExist(sheetName))
		 return -1;
		
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(0);
		
		if(row==null)
			return -1;
		
		return row.getLastCellNum();
		
		
		
	}
	
	/**
	 * This method returns the row number of the particular cell found by value of the cell. 
	 * 
	 * @param sheetName		String: sheet name as an parameter
	 * @param colName		String: column name as a parameter in which the cell value will be searched.
	 * @param cellValue		String: Value of the cell to be passed 
	 * @return				integer: returns the row number found, if not found -1 will be the return value 
	 */
	public int getCellRowNum(String sheetName,String colName,String cellValue){
		
		for(int i=2;i<=getRowCount(sheetName);i++){
	    	if(getCellData(sheetName,colName , i).equalsIgnoreCase(cellValue)){
	    		return i;
	    	}
	    }
		return -1;
		
	}
		
	
	
	/**
	 * This method helps us to set the data in the paticular cell and sets background colour and font colour. 
	 * 
	 * @param sheetName			String: sheet name as an parameter
	 * @param colName			String: Column name as a parameter
	 * @param rowNum			Integer: Row number as parameter 
	 * @param data				String: Provide the data to be set in the cell
	 * @param backgroundColour	String: background colour to be given as parameter
	 * 									colours present are RED, GREEN, WHITE 
	 * @param fontColour		String: font colour need to be given as parameter
	 * 									colours present are RED, GREEN, WHITE, BLACK
	 * @return					Boolean: This method returns true/false as per the operation performed
	 */
	public boolean setCellDataColourAndFont(String sheetName,String colName,int rowNum, String data, 
			String backgroundColour, String fontColour){
		
			try{
			fis = new FileInputStream(path); 
			workbook = new XSSFWorkbook(fis);

			if(rowNum<=0)
				return false;
			
			int index = workbook.getSheetIndex(sheetName);
			int colNum=-1;
			if(index==-1)
				return false;
			
			
			sheet = workbook.getSheetAt(index);
			

			row=sheet.getRow(0);
			for(int i=0;i<row.getLastCellNum();i++){
				//System.out.println(row.getCell(i).getStringCellValue().trim());
				if(row.getCell(i).getStringCellValue().trim().equals(colName))
					colNum=i;
			}
			if(colNum==-1)
				return false;

			sheet.autoSizeColumn(colNum); 
			row = sheet.getRow(rowNum-1);
			if (row == null)
				row = sheet.createRow(rowNum-1);
			
			cell = row.getCell(colNum);	
			if (cell == null)
		        cell = row.createCell(colNum);

			cell=setCellColour(cell, backgroundColour, fontColour);
		    cell.setCellValue(data);

		    fileOut = new FileOutputStream(path);

			workbook.write(fileOut);

		    fileOut.close();	

			}
			catch(Exception e){
				e.printStackTrace();
				return false;
			}
			return true;
		}

		/**
		 * This method sets colour for a cell both for background colour and for font colour
		 * 
		 * @param cell				XSSFCell: need to particular cell instance
		 * @param backgroundColour	String: Background colour need to be given as parameter
		 * @param fontColour		String: Font colour as a parameter need to be given
		 * @return					XSSFCell: returns the same XSSFCell instance
		 */
		public XSSFCell setCellColour(XSSFCell cell, String backgroundColour,
		String fontColour) {

			CellStyle style = workbook.createCellStyle();
			if(backgroundColour.equalsIgnoreCase("RED"))
				style.setFillForegroundColor(IndexedColors.RED.getIndex());
			if(backgroundColour.equalsIgnoreCase("GREEN"))
				style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
			if(backgroundColour.equalsIgnoreCase("WHITE"))	
				style.setFillForegroundColor(IndexedColors.WHITE.getIndex());

			style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		    XSSFFont font = workbook.createFont();
	        
		    if(fontColour.equalsIgnoreCase("RED"))
		    	font.setColor(IndexedColors.RED.getIndex());
			if(fontColour.equalsIgnoreCase("GREEN"))
				font.setColor(IndexedColors.GREEN.getIndex());
			if(fontColour.equalsIgnoreCase("WHITE"))	
				font.setColor(IndexedColors.WHITE.getIndex());
			if(fontColour.equalsIgnoreCase("BLACK"))	
				font.setColor(IndexedColors.BLACK.getIndex());
			
	        style.setFont(font);
	        cell.setCellStyle(style);
		
			return cell;
		}
	
		/**
		 * This method is used to get all the testcase Data in the row if TESTCASE ID is provided
		 *  
		 * @param sheetName     String- Sheet name should be provided
		 * @param testCaseName  String- TestCase ID should be metioned which will fetch all the data from that row
		 * @return				LinkedHashMap- Key-Column Header Value- Teat Case Data
		 */
		public LinkedHashMap<String, String> getTestCaseData(String sheetName, String testCaseName){
			
			LinkedHashMap<String,String> map = new LinkedHashMap<String, String>();
			int testCaseRowNum=getCellRowNum(sheetName, "TestCaseID", testCaseName);
			int columnCount=getColumnCount(sheetName);
			for(int i=1;i<columnCount;i++){
			map.put(getCellData(sheetName, i, 1),getCellData(sheetName, i, testCaseRowNum));
			}
			
			return map;
		}
		
}
