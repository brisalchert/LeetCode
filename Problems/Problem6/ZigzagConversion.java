//----------------------------------------------------------------------------------------------------------------------
//  6. Zigzag Conversion
//
//  The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to
//  display this pattern in a fixed font for better legibility)
//
//  P   A   H   N
//  A P L S I I G
//  Y   I   R
//
//  And then read line by line: "PAHNAPLSIIGYIR"
//
//  Write the code that will take a string and make this conversion given a number of rows:
//
//  string convert(string s, int numRows);
//----------------------------------------------------------------------------------------------------------------------

package Problem6;

import java.util.Arrays;

public class ZigzagConversion {
    public static void main(String[] args) {
        String input = "PAYPALISHIRING";
        int numRows = 4;

        System.out.println(convert(input, numRows));
    }

    /**
     * Converts the input string into a zigzag pattern with the given number of rows
     * @param s the input string
     * @param numRows the number of rows
     * @return the zigzag string read left-to-right line by line
     */
    public static String convert(String s, int numRows) {
        // Trivial case
        if (numRows == 1) {
            return s;
        }

        StringBuilder builder = new StringBuilder();
        // Set the number of letters to skip in the first row
        int skipFactor = (2 * (numRows - 1));
        int complementSkipFactor;

        for (int row = 1; row <= numRows; row++) {
            int index = (row - 1);
            boolean diagonal = false;

            // Set the complementSkipFactor for characters on the diagonal
            complementSkipFactor = (2 * (row - 1));

            while (index < s.length()) {
                // Add the character at the current index
                builder.append(s.charAt(index));

                // Increment the index depending on the current row
                if (row == 1) {
                    index += skipFactor;
                }
                else {
                    if (row == numRows) {
                        index += complementSkipFactor;
                    }
                    else {
                        // For middle rows, increment differently if on the diagonal
                        if (diagonal) {
                            index += complementSkipFactor;
                            diagonal = false;
                        }
                        else {
                            index += (skipFactor - complementSkipFactor);
                            diagonal = true;
                        }
                    }
                }
            }
        }

        return builder.toString();
    }
}
