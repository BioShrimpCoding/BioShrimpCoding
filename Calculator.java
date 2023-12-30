

import java.util.Scanner;

public class Calculator  {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("mortgage or normal calculator? (m/n)");
        String type = scanner.nextLine();

        if (type.equals("m")) {
            try (scanner) {
                System.out.print("Loan: ");
                int loan = scanner.nextInt();

                System.out.print("Interest: ");
                float interest = scanner.nextFloat();

                System.out.print("Years: ");
                byte years = scanner.nextByte();

                int months = 12;
                int monthlyPayment = (int) (loan * (interest / months) / (1 - Math.pow(1 + interest / months, -months * years)));

                String mortgage = "Your yearly payment is $" + monthlyPayment;
                System.out.println(mortgage);
            }
        } else if (type.equals("n")) {
            try (scanner) {
                System.out.print("Enter the first number: ");
                double num1 = scanner.nextDouble();

                System.out.print("Enter the second number: ");
                double num2 = scanner.nextDouble();

                System.out.print("Enter the operator (+, -, *, /): ");
                char operator = scanner.next().charAt(0);

                double result;

                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        result = num1 / num2;
                        break;
                    default:
                        System.out.println("Invalid operator");
                        scanner.close();
                        return;
                }

                System.out.println("Result: " + result);

                scanner.close();
            }
       
        } else {
            System.out.println("Invalid input");
    }
}
}
