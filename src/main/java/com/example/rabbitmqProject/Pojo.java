package com.example.rabbitmqProject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Pojo {
    private String name;
    private String username;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    @JsonIgnore
    public void setUsername(String username) {
        this.username = this.username;
    }
    public String getUsername() {
        return this.username;
    }
}
