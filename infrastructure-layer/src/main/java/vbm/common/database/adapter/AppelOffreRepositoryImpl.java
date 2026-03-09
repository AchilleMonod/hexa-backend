package vbm.common.database.adapter;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import vbm.common.database.dao.AppelOffreDAO;
import vbm.common.database.mapper.AppelOffreEntityMapper;
import vbm.common.model.AppelOffreBO;
import vbm.common.port.AppelOffreRepository;

import java.util.List;

@Repository
@AllArgsConstructor
public class AppelOffreRepositoryImpl implements AppelOffreRepository {

    private final AppelOffreDAO appelOffreDAO;

    private final AppelOffreEntityMapper appelOffreEntityMapper;

    @Override
    public List<AppelOffreBO> getAllAppelOffreByBureauId(Long id) {
        return appelOffreDAO.findByBureauEtudeId(id)
                .stream()
                .map(appelOffreEntityMapper::toBO)
                .toList();
    }

    @Override
    public AppelOffreBO getById(Long id) {
        return appelOffreEntityMapper.toBO(appelOffreDAO.findById(id).orElse(null));
    }
}
