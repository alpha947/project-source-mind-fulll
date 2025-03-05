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

package com.sourcemind.pfe.istock.features.authentication.domain.entity;

import com.sourcemind.pfe.istock.core.base.BaseModel;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

import static com.sourcemind.pfe.istock.core.constants.Table.AUTH_ROLE;
import static com.sourcemind.pfe.istock.core.constants.Table.ROLE_PERMISSION_TABLE;

@Data
@Builder
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = AUTH_ROLE)
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EntityListeners(AuditingEntityListener.class)
public class Role extends BaseModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "Name cannot be null")
	@Column(unique = true, nullable = false)
	private String name;

	@Column
	private String description;


	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinTable(name = ROLE_PERMISSION_TABLE,
			joinColumns = @JoinColumn(name = "role_id"),
			inverseJoinColumns = @JoinColumn(name = "permission_id"))
	private Set<Permission> permissions;


	public Role(String name, Set<Permission> permissions) {
		this.name = name;
		this.permissions = permissions;
	}

	public Role(Long id) {
		this.id = id;
	}
}
