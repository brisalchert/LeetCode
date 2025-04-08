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
        return false;
    }
}
