package com.test.e_commerce.config;

import com.test.e_commerce.models.domain.ErrorMessage;
import com.test.e_commerce.models.exceptions.BadRequestException;
import com.test.e_commerce.models.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

@RequiredArgsConstructor
@RestControllerAdvice
public class HandlerExceptionConfiguration {

    public static final String PREFIX = "The field ";

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorMessage handleNotFoundException(NotFoundException ex) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setMessage(ex.getMessage());
        errorMessage.setCode(ex.getErrorCode());
        return errorMessage;
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorMessage handleBadRequestException(BadRequestException ex) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setMessage(ex.getMessage());
        errorMessage.setCode(ex.getErrorCode());
        return errorMessage;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorMessage handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        ErrorMessage errorMessage = new ErrorMessage();

        if (!ex.getBindingResult().getFieldErrors().isEmpty()) {
            FieldError fieldError = ex.getBindingResult().getFieldErrors().get(0);
            String fieldName = fieldError.getField();
            String constraintType = fieldError.getCode();
            String error = PREFIX;
            switch (Objects.requireNonNull(constraintType)) {
                case "NotNull":
                    error += fieldName+" can not be null";
                    break;
                case "NotEmpty":
                    error += fieldName+" can be empty";
                    break;
                case "NotBlank":
                    error += fieldName+" can be blank";
                    break;
                case "Min":
                    Object[] arguments = fieldError.getArguments();
                    if (arguments != null && arguments.length >= 1) {
                        long minValue = (Long) arguments[1];
                        error += fieldName + " must be at least " + minValue;
                    }
                    break;
                case "Pattern":
                    error += fieldName + fieldError.getDefaultMessage();
                    break;
                default:
                    error += fieldName + " has an invalid value";
                    break;
            }
            errorMessage.setMessage(error);
            errorMessage.setCode(ex.getBody().getStatus());
        }
        return errorMessage;
    }
}
