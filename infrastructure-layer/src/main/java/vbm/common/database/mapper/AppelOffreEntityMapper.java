package vbm.common.database.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import vbm.common.database.entities.AppelOffreEntity;
import vbm.common.model.AppelOffreBO;
import vbm.common.model.enums.StatutAppelEnum;

@Mapper(componentModel = "spring")
public interface AppelOffreEntityMapper {

    @Mapping(target = "statut", source = "statut", qualifiedByName = "stringToStatut")
    AppelOffreBO toBO(AppelOffreEntity appelOffreEntity);

    @Mapping(target = "statut", source = "statut", qualifiedByName = "statutToString")
    AppelOffreEntity toEntity(AppelOffreBO appelOffreBO);

    @Named("stringToStatut")
    default StatutAppelEnum stringToStatut(String statut) {
        if (statut == null || statut.isEmpty()) {
            return null;
        }
        try {
            return StatutAppelEnum.valueOf(statut.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    @Named("statutToString")
    default String statutToString(StatutAppelEnum statut) {
        if (statut == null) {
            return null;
        }
        return statut.name();
    }
}
