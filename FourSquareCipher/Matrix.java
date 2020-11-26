/**
 * A class with static methods for testing 2D array operations.
 * @author ivorgilmartin
 *
 */
public class Matrix {

    public static void printMatrix(String[][] matrix){
        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static String[][] changeMatrix(String[][] matrix){
        String key1 = "QWERTYUIOPASDFGHKLZXCVBNM";
        int key1Index = 0;
        String key2 = "MNBVCXZLKHGFDSAPOIUYTREWQ";
        int key2Index = 0;        
        for(int row = 0; row < 5; row++) {
            for(int col = 5; col < matrix[row].length; col++) {
                matrix[row][col] = Character.toString(key1.charAt(key1Index));
                key1Index++;
            }
        }
        for(int row = 5; row < matrix.length; row++) {
            for(int col = 0; col < 5; col++) {
                matrix[row][col] = Character.toString(key2.charAt(key2Index));
                key2Index++;
            }
        }
        return matrix;
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        int recurse = factorial(n - 1);
        int result = n * recurse;
        return result;
    }

    public static void main(String[] args) {
        String[][] matrix = { 
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

        printMatrix(matrix);
        System.out.println();
        changeMatrix(matrix);
        printMatrix(matrix);
        System.out.println();
        System.out.println(factorial(25));

    }
}