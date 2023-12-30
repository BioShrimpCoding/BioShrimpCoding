
import java.util.Scanner;

public class Gpa {
    public static void main(String[] args) {
        Gpa gpa = new Gpa();
        gpa.calculateGpa();
    }

    public void calculateGpa() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the GPA calculator.");
        System.out.print("Enter number of classes: ");
        int classes = scanner.nextInt();
        
        Float[] arr = new Float[classes];
        System.out.println("Enter your grades by number:");
        System.out.println("4.0 = A, 3.0 = B, 2.0 = C, 1.0 = D, 0.0 = F");
        for (int i = 0; i < classes; i++) {
            arr[i] = scanner.nextFloat();
        }
        
        Float sum = 0f;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        
        Float average = sum / arr.length; // Divide the sum by the length of the array
        
        System.out.println("You're GPA: " + average);
        
        scanner.close();
    }
}
