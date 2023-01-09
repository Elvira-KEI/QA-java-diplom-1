import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger = new Burger();
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    @Test
    public void getPriceReturnValidValue(){
        float price =  100;
        Mockito.when(bun.getPrice()).thenReturn(price);
        Mockito.when(ingredient.getPrice()).thenReturn(price);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        float expectedPrice = price * 2 + price;
        float actualPrise = burger.getPrice();

        assertEquals("Incorrect price",expectedPrice,actualPrise, 2);
    }

    @Test
    public void getReceiptReturnValidValue(){// throws Exception {
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(bun.getPrice()).thenReturn(100f);

        burger.setBuns(bun);

        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("dinosaur");
        Mockito.when(ingredient.getPrice()).thenReturn(300f);

        burger.addIngredient(ingredient);

        String expectedReceipt = "(==== black bun ====)\r\n= filling dinosaur =\r\n(==== black bun ====)" +
                "\r\n\r\nPrice: 500,000000\r\n";
        String actualReceipt = burger.getReceipt();

        assertEquals("Incorrect burger receipt", expectedReceipt, actualReceipt);
    }

    @Test
    public void setBuns() {
        burger.setBuns(bun);
        Bun actual = burger.bun;

        assertEquals("Incorrect introduction of the bun dependency into the burger", bun, actual);
    }

    @Test
    public void addIngredient() {
        burger.addIngredient(ingredient);

        List<Ingredient> expected = List.of(ingredient);
        List<Ingredient> actual = burger.ingredients;

        assertEquals("Incorrect addition of an ingredient in the list", expected, actual);
    }

    @Test
    public void removeIngredient() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);

        List<Ingredient> actual = burger.ingredients;

        assertEquals("Incorrect removal of an ingredient in the list", List.of(), actual);
    }

    @Test
    public void moveIngredient() {
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "sausage", 300));
        burger.moveIngredient(0, 1);

        String expectedName = "sour cream";
        String actualName = burger.ingredients.get(1).name;

        assertEquals("Incorrect movement of an ingredient in the list", expectedName, actualName);
    }
}
