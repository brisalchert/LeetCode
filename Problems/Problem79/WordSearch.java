//----------------------------------------------------------------------------------------------------------------------
//  79. Word Search
//
//  Given an m x n grid of characters board and a string word, return true if word exists in the grid.
//
//  The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally
//  or vertically neighboring. The same letter cell may not be used more than once.
//
//  Example 1:
//    Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
//    Output: true
//----------------------------------------------------------------------------------------------------------------------

package Problem79;

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";

        System.out.println(exist(board, word));
    }

    public static boolean exist(char[][] board, String word) {
        // Iterate through the board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                // Start a DFS when the first character is found
                if (board[i][j] == word.charAt(0)) {
                    if (existDFS(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static boolean existDFS(char[][] board, String word, int i, int j, int index) {
        // Base cases
        if (index == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != word.charAt(index)) {
            return false;
        }

        // Recursive case
        board[i][j] = ' ';

        // Check for next character in adjacent cells
        if (existDFS(board, word, i + 1, j, index + 1) ||
            existDFS(board, word, i - 1, j, index + 1) ||
            existDFS(board, word, i, j + 1, index + 1) ||
            existDFS(board, word, i, j - 1, index + 1)) {
            return true;
        }

        // Return false for a failed existence check
        board[i][j] = word.charAt(index);
        return false;
    }
}
