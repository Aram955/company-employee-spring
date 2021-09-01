package com.example.company.service;

import com.example.company.model.Message;

import java.util.List;

public interface MessageService {

    void addMessage(Message message);

    List<Message> findAll();

    List<Message> findAllMessagesByToId(int id);

}
