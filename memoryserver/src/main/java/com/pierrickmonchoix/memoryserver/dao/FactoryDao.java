package com.pierrickmonchoix.memoryserver.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import com.pierrickmonchoix.memoryserver.business.Personne;
import com.pierrickmonchoix.memoryserver.dao.entity.PersonneEntity;
import com.pierrickmonchoix.memoryserver.dao.exel.PersonnePoiDAO;



public class FactoryDao {

    private static IDao<PersonneEntity> personneDAO = new PersonnePoiDAO();

 



    public static void deletePersonne(Personne personne){
        personneDAO.delete(getPersonneEntityFromPersonne(personne));;
    }

    public static boolean isExisting(Personne personne){
        return personneDAO.isExisting(getUncompletePersonneEntityFromPersonne(personne));
    }


    public static List<Personne> getAllPersonne() {
        List<PersonneEntity> listPersonneEntity = personneDAO.getAll();
        List<Personne> listPersonne = new ArrayList<Personne>();

        for (PersonneEntity personneEntity : listPersonneEntity) {
            Personne personne = new Personne(personneEntity.getPseudo());
            listPersonne.add(personne);
        }
        return listPersonne;
    }

/*     public static Personne getNewPersonneByNomPrenom(String nom , String prenom){
        PersonneEntity personneEntityNonComplete = new PersonneEntity();  //manquera id
        personneEntityNonComplete.setPseudo(nom);
        Optional<PersonneEntity> resultat = personneDAO.getByValue(personneEntityNonComplete);
        assert (resultat.isPresent());
        PersonneEntity personneEntityComplete = resultat.get();
        return getNewPersonneFromPersonneEntity(personneEntityComplete);
    } */

    public static Personne getPersonneFromPersonneEntity(PersonneEntity personneEntity){
        return new Personne(personneEntity.getPseudo());
    }

    public static PersonneEntity getUncompletePersonneEntityFromPersonne(Personne personne){
        PersonneEntity personneEntity = new PersonneEntity();
        personneEntity.setPseudo(personne.getPseudo());
        return personneEntity;
    }

    public static void createPersonne(Personne personne){
        personneDAO.create(getUncompletePersonneEntityFromPersonne(personne));
    }

    private static PersonneEntity getPersonneEntityFromPersonne(Personne personne){
        PersonneEntity personneEntityNonComplete = getUncompletePersonneEntityFromPersonne(personne);
        Optional<PersonneEntity> resultat = personneDAO.getByValue(personneEntityNonComplete);
        assert (resultat.isPresent());
        PersonneEntity personneEntityComplete = resultat.get();
        return personneEntityComplete;
    }



}
