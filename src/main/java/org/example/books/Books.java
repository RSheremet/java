package org.example.books;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("book_id")
    private Integer bookId;

    private String title;
    @JsonProperty("author_id")
    private Integer authorId;

    public void setBookId(Integer id) {
        this.bookId = id;
    }

    // Исправленное название геттера
    public Integer getBookId() {
        return bookId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(Integer authorId) {
        this.authorId = authorId;
    }

    public Integer getAuthorId() {
        return authorId;
    }
}
