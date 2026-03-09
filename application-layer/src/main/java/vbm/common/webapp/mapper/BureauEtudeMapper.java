package vbm.common.webapp.mapper;

import org.mapstruct.Mapper;
import vbm.common.model.BureauEtudeBO;
import vbm.common.webapp.model.BureauEtudeDTO;


@Mapper(componentModel = "spring")
public interface BureauEtudeMapper {

    BureauEtudeBO map(BureauEtudeDTO bureauEtudeDTO);
}
