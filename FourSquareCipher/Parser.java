import java.io.*;
import java.net.URL;

/**
 * Parses the resource using regular expressions. Uses FourSquareCipher.java 
 * to encrypt/decrypt. Writes the result to file. 
 * @author ivorgilmartin
 */
public class Parser {

    private FourSquareCipher cipher = new FourSquareCipher();

    /**
     * Reads each line of the resource. Removes everything but letters. 
     * Encrypts with FourSquareCipher.java. Writes the resulting 
     * encrypted text to encrypted.txt
     * @param resource -the resource to be encrypted
     * @param isURL - true for URL resource - false for.txt resource
     */
    public void parsePlain(String resource, boolean isURL) {
        try {
            BufferedReader br;
            FileWriter fw = new FileWriter("encrypted.txt");
            if (isURL) {
                br = new BufferedReader(new InputStreamReader(new URL(resource).openStream()));
            } else {
                br = new BufferedReader(new InputStreamReader(new FileInputStream(resource)));
            }

            String line = null;

            while ((line = br.readLine()) != null) {
                line = line.replaceAll("[^A-Za-z0-9 ]", "").toUpperCase().replaceAll("\\s+", "");//original "\\s+", ""
                if (line.isEmpty() == false) { 
                    String encrypted = getCipher().encryptString(line);
                    fw.write(encrypted + "\n");
                }

            }

            br.close();
            fw.flush();
            fw.close();

        } catch (Exception e) {
            System.out.println("Yikes! Something went wrong.");
            e.printStackTrace();
        }
    }

    /**
     * Reads each line of encrypted.txt. Decrypts with FourSquareCypher.java. 
     * Writes the resulting decrypted text to decrypted.txt 
     */
    public void parseEncrypted() {
        File f = new File("encrypted.txt");
        try {

            FileWriter fw = new FileWriter("decrypted.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));

            String line = null;

            while ((line = br.readLine()) != null) {
                String decrypted = getCipher().decryptString(line);
                fw.write(decrypted + "\n");

            }

            br.close();
            fw.flush();
            fw.close();
        } catch (Exception e) {

            System.out.println("Yikes! Something went wrong.");
            e.printStackTrace();
        }
    }

    /**
     * Returns parsers' instance of FourSquareCipher.java
     */
    public FourSquareCipher getCipher() {
        return cipher;
    }


}
