package main.java;

public class Dog {

    private String breed;
    private String id;
    private String gender;
    private String name;
    private int age;


    public Dog(String breed, String id, String gender, String name, int age) {
        this.breed = breed;
        this.gender = gender;
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException();
        } else {
            this.age = age;
        }
    }
}
