package org.example.authors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorsController {

    @Autowired
    private AuthorsService authorsTableService;

    // Получение всех записей
    @GetMapping
    public List<Authors> getAll() {
        return authorsTableService.findAll();
    }

    // Получение записи по ID
    @GetMapping("/{id}")
    public Authors getById(@PathVariable Integer id) {
        return authorsTableService.findById(id);
    }

    // Создание новой записи
    @PostMapping
    public Authors create(@RequestBody Authors authorsTable) {
        return authorsTableService.save(authorsTable);
    }

    // Обновление записи
    @PutMapping("/{id}")
    public Authors update(@PathVariable Integer id, @RequestBody Authors authorsTable) {
        authorsTable.setAuthorId(id);
        return authorsTableService.save(authorsTable);
    }

    // Частичное обновление записи
    @PatchMapping("/{id}")
    public Authors patch(@PathVariable Integer id, @RequestBody Authors authorsTable) {
        return authorsTableService.patch(id, authorsTable);
    }

    // Удаление записи
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        authorsTableService.delete(id);
    }
}
