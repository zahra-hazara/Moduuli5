package UnitTesting;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringManipulatorTest {
    StringManipulator manipulator = new StringManipulator();

    @Test
    void testConcatenate() {
        assertEquals("HelloWorld", manipulator.concatenate("Hello", "World"));
        assertEquals("12345", manipulator.concatenate("123", "45"));
    }

    @Test
    void testFindLength() {
        assertEquals(5, manipulator.findLength("Hello"));
        assertEquals(0, manipulator.findLength(""));
    }

    @Test
    void testConvertToUpperCase() {
        assertEquals("HELLO", manipulator.convertToUpperCase("Hello"));
        assertEquals("WORLD", manipulator.convertToUpperCase("world"));
    }

    @Test
    void testConvertToLowerCase() {
        assertEquals("hello", manipulator.convertToLowerCase("Hello"));
        assertEquals("world", manipulator.convertToLowerCase("WORLD"));
    }

    @Test
    void testContainsSubstring() {
        assertTrue(manipulator.containsSubstring("Hello World", "Hello"));
        assertFalse(manipulator.containsSubstring("Hello World", "hello"));
    }
}

