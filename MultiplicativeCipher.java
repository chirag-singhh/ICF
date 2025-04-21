import java.util.Scanner;

public class MultiplicativeCipher {
    static String encrypt(String text, int key) {
        StringBuilder result = new StringBuilder();
        for(char c : text.toCharArray()){
            if(Character.isLetter(c)){
                char base = Character.isUpperCase(c)?'A':'a';
                result.append((char)((((c - base) * key) % 26) + base));
            }
            else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static String decrypt(String text, int key) {
        int inverseKey = modInverse(key, 26); // Find modular inverse
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                result.append((char)(((inverseKey * (c - base)) % 26 + 26) % 26 + base));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
    public static int modInverse(int a, int m) {
        a = a % m;
        for (int x = 1; x < m; x++) {
            if ((a * x) % m == 1)
                return x;
        }
        throw new IllegalArgumentException("No modular inverse for key " + a);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  
        String text = sc.nextLine();
        int key = sc.nextInt();
        String encrypted = encrypt(text, key);
        String decrypted = decrypt(encrypted, key);
        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypted);
        sc.close();
    }
}
