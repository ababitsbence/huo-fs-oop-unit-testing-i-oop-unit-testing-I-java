import com.codecool.animal.Animal;
import com.codecool.animal.Lion;
import com.codecool.animal.Parrot;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AnimalTest {

    @Test
    void testConstructor_SetsNameAgeAndHealthCorrectly() {
        // Arrange & Act
        // We test through a concrete class because Animal is abstract
        Animal lion = new Lion("Leo", 2, 90);

        // Assert
        assertEquals("Leo", lion.getName());
        assertEquals(2, lion.getAge());
        assertEquals(90, lion.getHealth());
    }

    @Test
    void testConstructor_SetsNullName() {
        // Arrange & Act
        // We test through a concrete class because Animal is abstract
        Animal lion = new Lion(null, 5, 5);

        // Assert
        assertEquals("Unnamed", lion.getName());
    }

    @Test
    void testConstructor_SetsNameEmptyString() {
        // Arrange & Act
        // We test through a concrete class because Animal is abstract
        Animal lion = new Lion("", 5, 5);

        // Assert
        assertEquals("Unnamed", lion.getName());
    }

    @Test
    void testConstructor_SetsLessThanZeroAge() {
        // Arrange & Act
        // We test through a concrete class because Animal is abstract
        Animal lion = new Lion("Leo", -5, 5);

        // Assert
        assertEquals(0, lion.getAge());
    }

    @Test
    void testConstructor_SetsLessThanZeroHealth() {
        // Arrange & Act
        // We test through a concrete class because Animal is abstract
        Animal lion = new Lion("Leo", 5, -10);

        // Assert
        assertEquals(0, lion.getHealth());
    }


    @Test
    void testConstructor_SetsMoreThanHundredHealth() {
        // Arrange & Act
        // We test through a concrete class because Animal is abstract
        Animal parrot = new Parrot("Parrot", 5, 150);

        // Assert
        assertEquals(100, parrot.getHealth());
    }

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void testLionMakeSound() {
        Animal lion = new Lion("Leo", 5, 5);

        lion.makeSound();

        assertEquals("roars loudly: Rooooar!", outputStreamCaptor.toString()
                .trim());
    }

    @Test
    void testParrotMakeSound() {
        Animal parrot = new Parrot("Parrot", 5, 5);

        parrot.makeSound();

        assertEquals("squawks: Squawk! Pieces of eight!", outputStreamCaptor.toString()
                .trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }


}
