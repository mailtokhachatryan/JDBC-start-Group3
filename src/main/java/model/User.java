package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class User {
    private int id;
    private String name;
    private String lastname;
    private String email;
    private String password;
    private int age;
    private Integer balance;

    public User() {
    }

    public User(String name, String lastname, String email, String password, int age) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.age = age;
    }

    public User(int id, String name, String lastname, String email, String password, int age) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.age = age;
    }
}
