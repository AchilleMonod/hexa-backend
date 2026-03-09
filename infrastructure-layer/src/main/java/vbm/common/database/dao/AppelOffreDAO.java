package vbm.common.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vbm.common.database.entities.AppelOffreEntity;

import java.util.List;

@Repository
public interface AppelOffreDAO extends JpaRepository<AppelOffreEntity, Long> {

    List<AppelOffreEntity> findByBureauEtudeId(Long bureauEtudeId);
}
