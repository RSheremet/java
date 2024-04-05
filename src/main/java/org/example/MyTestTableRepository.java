package org.example;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MyTestTableRepository extends JpaRepository<MyTestTable, Long> {
}
