package org.example;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MyTestTableService {

    @Autowired
    private MyTestTableRepository repository;

    // Метод для получения всех записей
    public List<MyTestTable> findAll() {
        return repository.findAll();
    }

    // Метод для получения записи по ID
    public MyTestTable findById(Long id) {
        Optional<MyTestTable> result = repository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            // Обработка случая, когда запись не найдена
            throw new RuntimeException("Did not find MyTestTable entry with id - " + id);
        }
    }

    // Метод для сохранения или обновления записи
    public MyTestTable save(MyTestTable myTestTable) {
        return repository.save(myTestTable);
    }

    // Метод для частичного обновления записи
    // Пример реализации. Вам может потребоваться адаптировать логику в зависимости от требований
    public MyTestTable patch(Long id, MyTestTable myTestTable) {
        return repository.findById(id).map(existingTable -> {
            if (myTestTable.getFirst() != null) { // Пример проверки на ненулевое значение поля
                existingTable.setFirst(myTestTable.getFirst());
            }
            // Добавьте сюда другие проверки и обновления полей
            return repository.save(existingTable);
        }).orElseThrow(() -> new RuntimeException("Did not find MyTestTable entry with id - " + id));
    }

    // Метод для удаления записи
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @PostConstruct
    public void printMyTestTableData() {
        List<MyTestTable> tableData = findAll();
        tableData.forEach(data -> {
            System.out.println("First: " + data.getFirst());
        });
    }
}
