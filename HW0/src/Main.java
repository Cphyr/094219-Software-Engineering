import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    /**
     * Prints a message according to a given grade.
     *
     * It is guaranteed that the grade is within the range [0, 100].
     *
     * @param grade The grade
     */
    public static void gradeMessage(int grade) {
        /*
        In order to decrease complexity, we decreased the number of cases in the jump table.

         */

        int compressed_grade = (grade / 10) - 7;
        switch (compressed_grade){
            case 0:
                System.out.println("Good"); //grade/10 -7 =0 <=> grade/10=7 <=> 70<=grade<=79
                break;
            case 1:
                System.out.println("Very Good"); //grade/10 -7 =1 <=> grade/10=8 <=> 80<=grade<=89
                break;
            case 2:
                System.out.println("Great"); //grade/10 -7=2 <=> grade/10=89 <=> 890<=grade<=99
                break;
            case 3:
                System.out.println("Excellent"); //grade/10 -7=3 <=> grade/10=10 <=> grade=100
                break;
            default:
                System.out.println("OK"); //otherwise, print 'OK'
        }
    }

    /**
     * Compresses a given string.
     *
     * The compression process is done by replacing a sequence of identical consecutive characters
     * with that same character followed by the length of sequence.
     *
     * It is guaranteed that the string contains only letters (lowercase and uppercase).
     *
     * @param stringToCompress The string to compress
     * @return The compressed version of the string
     */
    public static String compressString(String stringToCompress) {
        String compressedString = "";

        /*
        TODO: Your code for part B1 is here...
        Note: you may change the given code, but you must not change the signature of the method.
         */
        int len = stringToCompress.length(); // get the len of the string

        /*
        * begin is the index of beginning of the seq of similar chars
        * end is the index of the end
        * */
        for (int begin = 0; begin < len; ++begin){
            char first_of_seq = stringToCompress.charAt(begin);

            int end;
            for (end = begin; end < len; ++end){
                if (stringToCompress.charAt(end) != first_of_seq) {
                    break;
                }
            }

            Integer len_of_seq = end - begin; // end - begin is the count of similar chars
            begin = end - 1; // cause the for loop will add the 1

            compressedString += first_of_seq + len_of_seq.toString(); // concat the strings
        }

        return compressedString;
    }
    /**
     * Get the seq of letters before the first number in str starting from a given location
     *
     * It's guaranteed that he string contains only letters and numbers
     *
     * @param i index to start the search from
     * @param str the string to search
     * @return All the letters from i (inclusive) to the first number (exclusive) in order.
     * */
    public static String get_sequence(String str, int i){

        String seq = "";

        int len = str.length();
        for (;i < len; ++i){
            char c = str.charAt(i);
            if (c >= 'A' && c <= 'z') // There's no numbers between 'A' and 'z'
                seq += String.valueOf(c);
            else // Reached the end of the letters seq
                break;
        }

        return seq;
    }

    /**
     * Decompresses a given string.
     *
     * The decompression process is done by duplicating each sequence of characters
     * according to the number which appears after the sequence.
     *
     * It is guaranteed that the string is a legal compressed string.
     *
     * @param compressedString The string to decompress
     * @return The decompressed string
     */
    public static String decompressString(String compressedString) {
        String decompressedString = "";

        /*
        TODO: Your code for part B2 is here...
        Note: you may change the given code, but you must not change the signature of the method.
         */
        int len = compressedString.length();

        for (int i = 0; i < len; ++i){
            String seq = get_sequence(compressedString, i); // get a seq
            int len_seq = seq.length();
            int num_to_dup = 0; // will store the number of times the seq should be duplicated

            int j;
            // convert the numbers after the seq into int
            for (j = i + len_seq; j < len; ++j) {
                char c = compressedString.charAt(j);
                if (c >= 'A' && c <= 'z'){
                    // if c isn't a number, we reached the end of the number
                    i = j - 1;
                    break;
                }

                // converting to number
                int num = c - '0';
                num_to_dup *= 10;
                num_to_dup += num;

            }

            // append the seq, the num_to_dup times
            for (int k = 0; k < num_to_dup; ++k){
                decompressedString += seq;
            }

            // if the for loop exited because we reached the end of the string, we finished.
            if (!(j < len))
                break;
        }


        return decompressedString;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String filePath = args[0];
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        // Tests for part A
        int numberOfGrades = scanner.nextInt();
        for (int i = 0; i < numberOfGrades; i++) {
            int grade = scanner.nextInt();
            gradeMessage(grade);
        }

        // Tests for part B1
        int numberOfStringsToCompress = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numberOfStringsToCompress; i++) {
            String stringToCompress = scanner.nextLine();
            String compressedString = compressString(stringToCompress);
            System.out.println("The compressed version of " + stringToCompress + " is " + compressedString);
        }

        // Tests for part B2
        int numberOfDecompressedStrings = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numberOfDecompressedStrings; i++) {
            String compressedString = scanner.nextLine();
            String decompressedString = decompressString(compressedString);
            System.out.println("The decompressed version of " + compressedString + " is " + decompressedString);
        }

        // Tests for both part B1 and B2
        int numberOfCombinedTests = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numberOfCombinedTests; i++) {
            String stringToCompress = scanner.nextLine();
            String compressedString = compressString(stringToCompress);
            String decompressedString = decompressString(compressedString);
            System.out.println("decompress(compress(" + stringToCompress + ")) == " + stringToCompress + "? " + stringToCompress.equals(decompressedString));
        }
    }
}
