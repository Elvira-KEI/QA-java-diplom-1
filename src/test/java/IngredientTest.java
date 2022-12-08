import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;

public class IngredientTest {

    Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);

    @Test
    public void getNameReturnsCorrectName() {
        String expectedName = "hot sauce";
        String actualName = ingredient.getName();
        assertEquals("Incorrect values ingredient name", expectedName, actualName);
    }

    @Test
    public void getPriceReturnsCorrectPrice() {
        float expectedPrice = 100;
        float actualPrice = ingredient.getPrice();
        assertEquals("Incorrect values ingredient price", expectedPrice, actualPrice, 2);
    }

    @Test
    public void getTypeReturnsCorrectType() {
        IngredientType expectedType = IngredientType.SAUCE;
        IngredientType actualType = ingredient.getType();
        assertEquals("Incorrect values ingredient type", expectedType, actualType);
    }
}
