package com.dece.userprofile.handler;

import com.dece.userprofile.dto.ErrorDTO;
import com.google.common.base.Throwables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.persistence.PersistenceException;
import java.nio.file.AccessDeniedException;
import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    private String errorMessage;
    private String errorLogMessage;

    private String authorizationFailedMessage = "Authorization Failed";
    private String invalidRequestMessage = "Unable to Process Request";

    /**
     * Return http status 400 with custom exception when validation fails
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(CustomException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorDTO invalidDataException(CustomException ex) {
        logger.error(invalidRequestMessage, ex);

        return createError(HttpStatus.BAD_REQUEST.value(), ex.getCustomMessage());
    }
    /**
     * Return http status 400 when DataIntegrityViolationException is thrown
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorDTO handleViolatedDataIntegrity(DataIntegrityViolationException ex) {
        logger.error(invalidRequestMessage, ex);

        return createError(HttpStatus.BAD_REQUEST.value(), String.format("Data Integrity Violation: %s", Throwables.getRootCause(ex).getMessage()));
    }
    /**
     * Return http status 400 when MethodArgumentTypeMismatchException is thrown
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorDTO handleBadRequest(MethodArgumentTypeMismatchException ex) {
        logger.error(invalidRequestMessage, ex);

        return createError(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
    }
    /**
     * Return http status 400 when PersistenceException is thrown
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(PersistenceException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorDTO handleViolatedDataContstraints(PersistenceException ex) {
        logger.error(invalidRequestMessage, ex);

        return createError(HttpStatus.BAD_REQUEST.value(), String.format("Invalid Data Received: %s", Throwables.getRootCause(ex)));
    }
    /**
     * Return http status 403 when AccessDeniedException is thrown
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    public ErrorDTO handleAccessDenied(AccessDeniedException ex) {
        logger.error(authorizationFailedMessage, ex);

        return createError(HttpStatus.FORBIDDEN.value(), String.format("%s: %s", authorizationFailedMessage, ex.getMessage()));
    }
    /**
     * Return http status 404 when NoSuchElementException is thrown
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorDTO handleNoSuchElementFound(Exception ex) {
        logger.error(errorLogMessage, ex);

        return createError(HttpStatus.NOT_FOUND.value(), "Not Found");
    }
    /**
     * Return http status 500 when HttpClientErrorException is thrown
     *
     * @param ex
     * @return
     */
    @ExceptionHandler({HttpClientErrorException.class, Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorDTO handleInternalServerError(Exception ex) {
        logger.error(errorLogMessage, ex);

        return createError(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
    }
    /**
     * Return http status 503 when HttpServerErrorException is thrown
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(HttpServerErrorException.class)
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    @ResponseBody
    public ErrorDTO handleDatabaseException(Exception ex) {
        logger.error(errorLogMessage, ex);

        return createError(HttpStatus.SERVICE_UNAVAILABLE.value(), HttpStatus.SERVICE_UNAVAILABLE.getReasonPhrase());
    }
    /**
     * Create ErrorDTO object containing error code & message
     *
     * @param code
     * @param message
     * @return
     */
    private ErrorDTO createError(int code, String message) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setCode(code);
        errorDTO.setMessage(message);

        return errorDTO;
    }
}
