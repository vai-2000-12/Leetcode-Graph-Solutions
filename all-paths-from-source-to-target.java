import java.util.*;

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        int n = graph.length;
        
        // Stack to perform DFS
        Stack<Integer> stack = new Stack<>();
        Stack<List<Integer>> pathStack = new Stack<>();
        
        stack.push(0);
        pathStack.push(new ArrayList<>(Arrays.asList(0))); // Start with node 0 as the initial path
        
        while (!stack.isEmpty()) {
            int currentNode = stack.pop();
            List<Integer> currentPath = pathStack.pop();
            
            // If we reach the target node n-1, add the current path to the result
            if (currentNode == n - 1) {
                result.add(currentPath);
                continue;
            }
            
            // Explore neighbors using DFS
            for (int neighbor : graph[currentNode]) {
                stack.push(neighbor);
                
                // Create a new path that includes the neighbor
                List<Integer> newPath = new ArrayList<>(currentPath);
                newPath.add(neighbor);
                pathStack.push(newPath);
            }
        }
        
        return result;
    }
}