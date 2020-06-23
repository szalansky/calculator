package calculator;

public class Division implements Operation {
    private double divisor;

    public Division(double divisor) {
        this.divisor = divisor;
    }
    @Override
    public double execute(double number) {
        return number / divisor;
    }
}