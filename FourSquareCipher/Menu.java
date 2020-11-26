import java.util.*;

/**
 * Provides the user interface. Initiates user selections.
 * @author ivorgilmartin
 *
 */
public class Menu {
    private String  resource = null;
    private Parser  parser = new Parser();
    private Scanner scanner = new Scanner(System.in);
    private boolean keepRunning = true;
    private boolean isURL = false;

    /**
     * Renders the default UI.
     * Processes users selections.
     */
    public void start() {
        while (keepRunning) {
            System.out.println("---------4-Square-Cipher---------");
            System.out.println("Please enter an option (1 to 5).");
            System.out.println("(1) Select resource to encrypt.");
            System.out.println("(2) Set keys.");
            System.out.println("(3) Encrypt.");
            System.out.println("(4) Decrypt.");
            System.out.println("(5) Quit.");

            int selection = Integer.parseInt(scanner.next());

            if (selection == 1) {
                fileOrUrl();

            } else if (selection == 2) {
                setKeys();

            } else if (selection == 3) {
                parser.parsePlain(resource, isURL);
            } else if (selection == 4) {
                parser.parseEncrypted();
            } else if (selection == 5) {
                keepRunning = false;
            }

        }

        scanner.close();
    }

    /**
     * Offers the user the option of encrypting a file or URL.
     * Asks user to enter file/URL name. 
     */
    private void fileOrUrl() {
        System.out.println("Select an option.");
        System.out.println("1)File ");
        System.out.println("2)URL ");
        int selection = Integer.parseInt(scanner.next());
        if (selection == 1) {
            System.out.println("Enter file name.");
        } else if (selection == 2) {
            System.out.println("Enter URL.");
            isURL = true;

        }
        resource = scanner.next();
    }

    /**
     * Prompts the user to set ciphertext keys. 
     */
    private void setKeys() {
        System.out.println("Enter key1.");
        String key1 = scanner.next().toUpperCase();
        System.out.println("Enter key2.");
        String key2 = scanner.next().toUpperCase();
        parser.getCipher().changeMatrix(key1, key2);
    }


}
