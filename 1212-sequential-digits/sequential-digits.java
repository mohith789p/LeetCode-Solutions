class Solution {
    static List<Integer> valid;
    static {
        valid = new ArrayList<>();
        valid.add(12);
        valid.add(23);
        valid.add(34);
        valid.add(45);
        valid.add(56);
        valid.add(67);
        valid.add(78);
        valid.add(89);
        valid.add(123);
        valid.add(234);
        valid.add(345);
        valid.add(456);
        valid.add(567);
        valid.add(678);
        valid.add(789);
        valid.add(1234);
        valid.add(2345);
        valid.add(3456);
        valid.add(4567);
        valid.add(5678);
        valid.add(6789);
        valid.add(12345);
        valid.add(23456);
        valid.add(34567);
        valid.add(45678);
        valid.add(56789);
        valid.add(123456);
        valid.add(234567);
        valid.add(345678);
        valid.add(456789);
        valid.add(1234567);
        valid.add(2345678);
        valid.add(3456789);
        valid.add(12345678);
        valid.add(23456789);
        valid.add(123456789);
    }

    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();

        for(int v : valid){
            if(v > high) break; 
            if(v >= low) ans.add(v); 
        }

        return ans;
    }
}