public class SalamiAttack {

    private static double userBalance = 1000.00; // Initial balance
    private static final double MIN_WITHDRAWAL = 0.01; // Small amount for attack
    private static double totalWithdrawn = 0.0;

    // Simulate withdrawal (Salami Attack)
    public static void withdrawSalamiAttack() {
        double amount = MIN_WITHDRAWAL; // Small, unnoticed withdrawal
        userBalance -= amount;  // Decrease balance by small amount
        totalWithdrawn += amount; // Keep track of the total withdrawn
        System.out.println("Small Withdrawal: " + amount + ", Total Withdrawn: " + totalWithdrawn);
    }

    // Check if the Salami Attack has exceeded a threshold
    public static boolean isSalamiAttackDetected() {
        // Define a threshold where any amount greater than a set limit is suspicious
        double threshold = 1.0; // Example threshold for detection
        if (totalWithdrawn >= threshold) {
            System.out.println("Salami Attack Detected: Total withdrawal exceeds threshold of " + threshold);
            return true; // Attack detected
        }
        return false;
    }

    // Main method
    public static void main(String[] args) {
        // Simulate small withdrawals multiple times
        for (int i = 0; i < 2000; i++) {
            withdrawSalamiAttack();  // Perform the attack
            if (isSalamiAttackDetected()) {
                break; // Stop if the attack is detected
            }
        }

        // Final balance after attack
        System.out.println("Final User Balance: " + userBalance);
    }
}
