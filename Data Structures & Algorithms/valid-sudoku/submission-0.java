class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        for (int row = 0; row < 9; row++) {

            for (int col = 0; col < 9; col++) {

                char value = board[row][col];

                if (value == '.') {
                    continue;
                }

                String rowValue = value + "-row-" + row;
                String colValue = value + "-col-" + col;
                String boxValue = value + "-box-" + (row/3) + "-" + (col/3);

                if (!seen.add(rowValue) || 
                !seen.add(colValue) ||
                !seen.add(boxValue)) {
                    return false;
                }
            }
        }
        return true;
    }
}
