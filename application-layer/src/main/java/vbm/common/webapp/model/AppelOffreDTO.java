package vbm.common.webapp.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class AppelOffreDTO {

    @NotNull
    @Schema(description = "Identifiant de l'appel d'offre", example = "1")
    private String id;

    private String nom;
    private String description;
    private String dateDebut;
    private String dateFin;
    private String statut;

}
