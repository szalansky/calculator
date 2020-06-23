package calculator;

import java.util.LinkedList;
import java.util.List;

enum AvailableOperations {
    apply, add, subtract, multiply, divide
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

    public void addOperation(String line) throws IllegalArgumentException,
                                                 NumberFormatException,
                                                 MalformedOperationException {
        String[] parts = line.split(" ");
        if(parts.length == 2) {
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
        } else {
            throw new MalformedOperationException("Malformed operation line: " + line);
        }
    }
}
