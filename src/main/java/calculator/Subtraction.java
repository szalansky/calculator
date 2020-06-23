package calculator;

public class Subtraction implements Operation {
    private double subtrahend;

    public Subtraction(double subtrahend) {
        this.subtrahend = subtrahend;
    }
    @Override
    public double execute(double number) {
        return number - subtrahend;
    }
}