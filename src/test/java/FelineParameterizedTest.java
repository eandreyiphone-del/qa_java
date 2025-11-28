import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParameterizedTest {

    private final String animalType;
    private final String expectedFamily;
    private final List<String> expectedFood;

    // Конструктор, принимающий аргументы из таблицы параметров
    public FelineParameterizedTest(String animalType, String expectedFamily, List<String> expectedFood) {
        this.animalType = animalType;
        this.expectedFamily = expectedFamily;
        this.expectedFood = expectedFood;
    }

    // Таблица с параметрами, которые будут использоваться в тестах
    @Parameterized.Parameters(name="Тест с типом '{0}'")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Хищник", "Кошачьи", Arrays.asList("Животные", "Птицы", "Рыба")},
                {"Травоядное", "Кошачьи", Arrays.asList("Трава", "Различные растения")}
        });
    }

    // Первый тест проверяет название семейства
    @Test
    public void testGetFamily() {
        Feline feline = new Feline();
        assertEquals(expectedFamily, feline.getFamily());
    }

    // Второй тест проверяет рацион питания
    @Test
    public void testGetFood() throws Exception {
        Feline feline = new Feline();
        assertEquals(expectedFood, feline.getFood(animalType));
    }
}

