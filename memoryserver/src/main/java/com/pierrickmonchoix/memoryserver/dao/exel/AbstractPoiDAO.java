package com.pierrickmonchoix.memoryserver.dao.exel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.pierrickmonchoix.memoryserver.dao.IDao;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public abstract class AbstractPoiDAO<T> implements IDao<T> {

	//private static final String FILE__NAME = System.getProperty("user.home") + "/memorydata/BDD.xlsx";
	private static final String FILE__NAME = System.getProperty("user.dir") + "/memoryserver/database/BDD.xlsx";
	
	protected XSSFWorkbook openBase() {
		try {
			FileInputStream excelFile = new FileInputStream(new File(FILE__NAME));  // create strem of a file
			return new XSSFWorkbook(excelFile);   // create exel java object from an input file stream
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	protected void writeBase(XSSFWorkbook bdd) {	 	// take exel java object
		try {
			FileOutputStream output = new FileOutputStream(FILE__NAME);     // create output file stream
			bdd.write(output);     // white data of exel java object IN the output file stream (modifying the file)
			bdd.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected static void removeRow(Sheet sheet, int rowIndex) {
	    int lastRowNum = sheet.getLastRowNum();
	    if (rowIndex >= 0 && rowIndex < lastRowNum) {
	        sheet.shiftRows(rowIndex + 1, lastRowNum, -1);   // remonte le tablea du bas d'une case (si on removeRow ca fait un trou)
	    }
	    if (rowIndex == lastRowNum) {
	        Row removingRow = sheet.getRow(rowIndex);
	        if (removingRow != null) {
	            sheet.removeRow(removingRow);
	        }
	    }
	}
	
}
