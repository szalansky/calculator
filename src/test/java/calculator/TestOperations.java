package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestOperations {
    private Division div;
    private Multiplication mul;
    private Addition add;
    private Subtraction sub;

    @BeforeEach
    public void startTest() {
        div = new Division(10);
        mul = new Multiplication(10);
        add = new Addition(10);
        sub = new Subtraction(10);
    }

    @Test
    public void testAddition() {
        Assertions.assertEquals(30, add.execute(20));
    }

    @Test
    public void testSubtraction() {
        Assertions.assertEquals(-5, sub.execute(5));
    }

    @Test
    public void testMultiplication() {
        Assertions.assertEquals(50, mul.execute(5));
    }

    @Test
    public void testDivision() {
        Assertions.assertEquals(1, div.execute(10));
    }
}
