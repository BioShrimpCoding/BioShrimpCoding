

 
import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class test {
    private static final String FILE_PATH = "/workspaces/BioShrimpCoding/user_credentials.txt";

    public static void main(String[] args) {
        // Load existing credentials from file
        Map<String, String> credentials = loadCredentials();

        // Prompt user for username and password
        MainThing mainThing = new MainThing();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Log in or sign up? (l/s)");
        String choice = scanner.nextLine();
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Check if the credentials exist
        if (choice.equals("l") || choice.equals("log in")) {
            if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
                System.out.println("Logging in...");
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Logged in successfully.");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("hello");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mainThing.run();
            }
        } else if (choice.equals("s") || choice.equals("sign up")) {
            
                if (credentials.containsKey(username)) {
                    System.out.println("Username already exists. Please choose a different username.");
                    test.SighnIn();
                } else {
                    // Add the new credentials
                    credentials.put(username, password);

                    // Save the updated credentials
                    saveCredentials(credentials);

                    System.out.println("Account created successfully.");
                    
                }
            
        }
                
                
    }
    
    


    private static Map<String, String> loadCredentials() {
        Map<String, String> credentials = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String username = parts[0];
                    String password = parts[1];
                    credentials.put(username, password);
                }
            }
        } catch (IOException e) {
            // Handle file read error
            System.err.println("Error loading credentials: " + e.getMessage());
        }

        return credentials;
    }

    private static void saveCredentials(Map<String, String> credentials) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Map.Entry<String, String> entry : credentials.entrySet()) {
                String username = entry.getKey();
                String password = entry.getValue();
                writer.write(username + ":" + password);
                writer.newLine();
            }
        } catch (IOException e) {
            // Handle file write error
            System.err.println("Error saving credentials: " + e.getMessage());
        }
    }
    
    private static void SighnIn(){
        Map<String, String> credentials = loadCredentials();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        if (credentials.containsKey(username)) {
            System.out.println("Username already exists. Please choose a different username.");
        test.SighnIn();
        }
    else {
            // Add the new credentials
            credentials.put(username, password);

            // Save the updated credentials
            saveCredentials(credentials);

            System.out.println("Account created successfully.");         }
        

    }
}

