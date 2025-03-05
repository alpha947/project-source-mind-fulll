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

import org.hibernate.LazyInitializationException;
import org.hibernate.TransientPropertyValueException;
import org.hibernate.exception.SQLGrammarException;
import org.modelmapper.MappingException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.util.ObjectUtils;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.UnexpectedTypeException;
import java.net.ConnectException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@ControllerAdvice
public class CustomExceptionHandler extends RuntimeException {
        public static final String ERROR_OCCURRED = "Une erreur s'est produite";
        public static final String ERROR_VALIDATION = "Nous craignons que vous ayez oublié quelque chose :";
        public static final String INTERNAL_ERROR_OCCURRED = "Veuillez réessayer plus tard, quelque chose s'est mal passé et ce n'est pas de votre faute.";
        public static final String ERROR_DUPLICATE = "Oups, il y a un doublon";
        public static final String ERROR_BAD_CREDENTIALS = "Identifiants invalides";
        public static final String CONNECTION_EXCEPTION = "La connexion à un tiers a échoué.";

    //	@ExceptionHandler(value = SqlExceptionHelper.class)
    //	public ResponseEntity<Object> handleRuntimeException(SqlExceptionHelper exception) {
    //		HttpStatus badRequest = INTERNAL_SERVER_ERROR;
    //		return ResponseEntity.badRequest().body(
    //				new CustomExceptionResponse(badRequest, List.of(exception.getMessage()), badRequest.value(),
    //				                            INTERNAL_ERROR_OCCURRED
    //				));
    //
    //	}

