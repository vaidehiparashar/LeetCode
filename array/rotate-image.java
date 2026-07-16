class Solution {
    public void rotate(int[][] matrix) {
        int row = 0;
        int left = 0;
        int right = matrix.length-1;

        while(left<right){
            int i = row;
            int j = left;
            int offset = 0;
            while(j<right){
                int temp1 = matrix[i][j];
                int temp2;
                    temp2 = matrix[j][right];
                    matrix[j][right] = temp1;
                    temp1 = temp2;
                
                    temp2 = matrix[right][right-offset];
                    matrix[right][right-offset] = temp1;
                    temp1 = temp2;
             
                    temp2 = matrix[right-offset][left];
                    matrix[right-offset][left] = temp1;
                    temp1 = temp2;
               
                    matrix[i][j] = temp1;
                offset++;
                j++;
            }
            row++;
            left++;
            right--;
        }
    }
}