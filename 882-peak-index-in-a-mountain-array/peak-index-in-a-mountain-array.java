class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;

        int low = 0, high = n - 1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(arr[mid - 1] <= arr[mid] && arr[mid + 1] <= arr[mid])
                return mid;

            else if(arr[mid - 1] <= arr[mid] && arr[mid + 1] >= arr[mid]){
                low = mid;
            }

            else {
                high = mid;
            }
        }

        return low;
    }
}