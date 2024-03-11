package com.stefan.internship_assignment.helloWorldMessage;

import jakarta.persistence.*;

@Entity
@Table
public class HelloWorldMessage {
    @Id
    @TableGenerator(name = "hello_sequence",
            allocationSize = 1,
            table = "HELLO_SEQUENCES",
            pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_NUMBER",
            pkColumnValue = "SEQUENCE"
    )
    @GeneratedValue(
            strategy = GenerationType.TABLE,
            generator = "hello_sequence"
    )
    private Integer id;
    private String language;
    private String message;

    public HelloWorldMessage() {
    }

    public HelloWorldMessage(Integer id, String language, String message) {
        this.id = id;
        this.language = language;
        this.message = message;
    }

    public HelloWorldMessage(String language, String message) {
        this.language = language;
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public String getLanguage() {
        return language;
    }

    public String getMessage() {
        return message;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.language + ": " + this.message;
    }
}