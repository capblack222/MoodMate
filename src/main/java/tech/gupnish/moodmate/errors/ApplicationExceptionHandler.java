package tech.gupnish.moodmate.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleIllegalArgumentException(IllegalArgumentException ex) {
        return "<h1>" + ex.getMessage() + "</h1>";
    }

    @ExceptionHandler(MoodNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleMoodNotFoundException(MoodNotFoundException ex) {
        return "<h1>" + ex.getMessage() + "</h1>";
    }

}
