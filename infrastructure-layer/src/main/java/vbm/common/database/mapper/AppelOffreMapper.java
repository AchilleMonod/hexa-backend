package vbm.common.database.mapper;

import org.mapstruct.Mapper;
import vbm.common.database.entities.AppelOffreEntity;
import vbm.common.model.AppelOffreBO;

@Mapper(componentModel = "spring")
public interface AppelOffreMapper {

    AppelOffreBO toBO(AppelOffreEntity appelOffreEntity);

    AppelOffreEntity toEntity(AppelOffreBO appelOffreBO);
}
