package calculator;

public class Addition implements Operation {
    private double augend;

    public Addition(double augend) {
        this.augend = augend;
    }

    @Override
    public double execute(double number) {
        return number + augend;
    }
}