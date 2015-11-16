package br.com.cinq.greet.repository;

import br.com.cinq.greet.model.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gabriel on 16/11/2015.
 */
public class MessageOfDayDB {

    private static MessageOfDayDB ourInstance = new MessageOfDayDB();

    public static MessageOfDayDB getInstance() {
        return ourInstance;
    }

    /**
     * Created a list as repository instead just a variable,
     * because if there is a need for more messages, the repository is already done.
     */
    private static List<Message> messageList;
    private static Message foundMessage = null;

    /**
     * Ensure that message repository is created.
     */
    private MessageOfDayDB() {
        if (messageList==null){
            messageList = new ArrayList<Message>();
            // generate the first message.
            generateInitialMessage();
        }
    }

    /**
     * Create the stander message.
     */
    private void generateInitialMessage(){
        // create the stander message.
        Message message = new Message();
        message.setId(1L);
        message.setDescription("Better safe than sorry!!");

        messageList.add(message);
    }

    /**
     * retrieve the message given the id;
     * @return Message if found, otherwise null;
     */
    public static Message retrieveMessageByID(Long id){
        // find the message.
        findMessageByID(id);
        return foundMessage;
    }

    /**
     * retrieve the first index message;
     * @return Message;
     */
    public static Message retrieveMessage(){
        // find the defautl message.
        findMessageByID(1L);
        return foundMessage;
    }

    /**
     * update the message given the id;
     * @return Message otherwise null;
     */
    public static Message updateMessage(Message message){
        // find the message.
        findMessageByID(message.getId());
        if (foundMessage!=null){
            // change to the new description.
            foundMessage.setDescription(message.getDescription());
        }
        return foundMessage;
    }


    /**
     * Find the Message object given the id.
     * @param id
     */
    private static void findMessageByID(Long id){
        foundMessage = null;
        for (Message msg : messageList ){
            if (msg.getId().compareTo(id)==0){
                foundMessage = msg;
                break;
            }
        }
    }
}
