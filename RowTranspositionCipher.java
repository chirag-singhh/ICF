public class RowTranspositionCipher {
    
    public static String encrypt(String text, int cols) {
        // Determine the number of rows needed
        int rows = (int) Math.ceil((double) text.length() / cols);
        char[][] grid = new char[rows][cols];
        
        // Fill the grid row by row with the text, padding with 'X' if necessary
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = (index < text.length()) ? text.charAt(index++) : 'X';
            }
        }

        // Read the grid column by column and append to the result
        StringBuilder encrypted = new StringBuilder();
        for (int j = 0; j < cols; j++) {
            for (int i = 0; i < rows; i++) {
                encrypted.append(grid[i][j]);
            }
        }

        return encrypted.toString();
    }

    public static void main(String[] args) {
        System.out.println(encrypt("meetmeatthepark", 4)); // Example input
    }
}
