package org.example.authorRegistration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthorRegistrationService {

    @Autowired
    private AuthorRegistrationRepository authorRegistrationRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AuthorRegistration registerNewAuthor(String name, String rawPassword) {
        AuthorRegistration newAuthor = new AuthorRegistration();
        newAuthor.setName(name);
        newAuthor.setPassword(passwordEncoder.encode(rawPassword));
        return authorRegistrationRepository.save(newAuthor);
    }
}
