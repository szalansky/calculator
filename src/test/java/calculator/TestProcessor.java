package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestProcessor {
    private Processor processor;

    @BeforeEach
    public void startTest() {
        processor = new Processor();
    }

    @Test
    public void testInitState() {
        Assertions.assertEquals(0.0, processor.getAcc());
    }

    @Test
    public void testApplyWithoutOpts() {
        processor.addOperation("apply 10");
        Assertions.assertEquals(0.0, processor.getAcc());
    }

    @Test
    public void testDescriptionExamples() {
        processor.addOperation("add 2");
        processor.addOperation("multiply 3");
        processor.addOperation("apply 3");
        Assertions.assertEquals(15, processor.getAcc());
        processor.addOperation("multiply 9");
        processor.addOperation("apply 5");
        Assertions.assertEquals(45, processor.getAcc());
    }

    @Test
    public void testApplyAfterApply() {
        processor.addOperation("add 10");
        processor.addOperation("apply 10");
        Assertions.assertEquals(20.0, processor.getAcc());
        processor.addOperation("add 20");
        processor.addOperation("apply 30");
        Assertions.assertEquals(50.0, processor.getAcc());
    }

    @Test
    public void testOperations() {
        processor.addOperation("add 2");
        processor.addOperation("multiply 9");
        processor.addOperation("divide 15");
        processor.addOperation("subtract 2");
        processor.addOperation("apply 3");
        Assertions.assertEquals(1, processor.getAcc());
    }

    @Test
    public void testInvalidOp() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> { processor.addOperation("invalidop 30"); });
    }

    @Test
    public void testNonNumericArgument() {
        Assertions.assertThrows(
                NumberFormatException.class,
                () -> { processor.addOperation("add @"); });
    }

    @Test
    public void testMalformedOp() {
        Assertions.assertThrows(
                MalformedOperationException.class,
                () -> { processor.addOperation("add"); });
    }
}
