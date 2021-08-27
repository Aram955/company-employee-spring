package com.example.company.repository;

import com.example.company.model.Employee;
import com.example.company.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository <Message, Integer> {



}
