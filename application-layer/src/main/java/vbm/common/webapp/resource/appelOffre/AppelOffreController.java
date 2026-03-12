package vbm.common.webapp.resource.appelOffre;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vbm.common.model.AppelOffreBO;
import vbm.common.service.AppelOffreService;
import vbm.common.webapp.mapper.BureauEtudeMapper;
import vbm.common.webapp.model.BureauEtudeDTO;

import java.util.List;

@Validated
@AllArgsConstructor
@RestController
@RequestMapping(value="/appelOffre", produces = "application/json")
public class AppelOffreController {

    private final AppelOffreService appelOffreService;

    private final BureauEtudeMapper bureauEtudeMapper;

    @GetMapping
    @Operation(summary = "Get all appelOffre")
    @ApiResponse(responseCode = "200", description = "Liste des appels d'offres")
    @ApiResponse(responseCode = "204", description = "Aucun appel d'offre trouvé")
    @ApiResponse(responseCode = "400", description = "Bad Request")
    //@PreAuthorize("hasRole('ADMIN')") gestion spring secu a étudier
    public ResponseEntity<List<AppelOffreBO>> getAllAppelOffre(@RequestBody BureauEtudeDTO bureauEtudeDTO){

        List<AppelOffreBO> response = appelOffreService.getAllAppelOffre(bureauEtudeMapper.map(bureauEtudeDTO));
        if(response.isEmpty()){
            return ResponseEntity.noContent().build(); // Retourne 204 au lieu de lever une exception
        }
        return ResponseEntity.ok(response);
    }
}
