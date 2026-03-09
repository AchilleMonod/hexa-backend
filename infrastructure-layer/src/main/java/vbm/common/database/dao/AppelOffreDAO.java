package vbm.common.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vbm.common.database.entities.AppelOffreEntity;

@Repository
public interface AppelOffreDAO extends JpaRepository<AppelOffreEntity, Long> {

    //fonctions d'appel à la bdd
}
