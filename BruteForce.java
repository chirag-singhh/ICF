
public class BruteForce {

    public static void main(String[] args) {

        String password = "zzzzz"; // The password we want to crack

        char[] alphabet = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
                                       'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                                       's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

        boolean solved = false;

        while (!solved) {
            for (int i = 0; i < alphabet.length; i++) {
                for (int j = 0; j < alphabet.length; j++) {
                    for (int k = 0; k < alphabet.length; k++) {
                        for (int l = 0; l < alphabet.length; l++) {
                            for (int m = 0; m < alphabet.length; m++) {

                                String attempt = "" + alphabet[i] + alphabet[j] + alphabet[k] + alphabet[l] + alphabet[m];

                                System.out.println("Trying: " + attempt);

                                if (attempt.equals(password)) {
                                    System.out.println("Password cracked: " + attempt);
                                    solved = true;
                                    break;
                                }
                            }
                            if (solved) break;
                        }
                        if (solved) break;
                    }
                    if (solved) break;
                }
                if (solved) break;
            }
        }
    }
}
