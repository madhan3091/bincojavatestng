package com.utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadProperties {
	
	
	
		private static XSSFSheet ExcelWSheet;
		private static XSSFWorkbook ExcelWBook;
		private static XSSFCell Cell;
		private static XSSFRow Row;
		
	    
//This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method
	
		public static void setExcelFile() throws IOException 
		{
			
	      // Open the Excel file
			try{
				FileInputStream ExcelFile = new FileInputStream(System.getProperty("user.dir")+"\\TestData.xlsx");
				
				// Access the required test data sheet
				
				ExcelWBook = new XSSFWorkbook(ExcelFile);
				
				ExcelWSheet = ExcelWBook.getSheet("Sheet1");
				
			}catch (Exception e){

				throw (e);

			}

			
			//Row row;
			//Cell cell;
			
		}
		public static String getCellData(int RowNum, int ColNum) throws Exception
		 {
	
		   try
		   {
			   if(ExcelWSheet==null)
			   {
				   setExcelFile();
			   }
		
		       Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
		       String CellData = Cell.toString();   
		       String num=CellData.replaceAll("\\.0*$", "");
		       System.out.println(num);
		
		       return num;
		
		       }catch (Exception e){
		
		    	   return"";
		
		       }
		 }
		/*
		Iterator<Row> rowIterator = sheet.iterator();{
			while(rowIterator.hasNext()){
				row=rowIterator.next();
				
				Iterator<Cell> cellIterator = row.cellIterator();
				while(cellIterator.hasNext()){
					cell =cellIterator.next();
					
					
					DataFormatter formatter = new DataFormatter();
					String text = formatter.formatCellValue(cell);
					
					System.out.println(text);
					
					
				}
							
			}
				
		}*/
		/*  
    		//This method is to write in the Excel cell, Row num and Col num are the parameters

    		public static void setCellData(String Result,  int RowNum, int ColNum) throws Exception	{

       			try{

          			Row  = ExcelWSheet.getRow(RowNum);

					Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);

					if (Cell == null) {

						Cell = Row.createCell(ColNum);

						Cell.setCellValue(Result);

						} else {

							Cell.setCellValue(Result);

						}

          // Constant variables Test Data path and Test Data file name

          				FileOutputStream fileOut = new FileOutputStream(Constant.Path_TestData + Constant.File_TestData);

          				ExcelWBook.write(fileOut);

          				fileOut.flush();

 						fileOut.close();

						}catch(Exception e){

							throw (e);

					}

				} */

	
	    

}
	
 
    
    

