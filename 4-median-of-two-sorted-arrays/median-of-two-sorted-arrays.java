class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        List<Integer> nums = new ArrayList<>();

        for (int n : nums1) {
            nums.add(n);
        }
        for (int n : nums2) {
            nums.add(n);
        }

        int len = nums.size();

        Collections.sort(nums);

        if(len % 2 == 0) {
            return (nums.get(len / 2) + nums.get(len / 2 - 1)) / 2.0;
        }

        return nums.get(len / 2);
    }
}