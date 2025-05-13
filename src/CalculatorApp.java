import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        if (args.length == 3) {
            try {
                double a = Double.parseDouble(args[0]);
                double b = Double.parseDouble(args[1]);
                char operation = args[2].charAt(0);

                double result = switch (operation) {
                    case '+' -> calc.add(a, b);
                    case '-' -> calc.subtract(a, b);
                    case '*' -> calc.multiply(a, b);
                    case '/' -> calc.divide(a, b);
                    default -> throw new IllegalArgumentException("Unknown operation: " + operation);
                };

                System.out.println("Result: " + result);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format: " + e.getMessage());
            } catch (ArithmeticException e) {
                System.out.println("Math error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }

        } else if (System.console() != null) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter first number:");
            double a = scanner.nextDouble();

            System.out.println("Enter second number:");
            double b = scanner.nextDouble();

            System.out.println("Enter operation (+, -, *, /):");
            char op = scanner.next().charAt(0);

            try {
                double result = switch (op) {
                    case '+' -> calc.add(a, b);
                    case '-' -> calc.subtract(a, b);
                    case '*' -> calc.multiply(a, b);
                    case '/' -> calc.divide(a, b);
                    default -> {
                        System.out.println("Illegal operation.");
                        yield Double.NaN;
                    }
                };

                System.out.println("Result: " + result);
            } catch (ArithmeticException e) {
                System.out.println("Math error: " + e.getMessage());
            }

        } else {
            System.out.println("Error: No arguments provided and interactive mode is not supported.");
            System.out.println("Usage: java CalculatorApp <a> <b> <+|-|*|/>");
            System.exit(1);
        }
    }
}
