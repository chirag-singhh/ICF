import java.util.Scanner;
import java.util.Random;

public class SecureAuthentication {

    // Simulated user database with username and password
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password123";
    private static final String USER_EMAIL = "user@example.com"; // User's email for OTP delivery

    // Method to send OTP (simulation)
    public static void sendOtp(String email, String otp) {
        // In a real-world application, use an API like JavaMail or Twilio
        System.out.println("Sending OTP to: " + email);
        System.out.println("Your OTP is: " + otp);  // Simulate sending OTP
    }

    // Method to generate a random OTP
    public static String generateOtp() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);  // Generate a 6-digit OTP
        return String.valueOf(otp);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Username and Password Authentication
        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        // Verify credentials
        if (USERNAME.equals(username) && PASSWORD.equals(password)) {
            System.out.println("Login Successful. Proceeding to OTP verification.");

            // Step 2: Generate OTP
            String otp = generateOtp();

            // Step 3: Send OTP to the user's email (simulation)
            sendOtp(USER_EMAIL, otp);

            // Step 4: Get OTP input from the user
            System.out.print("Enter the OTP you received: ");
            String userOtp = sc.nextLine();

            // Step 5: Verify OTP
            if (otp.equals(userOtp)) {
                System.out.println("Authentication Successful! You are logged in.");
            } else {
                System.out.println("Invalid OTP. Authentication Failed.");
            }
        } else {
            System.out.println("Invalid Username or Password.");
        }
        sc.close();
    }
}
