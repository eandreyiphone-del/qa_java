import com.example.Feline;
import com.example.Lion;
import com.example.Predator;
import org.junit.Before;
import org.junit.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

import static org.mockito.Mockito.when;

public class LionTest {

    @Mock
    private Predator mockPredator;

    private Lion maleLion;
    private Lion femaleLion;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(mockPredator.eatMeat()).thenReturn(List.of("Зебры"));
        maleLion = new Lion(mockPredator, "Самец");
        femaleLion = new Lion(mockPredator, "Самка");
    }

    @Test
    public void testDoesHaveMane() {
        assertEquals(true, maleLion.doesHaveMane());
        assertEquals(false, femaleLion.doesHaveMane());
    }

    @Test
    public void testGetFood() throws Exception {
        assertEquals(List.of("Зебры"), maleLion.getFood());
    }

    @Test
    public void testInvalidSexThrowsException() {
        try {
            new Lion(mockPredator, "Неправильный Пол");
            fail("Исключение должно было произойти!");
        } catch (Exception e) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка", e.getMessage());
        }
    }

}