import java.util.*;

public class PlayfairCipher {

    static char[][] matrix = new char[5][5];
    static String key = "KEYWORD"; // You can change this key

    // Method to remove duplicates and build matrix
    static void generateMatrix(String key) {
        key = key.toUpperCase().replaceAll("[^A-Z]", "").replace("J", "I");

        Set<Character> used = new LinkedHashSet<>();
        for (char c : key.toCharArray()) {
            used.add(c);
        }
        for (char c = 'A'; c <= 'Z'; c++) {
            if (c != 'J') used.add(c);
        }

        Iterator<Character> it = used.iterator();
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                if (it.hasNext()) matrix[i][j] = it.next();
    }

    // Method to preprocess the plaintext
    static String prepareText(String text) {
        text = text.toUpperCase().replaceAll("[^A-Z]", "").replace("J", "I");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char a = text.charAt(i);
            char b = (i + 1 < text.length()) ? text.charAt(i + 1) : 'X';

            sb.append(a);
            if (a == b) {
                sb.append('X');
            } else if (i + 1 < text.length()) {
                sb.append(b);
                i++;
            } else {
                sb.append('X');
            }
        }
        return sb.toString();
    }

    // Get position of character in matrix
    static int[] getPos(char c) {
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                if (matrix[i][j] == c)
                    return new int[]{i, j};
        return null;
    }

    // Encrypt digraph
    static String encryptPair(char a, char b) {
        int[] pos1 = getPos(a);
        int[] pos2 = getPos(b);

        if (pos1[0] == pos2[0]) {
            return "" + matrix[pos1[0]][(pos1[1] + 1) % 5] + matrix[pos2[0]][(pos2[1] + 1) % 5];
        } else if (pos1[1] == pos2[1]) {
            return "" + matrix[(pos1[0] + 1) % 5][pos1[1]] + matrix[(pos2[0] + 1) % 5][pos2[1]];
        } else {
            return "" + matrix[pos1[0]][pos2[1]] + matrix[pos2[0]][pos1[1]];
        }
    }

    // Encrypt full text
    static String encrypt(String plaintext) {
        String text = prepareText(plaintext);
        StringBuilder cipher = new StringBuilder();

        for (int i = 0; i < text.length(); i += 2) {
            cipher.append(encryptPair(text.charAt(i), text.charAt(i + 1)));
        }

        return cipher.toString();
    }

    // Print matrix (for visualization)
    static void printMatrix() {
        System.out.println("Playfair Matrix:");
        for (char[] row : matrix) {
            for (char c : row) System.out.print(c + " ");
            System.out.println();
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter key: ");
        key = sc.nextLine();
        generateMatrix(key);
        printMatrix();

        System.out.print("Enter plaintext: ");
        String plaintext = sc.nextLine();

        String encrypted = encrypt(plaintext);
        System.out.println("Encrypted text: " + encrypted);
        sc.close();
    }
}
// Enter key: MONARCHY
// Enter plaintext: HELLO
