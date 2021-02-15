package com.pierrickmonchoix.memoryserver.dao.exel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Logger;

import com.pierrickmonchoix.memoryserver.dao.IDao;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 
 * FileOutputStream : un file reel exel qui peut etre modifie grace a :
 * 'xSSFWorkbook.write(fileOutputStream);' XSSFWorkbook : un file exel virtuel
 * dont on peut avoir acces a la table "Personne" par :
 * xSSFWorkbook.getSheet("Personnes"); Sheet : une table d'un file exel virtuel
 * 
 * 
 */

public abstract class AbstractPoiDAO<T> implements IDao<T> {

    private static Logger logger = Logger.getLogger(AbstractPoiDAO.class.getName());

    private static final String FILE__NAME = System.getProperty("user.dir") + "/memoryserver/database/BDD.xlsx";

    protected XSSFWorkbook openBase() {
        try {
            FileInputStream excelFile = new FileInputStream(new File(FILE__NAME)); // create strem of a file
            return new XSSFWorkbook(excelFile); // create exel java object from an input file stream
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected void writeBase(XSSFWorkbook bdd) { // take exel java object
        try {
            FileOutputStream output = new FileOutputStream(FILE__NAME); // create output file stream
            bdd.write(output); // white data of exel java object IN the output file stream (modifying the file)
            bdd.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Supprime une ligne d'un sheet, puis fait remonter le reste de la table pour
     * ne pas qu'il y ai de trous
     */
    protected static void removeRow(Sheet sheet, int rowIndex) {
        int lastRowNum = sheet.getLastRowNum();
        if (rowIndex >= 0 && rowIndex < lastRowNum) {
            logger.info("shift occurs");
            sheet.shiftRows(rowIndex + 1, lastRowNum, -1); // remonte le tablea du bas d'une case (si on removeRow ca
                                                           // fait un trou)
        }
        if (rowIndex == lastRowNum) {
            Row removingRow = sheet.getRow(rowIndex);
            if (removingRow != null) {
                sheet.removeRow(removingRow);
            }
        }
    }

    /**
     * suprimme les lignes 0 qui remontent une a unes
     */
    protected static void resetTable(Sheet sheet) {
        int lastRowNum = sheet.getLastRowNum();
        for (int i = 0; i <= lastRowNum; i++) {
            logger.info("remove row0");
            removeRow(sheet, 1);
        }
    }

}
