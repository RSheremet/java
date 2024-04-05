package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.util.List;

@Service
public class MyTestTableService {

    @Autowired
    private MyTestTableRepository repository;

    @PostConstruct
    public void printMyTestTableData() {
        List<MyTestTable> tableData = repository.findAll();
        tableData.forEach(data -> System.out.println("ID: " + data.getId() + ", Name: " + data.getName()));
    }
}
