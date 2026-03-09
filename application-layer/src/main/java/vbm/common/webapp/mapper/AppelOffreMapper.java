package vbm.common.webapp.mapper;

import vbm.common.model.AppelOffreBO;
import vbm.common.webapp.model.AppelOffreDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface AppelOffreMapper {

    AppelOffreBO map(AppelOffreDTO adresseDTO);
}
