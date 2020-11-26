/**
 * A class that encrypts and decrypts text using a four-square cipher.
 * @author ivorgilmartin
 */
public class FourSquareCipher {

    private String encryptedBigram;
    private String decryptedBigram;
    private String[][] matrix = { 
            { "A", "B", "C", "D", "E", "Z", "G", "P", "T", "F" },
            { "F", "G", "H", "I", "K", "O", "I", "H", "M", "U" }, 
            { "L", "M", "N", "O", "P", "W", "D", "R", "C", "N" },
            { "Q", "R", "S", "T", "U", "Y", "K", "E", "Q", "A" }, 
            { "V", "W", "X", "Y", "Z", "X", "V", "S", "B", "L" },
            { "M", "F", "N", "B", "D", "A", "B", "C", "D", "E" }, 
            { "C", "R", "H", "S", "A", "F", "G", "H", "I", "K" },
            { "X", "Y", "O", "G", "V", "L", "M", "N", "O", "P" }, 
            { "I", "T", "U", "E", "W", "Q", "R", "S", "T", "U" },
            { "L", "Q", "Z", "K", "P", "V", "W", "X", "Y", "Z" } 
    };

    /**
     * Splits the plaintext into an array of bigrams. Encrypts each bigram 
     * with encryptBigram(). Then uses a StringBuilder to combine the result
     * into an encrypted string. 
     * @param plainText - the plaintext to be encrypted
     * @return - the encrypted plaintext
     */
    public String encryptString(String plainText) {

        StringBuilder sb = new StringBuilder();
        if (plainText.length() % 2 != 0) {
            plainText = plainText + 'X';
        }
        String[] bigrams = plainText.split("(?<=\\G.{2})");
        for (int i = 0; i < bigrams.length; i++) {
            sb.append(encryptBigram(bigrams[i]));
        }
        return sb.toString();
    }

    /**
     * Encrypts a bigram using a four-square cipher.
     * @param bigram  - bigram to be encrypted
     * @return - the encrypted bigram
     */
    public String encryptBigram(String bigram) {

        char pq1 = bigram.charAt(0); // plain quadrant 1
        char pq3 = bigram.charAt(1);
        for (int rowq1 = 0; rowq1 < matrix.length; rowq1++) {
            for (int colq1 = 0; colq1 < matrix.length; colq1++) {
                if (matrix[rowq1][colq1].toString().charAt(0) == pq1 && rowq1 < 5 && colq1 < 5) {
                    for (int row = 0; row < matrix.length; row++) {
                        for (int col = 0; col < matrix.length; col++) {
                            if (matrix[row][col].toString().charAt(0) == pq3 && row > 4 && col > 4) {
                                encryptedBigram = (matrix[rowq1][col] + matrix[row][colq1]);

                            }
                        }
                    }
                }
            }
        }
        return encryptedBigram;
    }

    /**
     * Splits the encrypted text into an array of bigrams. Decrypts each 
     * bigram with decryptBigram(). Then uses a StringBuilder to combine the 
     * result into a decrypted string. 
     * @param  - the text to be decrypted
     * @return - the decrypted text
     */    
    public String decryptString(String cipherText) {
        StringBuilder sb = new StringBuilder();
        String[] bigrams = cipherText.split("(?<=\\G.{2})");
        for (int i = 0; i < bigrams.length; i++) {
            sb.append(decryptBigram(bigrams[i]));
        }
        return sb.toString();

    }

    /**
     * Decrypts a bigram using a four-square cipher.
     * @param bigram  - bigram to be decrypted
     * @return - the decrypted bigram
     */
    public String decryptBigram(String bigram) {
        char pq1 = bigram.charAt(0); // plaintext quadrant 1
        char pq3 = bigram.charAt(1);

        for (int rowq1 = 0; rowq1 < matrix.length; rowq1++) {
            for (int colq1 = 0; colq1 < matrix.length; colq1++) {
                if (matrix[rowq1][colq1].toString().charAt(0) == pq1 && rowq1 < 5 && colq1 > 4) {
                    for (int row = 0; row < matrix.length; row++) {
                        for (int col = 0; col < matrix.length; col++) {
                            if (matrix[row][col].toString().charAt(0) == pq3 && row > 4 && col < 5) {
                                decryptedBigram = (matrix[rowq1][col] + matrix[row][colq1]);
                            }

                        }

                    }
                }
            }
        }
        return decryptedBigram;
    }

    /**
     * Uses the keys provided by the user to set the ciphertext.
     * @param key1 - ciphertext for quadrant 2
     * @param key2 - ciphertext for quadrant 3
     */
    public void changeMatrix(String key1, String key2) {
        int key1Index = 0;
        int key2Index = 0;
        for (int row = 0; row < 5; row++) {
            for (int col = 5; col < matrix[row].length; col++) {
                matrix[row][col] = Character.toString(key1.charAt(key1Index));
                key1Index++;
            }
        }
        for (int row = 5; row < matrix.length; row++) {
            for (int col = 0; col < 5; col++) {
                matrix[row][col] = Character.toString(key2.charAt(key2Index));
                key2Index++;
            }
        }
    }

}
