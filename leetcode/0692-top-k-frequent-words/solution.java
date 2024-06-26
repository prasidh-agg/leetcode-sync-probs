class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();

        // Build map of words and their frequencies
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // Priority queue with custom comparator
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            int freqComparison = map.get(a).compareTo(map.get(b));
            if (freqComparison == 0) {
                return b.compareTo(a); // For same frequency, compare lexicographically in reverse order
            }
            return freqComparison;
        });

        // Add entries to the priority queue
        for (String word : map.keySet()) {
            pq.offer(word);
            if (pq.size() > k) {
                pq.poll(); // Remove the least frequent word
            }
        }

        // Extract results from the priority queue
        List<String> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }

        // The result list will be in reverse order, so we need to reverse it
        Collections.reverse(result);
        return result;
    }
}
