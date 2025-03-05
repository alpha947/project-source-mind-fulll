package com.sourcemind.pfe.istock.core.exceptions;
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
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@JsonPropertyOrder({"code", "status", "error"})
@ToString
public class CustomExceptionResponse {

	private HttpStatus status;
	private List<String> error;
	private int code;
	private String message;

	public static final String ERROR_OCCURRED = "Une erreur s'est produite";


	public CustomExceptionResponse(HttpStatus status, List<String> error, int code) {
		this.status = status;
		this.error = error;
		this.code = code;
		this.message = ERROR_OCCURRED;
	}

	public CustomExceptionResponse(HttpStatus status, List<String> error, int code, String message) {
		this.status = status;
		this.error = error;
		this.code = code;
		this.message = message == null ? ERROR_OCCURRED : message;
	}
}