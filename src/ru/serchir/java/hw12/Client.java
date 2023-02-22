package ru.serchir.java.hw12;

public class Client {
    private final String name;
    private final Integer age;

    public Client(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public Integer getAge() {
        return this.age;
    }
}
