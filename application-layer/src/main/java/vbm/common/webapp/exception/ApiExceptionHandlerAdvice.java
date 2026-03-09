package vbm.common.webapp.exception;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import vbm.common.exception.AppelOffreServiceException;

@Hidden
@RestControllerAdvice
@Slf4j
public class ApiExceptionHandlerAdvice {

    @ExceptionHandler(value = {
            AppelOffreServiceException.class
    })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError badParamFormat(Exception exception){
        log.error(exception.getMessage());
        ApiError error = new ApiError("Erreur de format d'un paramètre");
        error.setTypeError(ApiError.APITypeError.FIELD_VALIDATION);
        return error;
    }
}
