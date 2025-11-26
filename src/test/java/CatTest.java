import com.example.Cat;
import com.example.Feline;
import com.example.Predator;
import org.junit.Before;
import org.junit.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.when;

public class CatTest {

    @Mock
    private Predator mockPredator;

    private Cat cat;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(mockPredator.eatMeat()).thenReturn(List.of("Кролики"));
        cat = new Cat(mockPredator);
    }

    @Test
    public void testGetSound() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFood() throws Exception {
        assertEquals(List.of("Кролики"), cat.getFood());
    }

}