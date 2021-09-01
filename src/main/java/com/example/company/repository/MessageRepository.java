package com.example.company.repository;

import com.example.company.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository <Message, Integer> {

List<Message> findAllByToID_Id(int id);

}
