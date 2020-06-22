package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

public class TestCli {
    private Cli cli;

    @BeforeEach
    public void startTest() {
        cli = new Cli();
    }

    @Test
    public void testWithFile() {
        File file = new File(getClass()
                .getClassLoader()
                .getResource("operations.txt")
                .getFile());
        cli.scanOperations(file);
        Assertions.assertEquals(15, cli.execute());
    }
}
