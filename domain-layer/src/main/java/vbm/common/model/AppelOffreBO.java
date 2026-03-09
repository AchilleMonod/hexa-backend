package vbm.common.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class AppelOffreBO {
    private String id;
    private String nom;
    private String description;
    private String dateDebut;
    private String dateFin;
    private String statut;
}
