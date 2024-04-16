package org.example.authorRegistration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
public class AuthorRegistrationController {

    @Autowired
    private AuthorRegistrationService authorRegistrationService;

    @PostMapping("/register")
    public ResponseEntity<AuthorRegistration> registerAuthor(@RequestBody AuthorRegistration author) {
        AuthorRegistration registeredAuthor = authorRegistrationService.registerNewAuthor(author.getName(), author.getPassword());
        return ResponseEntity.ok(registeredAuthor);
    }
}
