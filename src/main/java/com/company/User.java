package com.company;

import lombok.Data;

import java.util.List;

@Data
public class User {
    private String username;
    private Integer age;
    private List<Group> groups;

}