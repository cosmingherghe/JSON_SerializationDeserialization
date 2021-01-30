package dev.cosmingherghe.entity;

import java.util.Arrays;
import java.util.List;

public class User {
    private String name;
    private Integer age;

    private String[] cars;
    private List<Pet> pets;

    public User() {
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public User(String name, Integer age, String[] cars, List<Pet> pets) {
        this.name = name;
        this.age = age;
        this.cars = cars;
        this.pets = pets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String[] getCars() {
        return cars;
    }

    public void setCars(String[] cars) {
        this.cars = cars;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    @Override
    public String toString() {
        return "User { " +
                "name='" + name + '\'' +
                ", age=" + age +
                ", cars=" + Arrays.toString(cars) +
                ", pets=" + pets +
                " }";
    }
}
