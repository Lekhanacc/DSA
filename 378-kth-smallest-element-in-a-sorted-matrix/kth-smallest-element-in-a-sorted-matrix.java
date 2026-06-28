class Solution {

    class Node {
        int value;
        int row;
        int col;

        Node(int value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col = col;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {

        int n = matrix.length;

        PriorityQueue<Node> pq = new PriorityQueue<>(
            (a, b) -> a.value - b.value
        );

        // Put first element of every row
        for (int i = 0; i < n; i++) {
            pq.offer(new Node(matrix[i][0], i, 0));
        }

        // Remove first k-1 smallest elements
        for (int i = 1; i < k; i++) {

            Node curr = pq.poll();

            if (curr.col + 1 < n) {
                pq.offer(new Node(
                        matrix[curr.row][curr.col + 1],
                        curr.row,
                        curr.col + 1
                ));
            }
        }

        return pq.peek().value;
    }
}