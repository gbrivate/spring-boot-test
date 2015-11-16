package br.com.cinq.greet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Gabriel on 16/11/2015.
 */
@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Object not found.")
public class NotFoundException extends RuntimeException  {
    
}
