//----------------------------------------------------------------------------------------------------------------------
//  68. Text Justification
//
//  Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth
//  characters and is fully (left and right) justified.
//
//  You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad
//  extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
//
//  Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does
//  not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on
//  the right.
//
//  For the last line of text, it should be left-justified, and no extra space is inserted between words.
//
//  Note:
//  - A word is defined as a character sequence consisting of non-space characters only.
//  - Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
//  - The input array words contains at least one word.
//
//  Example 1:
//    Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
//    Output:
//    [
//       "This    is    an",
//       "example  of text",
//       "justification.  "
//    ]
//----------------------------------------------------------------------------------------------------------------------

package Problem68;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public static void main(String[] args) {
        String[] words = {"a"};
        int maxWidth = 1;

        List<String> result = fullJustify(words, maxWidth);

        for (String s : result) {
            System.out.println(s);
        }
    }
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> justified = new ArrayList<>();
        int wordIndex = 0;
        int lineStart = 0;
        int lineLength = 0;

        while (wordIndex < words.length) {
            int currentLength = words[wordIndex].length();

            if (wordIndex == lineStart) {
                lineLength += currentLength;
                wordIndex++;
            } else if (maxWidth - lineLength > currentLength + 1) {
                lineLength += currentLength + 1;
                wordIndex++;
            } else if (maxWidth - lineLength == currentLength + 1) {
                // Add all words and append next line
                String line = buildLine(words, lineStart, wordIndex);
                justified.add(line);
                lineLength = 0;
                lineStart = ++wordIndex;
            } else {
                // Justify next line and append
                int spaces = maxWidth - lineLength;
                int wordOffset = 0;
                int numWords = Math.max(wordIndex - lineStart - 1, 1);

                while (spaces > 0) {
                    words[lineStart + wordOffset] += " ";
                    wordOffset = (wordOffset + 1) % numWords;
                    spaces--;
                }

                // Add all words and append next line
                String line = buildLine(words, lineStart, wordIndex - 1);
                justified.add(line);
                lineLength = 0;
                lineStart = wordIndex;
            }
        }

        // Add remaining words
        if (lineStart < words.length) {
            StringBuilder lastLine = new StringBuilder();
            lastLine.append(words[lineStart++]);

            while (lineStart < words.length) {
                lastLine.append(" ").append(words[lineStart++]);
            }

            while (lastLine.length() < maxWidth) {
                lastLine.append(" ");
            }

            justified.add(lastLine.toString());
        }

        return justified;
    }

    private static String buildLine(String[] words, int lineStart, int lineEnd) {
        StringBuilder line = new StringBuilder();

        while (lineStart < lineEnd) {
            line.append(words[lineStart++]).append(" ");
        }

        line.append(words[lineStart]);

        return line.toString();
    }
}
