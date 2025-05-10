import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        double a = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        double b = scanner.nextDouble();

        System.out.println("Choose the action: + - * /");
        char operation = scanner.next().charAt(0);

        double result = 0;
        boolean valid = true;

        try {
            switch (operation) {
                case '+':
                    result = calc.add(a, b);
                    break;
                case '-':
                    result = calc.subtract(a, b);
                    break;
                case '*':
                    result = calc.multiply(a, b);
                    break;
                case '/':
                    result = calc.divide(a, b);
                    break;
                default:
                    System.out.println("Illegal action.");
                    valid = false;
            }

            if (valid) {
                System.out.println("Result: " + result);
            }
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}