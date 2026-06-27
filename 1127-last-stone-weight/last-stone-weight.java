class Solution {
    public int lastStoneWeight(int[] stones) {

        // Max Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // Insert all stones into the heap
        for (int stone : stones) {
            pq.offer(stone);
        }

        // Keep smashing while at least two stones exist
        while (pq.size() > 1) {

            int first = pq.poll();   // Largest stone
            int second = pq.poll();  // Second largest stone

            if (first != second) {
                pq.offer(first - second);
            }
        }

        // Return remaining stone or 0
        return pq.isEmpty() ? 0 : pq.poll();
    }
}