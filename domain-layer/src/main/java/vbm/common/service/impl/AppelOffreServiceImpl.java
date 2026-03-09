package vbm.common.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vbm.common.exception.AppelOffreServiceException;
import vbm.common.model.AppelOffreBO;
import vbm.common.model.BureauEtudeBO;
import vbm.common.port.AppelOffreRepository;
import vbm.common.service.AppelOffreService;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class AppelOffreServiceImpl implements AppelOffreService {

    private final AppelOffreRepository appelOffreRepository;

    @Override
    public List<AppelOffreBO> getAllAppelOffre(BureauEtudeBO bureauEtude) {
        if(bureauEtude == null || bureauEtude.getId().isBlank()){
            throw new AppelOffreServiceException("Bureau d'etude non valide");
        }
        return appelOffreRepository.getAllAppelOffre(bureauEtude.getId());
    }
}
