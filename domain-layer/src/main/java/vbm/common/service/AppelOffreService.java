package vbm.common.service;

import vbm.common.model.AppelOffreBO;
import vbm.common.model.BureauEtudeBO;

import java.util.List;

public interface AppelOffreService {

    List<AppelOffreBO> getAllAppelOffre(BureauEtudeBO bureauEtude);
}
