package br.com.cinq.greet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Gabriel on 16/11/2015.
 */
@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Invalid ID, must be a Integer and greater than 0.")
public class InvalidIDException extends RuntimeException  {

}
