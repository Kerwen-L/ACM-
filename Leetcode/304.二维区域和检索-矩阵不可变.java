/*
 * @lc app=leetcode.cn id=304 lang=java
 *
 * [304] 二维区域和检索 - 矩阵不可变
 */

// @lc code=start
class NumMatrix {
    private int[][] DP;
    private int m = 0;
    private int n = 0;

    public NumMatrix(int[][] matrix) {
        m = matrix.length;
        if( m == 0 ){
            return ;
        }
        n = matrix[0].length;

        System.out.println(m);
        System.out.println(n);
        
        DP = new int[m+1][n+1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                DP[i+1][j+1] = DP[i+1][j] + matrix[i][j];
            }
        }
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                DP[i+1][j+1] += DP[i][j+1];
            }
        }


    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return DP[row2+1][col2+1]-DP[row1][col2+1]-DP[row2+1][col1]+DP[row1][col1];

    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
// @lc code=end

