package org.example.authors;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorsRepository extends JpaRepository<Authors, Integer> {
    boolean existsById(Integer id);
}
