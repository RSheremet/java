package org.example.mytesttable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mytesttable")
public class MyTestTableController {

    @Autowired
    private MyTestTableService myTestTableService;

    // Получение всех записей
    @GetMapping
    public List<MyTestTable> getAll() {
        return myTestTableService.findAll();
    }

    // Получение записи по ID
    @GetMapping("/{id}")
    public MyTestTable getById(@PathVariable Long id) {
        return myTestTableService.findById(id);
    }

    // Создание новой записи
    @PostMapping
    public MyTestTable create(@RequestBody MyTestTable myTestTable) {
        return myTestTableService.save(myTestTable);
    }

    // Обновление записи
    @PutMapping("/{id}")
    public MyTestTable update(@PathVariable Long id, @RequestBody MyTestTable myTestTable) {
        myTestTable.setId(id);
        return myTestTableService.save(myTestTable);
    }

    // Частичное обновление записи
    @PatchMapping("/{id}")
    public MyTestTable patch(@PathVariable Long id, @RequestBody MyTestTable myTestTable) {
        return myTestTableService.patch(id, myTestTable);
    }

    // Удаление записи
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        myTestTableService.delete(id);
    }
}
