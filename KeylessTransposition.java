public class KeylessTransposition {

    // Encryption: Swap adjacent characters
    public static String encrypt(String text) {
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length - 1; i += 2) {
            char temp = chars[i];
            chars[i] = chars[i + 1];
            chars[i + 1] = temp;
        }
        return new String(chars);
    }

    // Decryption: Swap adjacent characters again (same as encryption)
    public static String decrypt(String text) {
        return encrypt(text); // Same process as encryption
    }

    public static void main(String[] args) {
        String plaintext = "meetmeatthepark";
        String encrypted = encrypt(plaintext);
        String decrypted = decrypt(encrypted);

        System.out.println("Plaintext : " + plaintext);
        System.out.println("Encrypted : " + encrypted);
        System.out.println("Decrypted : " + decrypted);
    }
}
