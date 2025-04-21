public class AutoKeyCipher {

    // Encryption
    public static String encrypt(String text, String key) {
        key = key.toUpperCase() + text.toUpperCase();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            char k = key.charAt(i);
            char e = (char)(((c - 'A') + (k - 'A')) % 26 + 'A');
            result.append(e);
        }
        return result.toString();
    }

    // Decryption
    public static String decrypt(String cipher, String key) {
        key = key.toUpperCase();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < cipher.length(); i++) {
            char k;
            if (i < key.length()) {
                k = key.charAt(i);
            } else {
                k = result.charAt(i - key.length()); // Use recovered plain text
            }
            char c = cipher.charAt(i);
            char d = (char)(((c - k + 26) % 26) + 'A');
            result.append(d);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String plaintext = "AATACKISTODAYAUTOKEY";
        String key = "KEY";

        String encrypted = encrypt(plaintext, key);
        String decrypted = decrypt(encrypted, key);

        System.out.println("Plaintext : " + plaintext);
        System.out.println("Encrypted : " + encrypted);
        System.out.println("Decrypted : " + decrypted);
    }
}
