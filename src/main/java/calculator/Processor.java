package calculator;

import java.util.LinkedList;
import java.util.List;

enum AvailableOperations {
    apply, add, subtract, multiply, divide
}

interface Operation {
    public double execute(double number);
}

class Addition implements Operation {
    private double augend;

    public Addition(double augend) {
        this.augend = augend;
    }

    @Override
    public double execute(double number) {
        return number + augend;
    }
}

class Subtraction implements Operation {
    private double subtrahend;

    public Subtraction(double subtrahend) {
        this.subtrahend = subtrahend;
    }
    @Override
    public double execute(double number) {
        return number - subtrahend;
    }
}

class Multiplication implements Operation {
    private double multiplicand;

    public Multiplication(double multiplicand) {
        this.multiplicand = multiplicand;
    }
    @Override
    public double execute(double number) {
        return number * multiplicand;
    }
}

class Division implements Operation {
    private double divisor;

    public Division(double divisor) {
        this.divisor = divisor;
    }
    @Override
    public double execute(double number) {
        return number / divisor;
    }
}

public class Processor {
    private double acc;
    private List<Operation> operations;

    public Processor() {
        this.acc = 0.0;
        this.operations = new LinkedList<>();
    }

    public Processor(double acc) {
        this.acc = acc;
    }

    public double getAcc() {
        return acc;
    }

    private void calculate(double number) {
        if(operations.isEmpty())
            return;
        acc = number;
        for(Operation opt : operations) {
            acc = opt.execute(acc);
        }
        operations.clear();
    }

    public void addOperation(String line) {
        String[] parts = line.split(" ");
        if(parts.length == 2) {
            try {
                double val = Double.valueOf(parts[1]);
                switch(AvailableOperations.valueOf(parts[0])) {
                    case add:
                        operations.add(new Addition(val));
                        break;
                    case subtract:
                        operations.add(new Subtraction(val));
                        break;
                    case multiply:
                        operations.add(new Multiplication(val));
                        break;
                    case divide:
                        operations.add(new Division(val));
                        break;
                    case apply:
                        calculate(val);
                        break;
                }
            } catch(IllegalArgumentException e) {
                System.err.println("Illegal operation");
                e.printStackTrace();
            }
        }
    }
}
