class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0, high = matrix.length - 1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(matrix[mid][0] == target) return true;

            else if(matrix[mid][0] < target){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if(high < 0) return false;

        for(int num : matrix[high]){
            if(num == target) return true;
        }

        return false;
    }
}