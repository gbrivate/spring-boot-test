package br.com.cinq.greet.service;

import br.com.cinq.greet.model.Message;

/**
 * Created by Gabriel on 16/11/2015.
 * Interface class responsible to retrieve and change the message of day.
 */
public interface IGreetingService {

    /**
     * Retrieve the message of day.
     * @return Message.
     */
    public Message retrieveMessageOfDay();

    /**
     * Retrieve the message of day by id.
     * @return Message.
     */
    public Message retrieveMessageOfDayByID(Long id);


    /**
     *
     * Change the message of day.
     * @param message
     * @return Message, otherwise null.
     */
    public Message updateMessageOfDay(Message message);

}
