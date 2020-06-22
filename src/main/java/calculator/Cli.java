package calculator;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Cli {
    private LinkedList<String> operationLines;
    private Processor processor;
    public Cli() {
        this.operationLines = new LinkedList<String>();
        this.processor = new Processor();
    }

    public void scanOperations(File file) {
        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()) {
                operationLines.add(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public double execute() {
        for(String line : operationLines) {
            try {
                processor.addOperation(line);
            } catch(IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        return processor.getAcc();
    }

    public static void main(String[] args) {
        Cli cli = new Cli();
        File file = new File(args[0]);
        cli.scanOperations(file);
        System.out.println(cli.execute());
    }
}
