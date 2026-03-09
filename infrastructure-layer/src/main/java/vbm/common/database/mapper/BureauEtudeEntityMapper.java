package vbm.common.database.mapper;

import org.mapstruct.Mapper;
import vbm.common.database.entities.BureauEtudeEntity;
import vbm.common.model.BureauEtudeBO;

@Mapper(componentModel = "spring")
public interface BureauEtudeEntityMapper {

    BureauEtudeBO toBO(BureauEtudeEntity bureauEtudeEntity);
}
