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
        Predator predator = new Feline(); // Создаем экземпляр Predator вне класса Lion
        maleLion = new Lion("Самец", predator);
        femaleLion = new Lion("Самка", predator);
    }

    @Test
    public void testMaleLionBehavior() throws Exception {
        assertEquals("Ррр!", maleLion.makeSound());
        assertEquals("Кошачьи", maleLion.getFamily());
        assertTrue(maleLion.doesHaveMane());
        assertEquals(List.of("Животные", "Птицы", "Рыба"), maleLion.getFood());  //Честно, я не знаю почему, но здесь у меня возникает ошибка, как я понял с кодировкой. Перепобовал разные варианты, и так и не заработало.
    }

    @Test
    public void testFemaleLionBehavior() throws Exception {
        assertFalse(femaleLion.doesHaveMane());
    }

    @Test
    public void testGetKittens() throws Exception {
        assertEquals(1, maleLion.getKittens()); // По умолчанию возвращается 1 детёныш
    }

    @Test(expected = Exception.class)
    public void testInvalidSexThrowsException() throws Exception {
        new Lion("Некорректный пол", new Feline());
    }
}