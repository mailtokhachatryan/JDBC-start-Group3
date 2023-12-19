package model;

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

    public User(String name, String lastname, int age, Integer balance) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.balance = balance;
    }

    public User(int id, String name, String lastname, int age, Integer balance) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                '}';
    }
}
