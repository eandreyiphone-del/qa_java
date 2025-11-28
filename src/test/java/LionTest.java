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

    private Lion maleLion;
    private Lion femaleLion;

    @Before
    public void setup() throws Exception {
        Feline feline = new Feline();
        maleLion = new Lion("Самец", feline);
        femaleLion = new Lion("Самка", feline);
    }

    // Проверка звука самца льва
    @Test
    public void testMakeSoundForMaleLion() throws Exception {
        assertEquals("Ррр!", maleLion.makeSound());
    }

    // Проверка семейства самца льва
    @Test
    public void testFamilyForMaleLion() throws Exception {
        assertEquals("Кошачьи", maleLion.getFamily());
    }

    // Проверка наличия гривы у самца льва
    @Test
    public void testHasManeForMaleLion() throws Exception {
        assertTrue(maleLion.doesHaveMane());
    }

    // Проверка рациона самца льва
    @Test
    public void testFoodForMaleLion() throws Exception {
        assertEquals(Arrays.asList("Животные", "Птицы", "Рыба"), maleLion.getFood());
    }

    // Проверка отсутствия гривы у самки льва
    @Test
    public void testFemaleLionDoesNotHaveMane() throws Exception {
        assertFalse(femaleLion.doesHaveMane());
    }

    // Проверка правильного количества детёнышей
    @Test
    public void testGetKittens() throws Exception {
        assertEquals(1, maleLion.getKittens());
    }

    // Проверка исключения при неверном поле
    @Test(expected = Exception.class)
    public void testInvalidSexThrowsException() throws Exception {
        new Lion("Некорректный пол", new Feline());
    }
}