package org.example.books;

import org.example.authors.AuthorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BooksService {

    @Autowired
    private BooksRepository repository;

    @Autowired
    private AuthorsRepository authorsRepository;

    // Метод для получения всех записей
    public List<Books> findAll() {
        return repository.findAll();
    }

    // Метод для получения записи по ID
    public Books findById(Integer id) {
        Optional<Books> result = repository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new BooksException("Введите правильный айдишник автора");
        }
    }

    // Метод для сохранения или обновления записи
    public Books save(Books book) {
        boolean authorExists = authorsRepository.existsById(book.getAuthorId());
        if (!authorExists) {
            throw new BooksException("Такой автор не существует");
        }
        return repository.save(book);
    }

    // Метод для частичного обновления записи
    // Пример реализации. Вам может потребоваться адаптировать логику в зависимости от требований
    public Books patch(Integer id, Books booksTable) {
        return repository.findById(id).map(existingTable -> {
            if (booksTable.getTitle() != null && booksTable.getBookId() != null) {
                existingTable.setTitle(booksTable.getTitle());
                return repository.save(existingTable);
            } else {
                throw new BooksException("Введите правильный айдишник книги");
            }
        }).orElseThrow(() -> new RuntimeException("Did not find MyTestTable entry with id - " + id));
    }

    // Метод для удаления записи
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
