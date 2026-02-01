// Name: Camellia Yi
// Date: 11/16/2025
// Class: CS&141 3130
// Assignment: CamelliaYiMadLibs
// Purpose: Create a mad lib generating program.

import java.util.*;
import java.io.*;

public class CamelliaYiMadLibs2 {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        printIntro();

        boolean done = false;
        while (!done) {
            char choice = promptMenuChoice(console);

            if (choice == 'C') {
                createMadLib(console);
            } else if (choice == 'V') {
                viewMadLib(console);
            } else if (choice == 'Q') {
                System.out.println("Buh-bye!");
                done = true;
            }
        }
    }

    // ─────────────────────────────────────────

    public static void printIntro() {
        System.out.println("Welcome to Cam's Mad Libs!");
        System.out.println("This program lets you create and view mad lib stories.");
        System.out.println();
    }

    // ─────────────────────────────────────────

    public static char promptMenuChoice(Scanner console) {
        while (true) {
            System.out.print("(C)-Create mad-lib, (V)-View mad-lib, (Q)-Quit? ");
            String line = console.nextLine().trim();

            if (line.length() > 0) {
                char ch = Character.toUpperCase(line.charAt(0));
                if (ch == 'C' || ch == 'V' || ch == 'Q') {
                    return ch;
                }
            }

            System.out.println("Invalid choice; please type C, V, or Q.");
        }
    }

    // ─────────────────────────────────────────

    public static void createMadLib(Scanner console) {
        System.out.println();
        System.out.println("Create a mad-lib from a template.");

        File inputFile = promptForExistingFile(console, "Input file name? ");

        if (inputFile == null) {
            System.out.println("Returning to menu.");
            return;
        }

        System.out.print("Output file name? ");
        String outputName = console.nextLine().trim();

        try (PrintStream out = new PrintStream(outputName);
             Scanner input = new Scanner(inputFile)) {

            processMadLibTemplate(console, input, out);
            System.out.println("Your mad-lib has been created in \"" + outputName + "\".");
            System.out.println();

        } catch (Exception e) {
            System.out.println("Error writing output: " + e.getMessage());
        }
    }

    // ─────────────────────────────────────────

    public static void viewMadLib(Scanner console) {
        System.out.println();
        System.out.println("View an existing mad-lib.");

        File file = promptForExistingFile(console, "Mad-lib file name? ");

        if (file == null) {
            System.out.println("Returning to menu.");
            return;
        }

        try (Scanner input = new Scanner(file)) {
            while (input.hasNextLine()) {
                System.out.println(input.nextLine());
            }
            System.out.println();
        } catch (Exception e) {
            System.out.println("Error viewing file: " + e.getMessage());
        }
    }

    // ─────────────────────────────────────────
    // FIXED: now allows quitting + recursive folder search
    // ─────────────────────────────────────────

    public static File promptForExistingFile(Scanner console, String prompt) {
        while (true) {
            System.out.print(prompt);
            String name = console.nextLine().trim();

            // Allow exit
            if (name.equalsIgnoreCase("Q")) {
                return null;
            }

            File f = new File(name);

            // Direct match
            if (f.exists() && f.isFile()) {
                return f;
            }

            // Try recursive search
            File found = searchForFile(new File("."), name);
            if (found != null) {
                return found;
            }

            System.out.println("Sorry, file not found. Type Q to cancel.");
        }
    }

    // ─────────────────────────────────────────
    // NEW: Recursive search for filename in project directory
    // ─────────────────────────────────────────

    public static File searchForFile(File directory, String filename) {
        File[] files = directory.listFiles();
        if (files == null) return null;

        for (File f : files) {
            if (f.isDirectory()) {
                File result = searchForFile(f, filename);
                if (result != null) return result;
            } else if (f.getName().equalsIgnoreCase(filename)) {
                return f;
            }
        }
        return null;
    }

    // ─────────────────────────────────────────

    public static void processMadLibTemplate(Scanner console, Scanner input, PrintStream out) {
        while (input.hasNextLine()) {
            String line = input.nextLine();
            Scanner lineTokens = new Scanner(line);

            while (lineTokens.hasNext()) {
                String token = lineTokens.next();

                if (isPlaceholder(token)) {
                    String placeholderText = getPlaceholderPromptText(token);
                    String article = beginsWithVowel(placeholderText) ? "an" : "a";

                    System.out.print("Please type " + article + " " + placeholderText + ": ");
                    out.print(console.nextLine());
                } else {
                    out.print(token);
                }

                out.print(" ");
            }

            out.println();
            lineTokens.close();
        }
    }

    // ─────────────────────────────────────────

    public static boolean isPlaceholder(String token) {
        return token.startsWith("<") && token.endsWith(">") && token.length() > 2;
    }

    public static String getPlaceholderPromptText(String token) {
        return token.substring(1, token.length() - 1).replace("-", " ");
    }

    public static boolean beginsWithVowel(String text) {
        if (text.length() == 0) return false;
        char c = Character.toLowerCase(text.charAt(0));
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
