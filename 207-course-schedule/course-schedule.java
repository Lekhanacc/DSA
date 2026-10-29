import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 1. Build the adjacency list and tracking array for incoming edges (indegree)
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        
        int[] indegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prerequisite = pre[1];
            adj.get(prerequisite).add(course);
            indegree[course]++;
        }
        
        // 2. Add all courses with 0 prerequisites (indegree == 0) to the queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        // 3. Process the queue and keep track of how many courses can be taken
        int takenCourses = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            takenCourses++;
            
            // Reduce the indegree for neighboring courses
            for (int neighbor : adj.get(current)) {
                indegree[neighbor]--;
                // If a neighbor has no more remaining prerequisites, add to queue
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        // 4. If we successfully processed all courses, no cycle exists
        return takenCourses == numCourses;
    }
}
