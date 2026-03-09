package vbm.common.port;

import vbm.common.model.AppelOffreBO;

import java.util.List;

public interface AppelOffreRepository {

    List<AppelOffreBO> getAllAppelOffreByBureauId(Long id);

    AppelOffreBO getById(Long id);
}
