package br.com.cinq.greet.serviceImp;

import br.com.cinq.greet.exception.NotFoundException;
import br.com.cinq.greet.model.Message;
import br.com.cinq.greet.exception.InvalidIDException;
import br.com.cinq.greet.repository.MessageOfDayDB;
import br.com.cinq.greet.service.IGreetingService;
import org.springframework.stereotype.Service;

/**
 * Created by Gabriel on 16/11/2015.
 */
@Service(value = "greetingService")
public class GreetingServiceImpl extends GenericService<Message> implements IGreetingService {

    private static final long serialVersionUID = -5828135806162588867L;

    /**
     * Retrieve the default message of day.
     *
     * @return message String.
     */
    @Override
    public Message retrieveMessageOfDay() {
        return MessageOfDayDB.retrieveMessage();
    }

    /**
     * Retrieve the message of day by id.
     *
     * @return Message.
     */
    @Override
    public Message retrieveMessageOfDayByID(Long id) {
        Message message = null;
        // check if the id is a integer valid.
        if (id == null || (id!=null && id < 1)) {
            throw new InvalidIDException();
        }
        message = MessageOfDayDB.retrieveMessageByID(id);
        // if the message is equal null, throw a NotFoundException.
        if (message==null){
            throw new NotFoundException();
        }
        return message;
    }


    /**
     * Change the message of day given the id.
     *
     * @param Message.
     * @return Message, otherwise null.
     */
    @Override
    public Message updateMessageOfDay(Message message) {
        if (message == null || (message.getId()!=null && message.getId()< 1L)) {
            throw new InvalidIDException();
        }
        message = MessageOfDayDB.updateMessage(message);
        if (message==null){
            throw new NotFoundException();
        }
        return message;
    }
}
