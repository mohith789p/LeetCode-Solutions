class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int k = p.length();
        List<Integer> ans = new ArrayList<>();
        if(s.length() < k) return ans;

        int arr[] = new int[26] ;
        int a[] = new int[26];

        for(int i = 0; i < k; i++){
            int ch1 = p.charAt(i);
            int ch2 = s.charAt(i);

            a[ch1 - 'a']++;
            arr[ch2 - 'a']++;
        }

        if(Arrays.equals(arr, a)) {
            ans.add(0);
        }

        for(int i = k; i < s.length(); i++){
            char l = s.charAt(i - k);
            char r = s.charAt(i);

            arr[l - 'a']--;
            arr[r - 'a']++;

            if(Arrays.equals(arr, a)) {
                ans.add(i - k + 1);
            }
        }

        return ans;
    }
}