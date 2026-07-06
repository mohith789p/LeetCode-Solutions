class Solution {
    public boolean isPerfectSquare(int num) {
        if(num <= 1) return true;

        int low = 0; int high = num;

        while(low <= high){
            int mid = low + (high - low) / 2;
            double res = (double) num / mid;
            System.out.println(res);
            if(mid == res) return true;

            else if(mid > res) high = mid - 1;

            else low = mid + 1;
        }

        return false;
    }
}