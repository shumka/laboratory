import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Level1Test {

    @Test
    void bastShoe() {
        assertEquals("Привет", Level1.BastShoe("1 Привет"));
        assertEquals("Привет, Мир!", Level1.BastShoe("1  , Мир!"));
        assertEquals("Привет, Мир!++", Level1.BastShoe("1 ++"));
        assertEquals("Привет, Мир!", Level1.BastShoe("2 2"));
        assertEquals("Привет, Мир!++", Level1.BastShoe("4"));
        assertEquals("Привет, Мир!", Level1.BastShoe("4"));
        assertEquals("Привет, Мир!*", Level1.BastShoe("1 *"));
        assertEquals("Привет, Мир!", Level1.BastShoe("4"));
        assertEquals("Привет, Мир!", Level1.BastShoe("4"));
        assertEquals("Привет, Мир!", Level1.BastShoe("4"));
        assertEquals(",", Level1.BastShoe("3 6"));
        assertEquals("", Level1.BastShoe("2 100"));
        assertEquals("Привет", Level1.BastShoe("1 Привет"));
        assertEquals("Привет, Мир!", Level1.BastShoe("1 , Мир!"));
        assertEquals("Привет, Мир!++", Level1.BastShoe("1 ++"));
        assertEquals("Привет, Мир!", Level1.BastShoe("4"));
        assertEquals("Привет", Level1.BastShoe("4"));
        assertEquals("Привет, Мир!", Level1.BastShoe("5"));
        assertEquals("Привет", Level1.BastShoe("4"));
        assertEquals("Привет, Мир!", Level1.BastShoe("5"));
        assertEquals("Привет, Мир!++", Level1.BastShoe("5"));
        assertEquals("Привет, Мир!++", Level1.BastShoe("5"));
        assertEquals("Привет, Мир!++", Level1.BastShoe("5"));
        assertEquals("Привет, Мир!", Level1.BastShoe("4"));
        assertEquals("Привет", Level1.BastShoe("4"));
        assertEquals("Прив", Level1.BastShoe("2 2"));
        assertEquals("Привет", Level1.BastShoe("4"));
        assertEquals("Прив", Level1.BastShoe("5"));
        assertEquals("Прив", Level1.BastShoe("5"));
        assertEquals("Прив", Level1.BastShoe("5"));

    }
}

