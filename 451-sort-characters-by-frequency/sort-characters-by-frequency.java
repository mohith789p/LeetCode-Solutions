class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> mp = new HashMap<>();

        for(char ch : s.toCharArray()){
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        for(Map.Entry<Character, Integer> e : mp.entrySet()){
            pq.add(e);
        }

        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()){
            Map.Entry<Character, Integer> cur = pq.poll();
            int freq = cur.getValue();
            while(freq-- > 0) {
                sb.append(cur.getKey());
            }
        }

        return sb.toString();
    }
}