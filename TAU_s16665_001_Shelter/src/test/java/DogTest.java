package test.java;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import main.java.Dog;

class DogTest {

    @Test
    void updateAge() {
        Dog d = new Dog("German Shepherd", "0001", "Male", "Yogo", 3);
        d.setAge(4);
        assertEquals(4, d.getAge());
    }

    @Test
    void upDateName() {
        Dog d = new Dog("Dalmatian", "6372", "Female", "Bena", 3);
        d.setName("Bella");
        assertEquals("Bella", d.getName());
    }

    @Test
    void setIllegalArgument() {
        Dog d = new Dog("Dalmatian", "6372", "Female", "Bella", 3);
        assertThrows(IllegalArgumentException.class, () -> {
            d.setAge(-4);
        });
    }
}
