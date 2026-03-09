package vbm.common.database.adapter;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import vbm.common.database.dao.AppelOffreDAO;
import vbm.common.database.mapper.AppelOffreMapper;
import vbm.common.model.AppelOffreBO;
import vbm.common.port.AppelOffreRepository;

import java.util.List;

@Repository
@AllArgsConstructor
public class AppelOffreRepositoryImpl implements AppelOffreRepository {

    private final AppelOffreDAO appelOffreDAO;

    private final AppelOffreMapper appelOffreMapper;

    @Override
    public List<AppelOffreBO> getAllAppelOffreByBureauId(Long id) {
        return List.of();
    }

    @Override
    public AppelOffreBO getById(Long id) {
        return appelOffreMapper.toBO(appelOffreDAO.findById(id).orElse(null));
    }
}
