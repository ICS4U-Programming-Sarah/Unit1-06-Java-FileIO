import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
* This program uses a loop to calculates the
* sum of numbers. It tells the user if input
* is valid or not, by reading file.
*
* @author  Sarah Andrew
* @version 1.0
*
* @since   2023-03-10
*/

public final class FileIO {

    /**
     * This is a private constructor used to satisfy the
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private FileIO() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     */
    public static void main(String[] args) {
        // Pass path to file as parameter.
        final File file = new File("input.txt");
        final File fileOut = new File("output.txt");

        try {
            // Create FileWriter object to write to file.
            final FileWriter fW = new FileWriter(fileOut);
            // Create Scanner object to read from file.
            final Scanner sc = new Scanner(file);
            // Create PrintWriter object to write to file.
            final PrintWriter write = new PrintWriter(fW);

            while (sc.hasNextLine()) {
                // Read line as string.
                final String newLine = sc.nextLine();

                // In case of user entering empty line,
                // display sum as in 0.
                if (newLine.isEmpty()) {
                    write.println("The sum of numbers is: 0");
                    continue;
                }
                // Split string into any array of strings.
                final String[] arrayOfString = newLine.split(" ");

                // Initialize variable.
                int sum = 0;
                int elementInt = 0;

                // For each loop to access string in file.
                for (String elementStr : arrayOfString) {
                    // Usage of try catch statement to detect
                    // possible errors.
                    try {
                        // Convert from string to int.
                        elementInt = Integer.parseInt(elementStr);

                        // Calculate sum.
                        sum = sum + elementInt;

                    } catch (NumberFormatException error) {
                        // Display error to user.
                        write.println("Invalid input, "
                                + error.getMessage());
                        // Continue to next line
                        continue;
                    }
                }
                // Display sum to user.
                write.println("The sum of numbers is: " + sum);

            }
            // Closes scanner & writer.
            write.close();
            sc.close();
        } catch (IOException error) {
            System.out.println("An error occurred: "
                + error.getMessage());
        }
    }
}
