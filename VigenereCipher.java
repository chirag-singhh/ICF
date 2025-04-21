public class VigenereCipher {

    // Encryption using Vigenère Cipher
    public static String encrypt(String text, String key) {
        StringBuilder result = new StringBuilder();
        key = key.toUpperCase();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            char k = key.charAt(i % key.length());
            char e = (char)(((c - 'A') + (k - 'A')) % 26 + 'A');
            result.append(e);
        }
        return result.toString();
    }

    // Decryption using Vigenère Cipher
    public static String decrypt(String text, String key) {
        StringBuilder result = new StringBuilder();
        key = key.toUpperCase();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            char k = key.charAt(i % key.length());
            char d = (char)((((c - 'A') - (k - 'A') + 26) % 26) + 'A'); // +26 to ensure positive result
            result.append(d);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String plaintext = "HELLO";
        String key = "KEY";

        String encrypted = encrypt(plaintext, key);
        String decrypted = decrypt(encrypted, key);

        System.out.println("Plaintext : " + plaintext);
        System.out.println("Encrypted : " + encrypted);
        System.out.println("Decrypted : " + decrypted);
    }
}
