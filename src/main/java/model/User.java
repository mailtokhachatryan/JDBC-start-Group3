package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import util.constants.Parameter;

import javax.persistence.*;

@Setter
@Getter
@ToString
@Entity
@Table(name = Parameter.USERS)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false, unique = true)
    private String email;

    @Column
    private String password;

    @Column
    private int age;

    @Column
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
