import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CatTest {

    @Test
    void updateAge() {
        Cat cat = new Cat("Maine Coon", "0001", "Male", "Yogo", 3);
        cat.setAge(4);
        assertEquals(4, cat.getAge());
    }

    @Test
    void upDateName() {
        Cat cat = new Cat("Roofer", "6372", "Female", "Bena", 3);
        cat.setName("Bella");
        assertEquals("Bella", cat.getName());
    }

    @Test
    void setIllegalArgument() {
        Cat cat = new Cat("Roofer", "6372", "Female", "Bella", 3);
        assertThrows(IllegalArgumentException.class, () -> {
            cat.setAge(-4);
        });
    }

    @Test
    void getName() {
    }

    @Test
    void setName() {
    }

    @Test
    void getAge() {
    }

    @Test
    void setAge() {
    }
}