package org.example.authors;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
public class Authors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("author_id")
    private Integer authorId;

    private String name;

    public void setAuthorId(Integer id) {
        this.authorId = id;
    }

    // Исправленное название геттера
    public Integer getAuthorId() {
        return authorId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
