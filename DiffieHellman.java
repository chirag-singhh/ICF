import java.util.Scanner;

public class DiffieHellman {

    public static int power(int base, int exponent, int mod) {
        int result = 1;
        base = base % mod;

        while (exponent > 0) {
            if ((exponent & 1) == 1)  // If exponent is odd
                result = (result * base) % mod;

            exponent = exponent >> 1;  // exponent = exponent / 2
            base = (base * base) % mod;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Publicly shared prime numbers
        System.out.print("Enter a prime number (P): ");
        int P = sc.nextInt();

        System.out.print("Enter a primitive root modulo P (G): ");
        int G = sc.nextInt();

        // Private keys
        System.out.print("Enter private key for Alice (a): ");
        int a = sc.nextInt();

        System.out.print("Enter private key for Bob (b): ");
        int b = sc.nextInt();

        // Calculate public keys
        int x = power(G, a, P); // Alice's public key
        int y = power(G, b, P); // Bob's public key

        // Exchange public keys and generate shared secret
        int keyA = power(y, a, P); // Alice receives Bob's public key and computes
        int keyB = power(x, b, P); // Bob receives Alice's public key and computes

        System.out.println("\nAlice's Public Key: " + x);
        System.out.println("Bob's Public Key: " + y);
        System.out.println("\nShared Secret Key (Alice): " + keyA);
        System.out.println("Shared Secret Key (Bob): " + keyB);
        sc.close();
    }
}
