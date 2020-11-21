package test.java;

import main.java.Cage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CageTest {

    @Test
    void updateCurrentCapacity() {
        Cage c = new Cage("M01", 1);
        c.setCurrentCapacity(0);
        assertTrue(c.isCageEmpty());
        c.setCurrentCapacity(4);
        assertEquals(4, c.getCurrentCapacity());
    }

    @Test
    void setNullId() {
        Cage c = new Cage("F01", 3);
        c.setId(null);
        assertNotNull(c.getId());
    }

}