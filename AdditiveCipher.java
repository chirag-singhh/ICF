import java.util.Scanner;

public class AdditiveCipher {
    static String encrypt(String text, int key) {
        StringBuilder result = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                result.append((char)((c - base + key) % 26 + base));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    static String decrypt(String text, int key) {
        return encrypt(text, 26 - key);
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
