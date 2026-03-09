package vbm.common.database.adapter;

import vbm.common.model.AppelOffreBO;
import vbm.common.port.AppelOffreRepository;

import java.util.List;

public class AppelOffreRepositoryImpl implements AppelOffreRepository {
    @Override
    public List<AppelOffreBO> getAllAppelOffre(String id) {
        return List.of(); //appelle le DAO
    }
}
