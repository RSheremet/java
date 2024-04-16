package org.example.authors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorsService {

    @Autowired
    private AuthorsRepository repository;

    // Метод для получения всех записей
    public List<Authors> findAll() {
        return repository.findAll();
    }

    // Метод для получения записи по ID
    public Authors findById(Integer id) {
        Optional<Authors> result = repository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            // Обработка случая, когда запись не найдена
            throw new RuntimeException("Did not find MyTestTable entry with id - " + id);
        }
    }

    // Метод для сохранения или обновления записи
    public Authors save(Authors authorsTable) {
        return repository.save(authorsTable);
    }

    // Метод для частичного обновления записи
    // Пример реализации. Вам может потребоваться адаптировать логику в зависимости от требований
    public Authors patch(Integer id, Authors authorsTable) {
        return repository.findById(id).map(existingTable -> {
            if (authorsTable.getName() != null) { // Пример проверки на ненулевое значение поля
                existingTable.setName(authorsTable.getName());
            }
            // Добавьте сюда другие проверки и обновления полей
            return repository.save(existingTable);
        }).orElseThrow(() -> new RuntimeException("Did not find MyTestTable entry with id - " + id));
    }

    // Метод для удаления записи
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
