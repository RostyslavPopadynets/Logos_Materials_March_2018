package ua.logos.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ua.logos.entity.exceptions.ResponseException;
import ua.logos.exceptions.models.BookNotFoundException;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler {

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ResponseException> handleBookNotFoundException(BookNotFoundException ex, HttpServletRequest request) {
        ResponseException responseException = new ResponseException(ex.getMessage(), new Date(), request.getRequestURI());
        return new ResponseEntity<ResponseException>(responseException, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseException> handleAllExceptions(Exception ex, HttpServletRequest request) {
        ResponseException responseException = new ResponseException(ex.getMessage(), new Date(), request.getRequestURI());
        return new ResponseEntity<ResponseException>(responseException, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
