package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
public class MyTestTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "\"First\"")
    private String First;
    private String Second;
    private Boolean Third;
    private String Fourth;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst() {
        return First;
    }

    public void setFirst(String first) {
        this.First = first;
    }

    public String getSecond() {
        return Second;
    }

    public void setSecond(String second) {
        this.Second = second;
    }

    public Boolean getThird() {
        return Third;
    }

    public void setThird(Boolean third) {
        this.Third = third;
    }

    public String getFourth() {
        return Fourth;
    }

    public void setFourth(String fourth) {
        this.Fourth = fourth;
    }

    @Override
    public String toString() {
        return this.getFirst();
    }
}
