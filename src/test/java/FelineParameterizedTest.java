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

    // Исправьте конструктор, убрав "void"
    public FelineParameterizedTest(String animalType, String expectedFamily, List<String> expectedFood) {
        this.animalType = animalType;
        this.expectedFamily = expectedFamily;
        this.expectedFood = expectedFood;
    }

    @Parameterized.Parameters(name="Тест с типом '{0}'")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Хищник", "Кошачьи", Arrays.asList("Животные", "Птицы", "Рыба")},
                {"Травоядное", "Кошачьи", Arrays.asList("Трава", "Различные растения")}
        });
    }

    @Test
    public void testGetFamilyAndFood() throws Exception {
        Feline feline = new Feline();
        assertEquals(expectedFamily, feline.getFamily());
        assertEquals(expectedFood, feline.getFood(animalType)); // Имитация передачи типа животного
    }
}

