package com.example.company.service.impl;

import com.example.company.model.Message;
import com.example.company.repository.MessageRepository;
import com.example.company.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageImpl implements MessageService {

    private final MessageRepository messageRepository;

    @Override
    public void addMessage(Message message){
         messageRepository.save(message) ;
    }

    @Override
    public List<Message> findAll(){
        return messageRepository.findAll();
    }
    @Override
    public List<Message> findAllMessagesByToId(int id){
        return messageRepository.findAllByToID_Id(id);
    }
}
