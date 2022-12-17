import org.hamcrest.MatcherAssert;
import org.junit.Test;
import praktikum.Bun;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;

public class BunTest {



    @Test
    public void getNameReturnInValidValue(){
        Bun bun = new Bun("Name", 10);
        String expectedName = "Name";
        String actualName = bun.getName();
        assertEquals("Name is incorrect",expectedName,actualName);
   }

    @Test
    public void getPriceReturnInValidValue(){
       Bun bun = new Bun("Name", 10);
       float expectedPrise = 10;
       float actualPrise = bun.getPrice();
       assertEquals("Price is incorrect", expectedPrise,actualPrise,2);
    }

    @Test
    public void getPriceReturnNotNull() {
        Bun bun = new Bun("Name", 10);
        float actualPrise = bun.getPrice();
        MatcherAssert.assertThat(actualPrise, notNullValue());
    }

}
