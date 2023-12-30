
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class MainThing {
    public static void main(String[] args) {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
    public void run() {
       Scanner scanner = new Scanner(System.in);
       Calculator calculator = new Calculator();

        

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.print("Choices: \n 1. Calculator \n 2. GPA Calculator \n 3. Exit \n");
        String Choice = scanner.nextLine();{
        if (Choice.equals("calculator") || Choice.equals("c")) {
            
            calculator.run();
            scanner.close();
         if (Choice.equals("exit") || Choice.equals("e")) 
            System.exit(0);
        }
        else if (Choice.equals("GPA Calculator") || Choice.equals("gpa calculator") || Choice.equals("gpa") || Choice.equals("GPA") || Choice.equals("g")) {
            Gpa gpa = new Gpa();
            gpa.calculateGpa();
            scanner.close();
        }
        else {
            System.out.println("Invalid choice. Please try again.");
            run();
        }
       
        
        




    }
    }
}




