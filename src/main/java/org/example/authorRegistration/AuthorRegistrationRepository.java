package org.example.authorRegistration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRegistrationRepository extends JpaRepository<AuthorRegistration, Integer> {
}
