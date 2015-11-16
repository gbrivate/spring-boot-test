package br.com.cinq.greet.controller;

import br.com.cinq.greet.model.Message;
import br.com.cinq.greet.exception.NotFoundException;
import br.com.cinq.greet.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

/**
 * Created by Gabriel on 16/11/2015.
 * GreetingController class responsible to retrieve and change messages.
 */
@RestController
public class GreetingController {

    protected Logger logger = Logger.getLogger(GreetingController.class.getName());

    @Autowired
    protected IGreetingService greetingService;

    private Message message = null;

    // retrieve the default message.
    @RequestMapping(value = "/greeting/retrieveMessage",method = RequestMethod.GET)
    public Message retrieveMessageOfDay(){
        message = greetingService.retrieveMessageOfDay();
        return message;
    }

    // retrieve the message given the id.
    @RequestMapping(value = "/greeting/{id}",method = RequestMethod.GET)
    public Message retrieveMessageOfDayById(@PathVariable("id") Long id){
        message = greetingService.retrieveMessageOfDayByID(id);
        return message;
    }

    // change the message given the id.
    @RequestMapping(value = "/greeting/updateMessage",method = RequestMethod.POST)
    public Message updateMessage(@RequestBody Message message){
        message = greetingService.updateMessageOfDay(message);
        return message;
    }
}
