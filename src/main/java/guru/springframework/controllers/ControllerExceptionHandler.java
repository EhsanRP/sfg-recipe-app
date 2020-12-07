package guru.springframework.controllers;

import guru.springframework.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {

    private static final String VIEWS_NOT_FOUND = "404error";
    private static final String VIEWS_BAD_REQUEST = "400error";

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleNotFound(Exception exception) {

        log.error("Handling not Found Exception");
        log.error(exception.getMessage());

        ModelAndView modelAndView = new ModelAndView(VIEWS_NOT_FOUND);
        modelAndView.addObject("exception", exception);

        return modelAndView;

    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NumberFormatException.class)
    public ModelAndView handleNumberFormat(Exception exception) {

        log.error("Handling NumberFormatException");
        log.error(exception.getMessage());

        ModelAndView modelAndView = new ModelAndView(VIEWS_BAD_REQUEST).addObject("exception", exception);

        return modelAndView;
    }

}
