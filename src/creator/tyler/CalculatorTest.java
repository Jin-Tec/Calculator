package creator.tyler;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorTest
{
    private Calculator calculator;

    @BeforeMethod
    public void setUp()
    {
        calculator = new Calculator();
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void calculate_Null_Throws()
    {
        calculator.calculate(null);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void calculate_Empty_Throws()
    {
        calculator.calculate("");
    }

    @Test
    public void calculate_42_Succeeds()
    {
        assertEquals(calculator.calculate("42"), 44);
    }
}
