package com.usa.ciclo3.reto3.services;


import com.usa.ciclo3.reto3.model.Message;
import com.usa.ciclo3.reto3.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageServices {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll(){

        return messageRepository.getAll();
    }
    public Optional<Message> getMessage(int idMessage){

        return messageRepository.getMessage(idMessage);
    }
    public Message save(Message message){
        if(message.getIdMessage()==null){
            return messageRepository.save(message);
        }else{
            Optional<Message> maux=messageRepository.getMessage(message.getIdMessage());
            if(maux.isEmpty()) {
                return messageRepository.save(message);
            }else{
                return message;
            }
        }
    }

    public Message update(Message message) {
        if (message.getIdMessage()!= null) {
            Optional<Message> e = messageRepository.getMessage(message.getIdMessage());
            if (!e.isEmpty()) {
                if (message.getMessageText()!= null) {
                    e.get().setMessageText(message.getMessageText());
                }
                messageRepository.save(e.get());
                return e.get();

            } else {
                return message;
            }
        } else {
            return message;
        }
    }



    public boolean deleteMessage(int idMessage) {
        Boolean aBoolean = getMessage(idMessage).map(message -> {
            messageRepository.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}


