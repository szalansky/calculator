package calculator;

public class Multiplication implements Operation {
    private double multiplicand;

    public Multiplication(double multiplicand) {
        this.multiplicand = multiplicand;
    }
    @Override
    public double execute(double number) {
        return number * multiplicand;
    }
}