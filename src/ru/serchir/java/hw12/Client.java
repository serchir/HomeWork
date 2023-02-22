package ru.serchir.java.hw12;

import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Client client = (Client) obj;
        return (name == client.name) && (age == client.age);
    }
    @Override
    public int hashCode() {
        int prime = 31;
        return prime* Objects.hash(name,age);
    }
}