    @ExceptionHandler(value = SQLGrammarException.class)
    public ResponseEntity<Object> handleSQLGrammarException(SQLGrammarException exception) {
        HttpStatus badRequest = INTERNAL_SERVER_ERROR;
        return ResponseEntity.badRequest().body(
                new CustomExceptionResponse(badRequest, List.of(INTERNAL_SERVER_ERROR.getReasonPhrase()), badRequest.value(),
                        INTERNAL_ERROR_OCCURRED
                ));

    }

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<Object> handleRuntimeException(RuntimeException exception) {
        HttpStatus badRequest = INTERNAL_SERVER_ERROR;
        return ResponseEntity.badRequest().body(
                new CustomExceptionResponse(badRequest, List.of(exception.getMessage()), badRequest.value(),
                        INTERNAL_ERROR_OCCURRED
                ));

    }

    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException exception) {
        HttpStatus error = HttpStatus.UNAUTHORIZED;
        return ResponseEntity.badRequest().body(
                new CustomExceptionResponse(error, List.of(exception.getMessage()), error.value(),
                        INTERNAL_ERROR_OCCURRED
                ));

    }

    @ExceptionHandler(value = TransientPropertyValueException.class)
    public ResponseEntity<Object> handleETransientPropertyValueException(TransientPropertyValueException exception) {
        HttpStatus error = HttpStatus.UNAUTHORIZED;
        return ResponseEntity.badRequest().body(
                new CustomExceptionResponse(error, List.of(exception.getMessage()), error.value(),
                        ERROR_VALIDATION
                ));

    }

    @ExceptionHandler(value = MappingException.class)
    public ResponseEntity<Object> handleMappingException(MappingException exception) {
        HttpStatus error = HttpStatus.INTERNAL_SERVER_ERROR;
        return ResponseEntity.badRequest().body(
                new CustomExceptionResponse(error, List.of(exception.getMessage()), error.value(),
                        INTERNAL_ERROR_OCCURRED
                ));

    }

    @ExceptionHandler(value = org.springframework.web.method.annotation.MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Object> handleMethodArgumentTypeMismatchException(
            MethodArgumentTypeMismatchException exception
    ) {
        HttpStatus error = BAD_REQUEST;
        String message = exception.getLocalizedMessage();
        return ResponseEntity.badRequest().body(
                new CustomExceptionResponse(error, List.of(message), error.value(),
                        INTERNAL_ERROR_OCCURRED
                ));

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomExceptionResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<String> err = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> err.add(error.getDefaultMessage()));
        HttpStatus badRequest = BAD_REQUEST;
        return ResponseEntity.badRequest().body(
                new CustomExceptionResponse(badRequest, err, badRequest.value(), ERROR_VALIDATION));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<CustomExceptionResponse> handleHttpMessageNotReadableExceptions(
            HttpMessageNotReadableException ex
    ) {
        List<String> err = new ArrayList<>();
        String message = ex.getMessage();
        if (message != null) {
            String[] split = message.split(":");
            err.add(split[0]);
        } else {
            err.add("La requête HTTP n'est pas lisible ou le paramètre requis est manquant");
        }
        HttpStatus badRequest = BAD_REQUEST;
        return ResponseEntity.badRequest().body(
                new CustomExceptionResponse(badRequest, err, badRequest.value(), ERROR_VALIDATION));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<CustomExceptionResponse> handleConstraintViolationException(
            ConstraintViolationException ex
    ) {
        List<String> err = ex.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(
                Collectors.toList());
        HttpStatus badRequest = BAD_REQUEST;
        return ResponseEntity.badRequest().body(new CustomExceptionResponse(badRequest, err, badRequest.value()));
    }


    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<CustomExceptionResponse> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        String errorMessage = "Une erreur s'est produite lors du traitement de votre demande.";
        String message = ERROR_OCCURRED;

        String exMessage = ex.getMostSpecificCause().getMessage();
        if (exMessage.contains("Duplication de la cle") || exMessage.contains("ke")) {
            message = ERROR_DUPLICATE;
            String duplicateValue = extractDuplicateValue(exMessage);
            String duplicateColumn = extractDuplicateColumn(exMessage);
            if (duplicateValue != null) {
                errorMessage = String.format("%s: %s Existe deja", duplicateColumn, duplicateValue);
            }
        }


        List<String> err = List.of(errorMessage);
        HttpStatus badRequest = BAD_REQUEST;

        return ResponseEntity.badRequest().body(
                new CustomExceptionResponse(badRequest, err, badRequest.value(), message));
    }

    private String extractDuplicateValue(String errorMessage) {
        int startIndex = errorMessage.indexOf("'");
        int endIndex = errorMessage.indexOf("'", startIndex + 1);
        if (startIndex > 0 && endIndex > 0) {
            return errorMessage.substring(startIndex + 1, endIndex);
        }
        return null;
    }

    private String extractDuplicateColumn(String errorMessage) {
        int startIndex = errorMessage.indexOf("(");
        int endIndex = errorMessage.indexOf("NULLS", startIndex + 1);
        if (startIndex > 0 && endIndex > 0) {
            var message = errorMessage.substring(startIndex + 1, endIndex - 1).replaceAll("_", " ").toLowerCase();
            return message.substring(0, 1).toUpperCase() + message.substring(1);
        }
        return null;
    }

 

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<CustomExceptionResponse> handleResponseStatusException(ResponseStatusException ex) {
        HttpStatus status = ex.getStatus();
        int code = status.value();
        String reason = ex.getReason() != null ? ex.getReason() : "Unsatisfied Input";
        return ResponseEntity.badRequest().body(new CustomExceptionResponse(status, List.of(reason), code));
    }
 

    @ExceptionHandler(LazyInitializationException.class)
    public ResponseEntity<CustomExceptionResponse> handleInternalLazyInitializationException(
            LazyInitializationException ex
    ) {
        HttpStatus status = HttpStatus.FAILED_DEPENDENCY;
        int code = status.value();
        String reason = ex.getCause().getMessage() != null ? ex.getCause()
                .getMessage() : "Impossible de charger les dépendances de manière différée";

        return ResponseEntity.status(status).body(
                new CustomExceptionResponse(status, List.of(reason), code));
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<CustomExceptionResponse> handleHttpMediaTypeNotSupportedException(
            HttpMediaTypeNotSupportedException ex
    ) {
        HttpStatus status = HttpStatus.UNSUPPORTED_MEDIA_TYPE;
        int code = status.value();
        String reason = ex.getMessage() != null ? ex.getMessage() : "Nous ne pouvons pas comprendre votre type de média de demande";

        return ResponseEntity.status(status).body(
                new CustomExceptionResponse(status, List.of(reason), code));
    }

    @ExceptionHandler(UnexpectedTypeException.class)
    public ResponseEntity<CustomExceptionResponse> handleUnexpectedTypeException(UnexpectedTypeException ex) {
        HttpStatus status = HttpStatus.EXPECTATION_FAILED;
        int code = status.value();
        String reason = ex.getMessage() != null ? ex.getMessage() : "Inadéquation des attentes de type";

        return ResponseEntity.status(status).body(
                new CustomExceptionResponse(status, List.of(reason), code));
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<CustomExceptionResponse> handleNullPointerException(NullPointerException ex) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        int code = status.value();
        String reason = ex.getMessage() != null ? ex.getMessage() : "Inadéquation des attentes de type";
        return ResponseEntity.status(status).body(
                new CustomExceptionResponse(status, List.of(reason), code));
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<CustomExceptionResponse> handleHttpRequestMethodNotSupportedException(
            HttpRequestMethodNotSupportedException ex
    ) {
        HttpStatus status = HttpStatus.METHOD_NOT_ALLOWED;
        int code = status.value();
        String reason = ex.getMessage() != null ? ex.getMessage() : "La méthode n'est pas autorisée sur cet itinéraire";

        return ResponseEntity.status(status).body(
                new CustomExceptionResponse(status, List.of(reason), code));
    }

    @ExceptionHandler(TokenValidationException.class)
    public ResponseEntity<CustomExceptionResponse> handleTokenExpiredException(TokenValidationException ex) {
        HttpStatus status = HttpStatus.UNAUTHORIZED;
        int code = status.value();
        String message = ex.getMessage();
        return ResponseEntity.status(status).body(new CustomExceptionResponse(status, List.of(message), code));
    }

    @ExceptionHandler(InvalidDataAccessApiUsageException.class)
    public ResponseEntity<CustomExceptionResponse> handleInvalidDataAccessApiUsageException(
            InvalidDataAccessApiUsageException ex
    ) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        int code = status.value();
        String message = ex.getMessage();
        return ResponseEntity.status(status).body(new CustomExceptionResponse(status, List.of(message), code));

    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<CustomExceptionResponse> handleMissingServletRequestParameterException(
            MissingServletRequestParameterException ex
    ) {
        HttpStatus status = BAD_REQUEST;
        int code = status.value();
        String message = ex.getMessage();

        return ResponseEntity.status(status).body(new CustomExceptionResponse(status, List.of(message), code));
    }

    @ExceptionHandler(ResourceAccessException.class)
    public ResponseEntity<CustomExceptionResponse> handleResourceAccessExceptionException(
            ResourceAccessException ex
    ) {
        String message = ex.getMessage();
        HttpStatus status;
        if (message != null && message.toLowerCase().contains("Connection refusee".toLowerCase())) {
            status = HttpStatus.BAD_GATEWAY;
            message = CONNECTION_EXCEPTION;
            return ResponseEntity.status(status).body(
                    new CustomExceptionResponse(status, List.of(message), status.value()));
        }
        status = HttpStatus.UNAUTHORIZED;
        return ResponseEntity.status(status).body(
                new CustomExceptionResponse(status, List.of(message), status.value()));
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<CustomExceptionResponse> handleHttpClientErrorException(HttpClientErrorException ex) {
        HttpStatus statusCode = ex.getStatusCode();
        HttpStatus status = !ObjectUtils.isEmpty(statusCode) ? statusCode : HttpStatus.UNAUTHORIZED;
        int code = status.value();
        String message = ex.getMessage();
        assert message != null;

        return ResponseEntity.status(status).body(new CustomExceptionResponse(status, List.of(message), code));
    }

    @ExceptionHandler(RestClientException.class)
    public ResponseEntity<CustomExceptionResponse> handleRestClientException(RestClientException ex) {
        HttpStatus status = HttpStatus.BAD_GATEWAY;
        int code = status.value();
        return ResponseEntity.status(status).body(new CustomExceptionResponse(status, List.of(
                CONNECTION_EXCEPTION), code));
    }

    @ExceptionHandler(HttpStatusCodeException.class)
    public ResponseEntity<CustomExceptionResponse> handleHttpStatusCodeException(HttpStatusCodeException ex) {
        HttpStatus status = ex.getStatusCode();
        int code = status.value();
        return ResponseEntity.status(status).body(
                new CustomExceptionResponse(status, List.of(CONNECTION_EXCEPTION), code));
    }

    @ExceptionHandler(ConnectException.class)
    public ResponseEntity<CustomExceptionResponse> handleConnectException(ConnectException ex) {
        HttpStatus status = HttpStatus.BAD_GATEWAY;

        return ResponseEntity.status(status).body(
                new CustomExceptionResponse(
                        status, List.of(CONNECTION_EXCEPTION), status.value()));
    }

}