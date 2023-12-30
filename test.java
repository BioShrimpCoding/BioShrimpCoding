


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
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        scanner.close();

        // Check if the credentials exist
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            System.out.println("Logging in...");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Logged in successfully.");
            mainThing.run();
        } else {
            // Save the new credentials
            credentials.put(username, password);
            saveCredentials(credentials);

            System.out.println("Credentials saved successfully.");
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
}

