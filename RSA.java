import java.math.BigInteger;
import java.util.Scanner;

public class RSA {

    public static BigInteger gcd(BigInteger a, BigInteger b) {
        if (b.equals(BigInteger.ZERO))
            return a;
        return gcd(b, a.mod(b));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Choose 2 prime numbers
        BigInteger p = BigInteger.valueOf(3);  // example prime
        BigInteger q = BigInteger.valueOf(13);  // example prime

        // Step 2: Calculate n = p * q
        BigInteger n = p.multiply(q);

        // Step 3: Compute phi = (p-1)*(q-1)
        BigInteger phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));

        // Step 4: Choose e such that 1 < e < phi and gcd(e, phi) = 1
        BigInteger e = BigInteger.valueOf(17);  // common choice

        // Step 5: Compute d (private key) such that d*e ≡ 1 mod phi
        BigInteger d = e.modInverse(phi);

        System.out.println("Public Key (e, n): (" + e + ", " + n + ")");
        System.out.println("Private Key (d, n): (" + d + ", " + n + ")");

        // Step 6: Encryption
        System.out.print("Enter message (as number < " + n + "): ");
        BigInteger msg = sc.nextBigInteger();

        BigInteger cipher = msg.modPow(e, n);
        System.out.println("Encrypted message: " + cipher);

        // Step 7: Decryption
        BigInteger decrypted = cipher.modPow(d, n);
        System.out.println("Decrypted message: " + decrypted);
        sc.close();
    }
}

