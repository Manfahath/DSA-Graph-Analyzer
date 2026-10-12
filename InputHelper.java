import java.util.Scanner;

/**
 * Centralised, validated console input. Re-prompts until valid input is given.
 */
public class InputHelper {
    private static final Scanner SC = new Scanner(System.in);

    /** Reads an integer (any value). */
    public static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (!SC.hasNextLine()) {          // end of input -> exit cleanly
                System.out.println("\nInput closed. Exiting.");
                System.exit(0);
            }
            String line = SC.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("  Invalid input. Please enter a whole number.");
            }
        }
    }

    /** Reads an integer within [min, max]. */
    public static int readInt(String prompt, int min, int max) {
        while (true) {
            int v = readInt(prompt);
            if (v >= min && v <= max) return v;
            System.out.println("  Please enter a number between " + min + " and " + max + ".");
        }
    }

    /** Reads a menu choice within [min, max]. */
    public static int readChoice(int min, int max) {
        return readInt("Enter your choice: ", min, max);
    }
}
