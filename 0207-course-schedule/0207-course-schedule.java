import java.util.*;

class Solution {
    public boolean canFinish(int num, int[][] pre) {
        Queue<Integer> q = new LinkedList<>();
        int indegree[] = new int[num];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < num; i++) {
            adj.add(new ArrayList<>());
        }

        // Build graph and compute in-degree
        for (int[] p : pre) {
            int u = p[1]; // Course that needs to be taken first
            int v = p[0]; // Dependent course
            adj.get(u).add(v);
            indegree[v]++;
        }

        // Add nodes with 0 in-degree to queue
        for (int i = 0; i < num; i++) {
            if (indegree[i] == 0) q.offer(i);
        }

        int count = 0;
        while (!q.isEmpty()) {
            int t = q.poll();
            count++;

            // Reduce in-degree of adjacent nodes
            for (int v : adj.get(t)) {
                indegree[v]--;
                if (indegree[v] == 0) q.offer(v); // ✅ Correct: Enqueue node v
            }
        }

        return count == num; // If all courses are finished, return true
    }
}
