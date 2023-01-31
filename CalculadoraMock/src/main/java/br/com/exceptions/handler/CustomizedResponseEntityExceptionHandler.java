package br.com.exceptions.handler;

import br.com.exceptions.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice // Concentrar algum tratamento que e seria espalhados em todos os controllers.
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllExcepions(Exception e, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(),
                e.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UnsupportedOperationException.class)
    public final ResponseEntity<ExceptionResponse> handleBadRequestExcepions(Exception e, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(),
                e.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }


}
