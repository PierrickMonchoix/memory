package com.pierrickmonchoix.memoryserver.dao.exel;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import com.pierrickmonchoix.memoryserver.dao.entity.PersonneEntity;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PersonnePoiDAO extends AbstractPoiDAO<PersonneEntity>{

	private static Logger LOGGER = Logger.getLogger(PersonnePoiDAO.class.getName());
	
	@Override
	public Optional<PersonneEntity> getById(int id) {
		XSSFWorkbook bdd = openBase();
		Sheet tableper = bdd.getSheet("Personnes");
		Iterator<Row> iterator = tableper.iterator();
		iterator.next();
		boolean trouve = false;
		PersonneEntity personne = null;
		while (iterator.hasNext() && !trouve) {
			Row ligne = iterator.next();
			personne = new PersonneEntity();
			if (id == (int)ligne.getCell(0).getNumericCellValue()) {
				personne.setId((int)ligne.getCell(0).getNumericCellValue());
				personne.setPseudo((String)ligne.getCell(1).getStringCellValue());
				trouve = true;
			}
		}
		if (trouve) {
			return Optional.of(personne);
		}
		return Optional.empty();		
	}
	
	@Override
	public Optional<PersonneEntity> getByValue(PersonneEntity elem) {
		List<PersonneEntity> listtemp = getAll();
		for (PersonneEntity ad : listtemp) {
			if (ad.equals(elem)) {  // le equals ne check pas l'id biensur
				return Optional.of(ad);
			}
		}
		return Optional.empty();
	}

    //TODO

    @Override
	public List<PersonneEntity> getAll() {
		XSSFWorkbook bdd = openBase();
		Sheet tableper = bdd.getSheet("Personnes");
		ArrayList<PersonneEntity> listeper = new ArrayList<PersonneEntity>();
		Iterator<Row> iterator = tableper.iterator();
		iterator.next();
		while (iterator.hasNext()) {
			Row ligne = iterator.next();
			PersonneEntity personne = new PersonneEntity();
			Iterator<Cell> cellIterator = ligne.iterator();
  			Cell cellule = cellIterator.next();
            personne.setId((int)cellule.getNumericCellValue());
            personne.setPseudo((String)ligne.getCell(1).getStringCellValue());  

			listeper.add(personne);
		}
		return listeper;
	}

	@Override
	public void create(PersonneEntity elem) {
		if (getByValue(elem).isEmpty()) {
			XSSFWorkbook bdd = openBase();
			Sheet tableper = bdd.getSheet("Personnes");
			int lrow = tableper.getLastRowNum();
			int lid = (int) tableper.getRow(lrow).getCell(0).getNumericCellValue();
			elem.setId(lid + 1);
			Row ligne = tableper.createRow(lrow + 1);
			Cell cell = ligne.createCell(0);
			cell.setCellValue(elem.getId());
			cell = ligne.createCell(1);
			cell.setCellValue(elem.getPseudo());
			cell = ligne.createCell(2);
			writeBase(bdd);
		} else {
			//TODO : Prévoir une exception ...
			LOGGER.info("Element Deja dans la base ...");
		}
	}

	@Override
	public void update(PersonneEntity elem) {
		XSSFWorkbook bdd = openBase();
		Sheet tableper = bdd.getSheet("Personnes");
		Iterator<Row> iterator = tableper.iterator();
		iterator.next();
		boolean trouve = false;
		while (iterator.hasNext() && !trouve) {
			Row ligne = iterator.next();
			if (elem.getId() == (int) ligne.getCell(0).getNumericCellValue()) {
				trouve = true;
				ligne.getCell(1).setCellValue(elem.getPseudo());
				writeBase(bdd);
			}
		}
		if (!trouve) {
			//TODO : Prévoir une exception ...
			LOGGER.info("Element absent de la base ...");
		}
	}

	@Override
	public void delete(PersonneEntity elem) {
		XSSFWorkbook bdd = openBase();
		Sheet tableper = bdd.getSheet("Personnes");
		Iterator<Row> iterator = tableper.iterator();
		iterator.next();
		boolean trouve = false;
		while (iterator.hasNext() && !trouve) {
			Row ligne = iterator.next();
			if (elem.getId() == (int) ligne.getCell(0).getNumericCellValue()) {
				trouve = true;
				removeRow(tableper, ligne.getRowNum());
				writeBase(bdd);
			}
		}
		if (!trouve) {
			//TODO : Prévoir une exception ...
			LOGGER.info("Element absent de la base ...");
		}
	}

    @Override
    public boolean isExisting(PersonneEntity elem) {
        List<PersonneEntity> listtemp = getAll();
		for (PersonneEntity ad : listtemp) {
			if (ad.equals(elem)) {  // le equals ne check pas l'id biensur
				return true;
			}
		}
		
        return false;
    }




	
	
}
