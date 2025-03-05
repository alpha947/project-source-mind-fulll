/**
 * ==========================================================
 * Projet de fin d'études - SourceMind
 *
 * Développé par l'équipe Groupe 1 :
 *  - Alpha Amadou DIALLO (https://github.com/alpha947)
 *    Email : dialloalphaamadou947@gmail.com
 *  - Kouloube KOLIE (https://github.com/kouloube)
 *    Email : kouloubekolie@gmail.com
 *  - Moussa CAMARA (https://github.com/usermoussa)
 *    Email : moussaccamaraa@gmail.com
 *  - Mohamed Mouctar KABA (https://github.com/Mokaba-lab)
 *    Email : mocktarkba@gmail.com
 *
 * Ce projet Spring Boot a été conçu et développé
 * pour démontrer nos compétences techniques et
 * apporter une solution innovante.
 * ==========================================================
 */

package com.sourcemind.pfe.istock.features.authentication.data.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sourcemind.pfe.istock.features.authentication.domain.entity.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoleRequest {
    private Long id;
    @NotNull(message = "Le nom ne doit pas etre null")
    @NotEmpty(message = "Le nom ne doit pas etre vide")
    private String name;
    private String description;
    private List<PermissionRequest> permissions;
    private String createdAt;
    private Boolean isActiveStatus;

    public static RoleRequest toPartialRequest(Role role) {
        RoleRequest request = new RoleRequest();
        request.setId(role.getId());
        request.setName(role.getName());
        request.setDescription(role.getDescription());
        return request;
    }

}
