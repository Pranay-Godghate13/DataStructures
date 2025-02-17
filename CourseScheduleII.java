class Solution {
    public boolean isCycle(ArrayList<Integer> adj[], int visited[], int pathVisited[], int curr, int N) {
        visited[curr] = 1;
        pathVisited[curr] = 1;

        for (int i = 0; i < adj[curr].size(); i++) {
            int element = adj[curr].get(i);
            if (visited[element] == 0) {
                if (isCycle(adj, visited, pathVisited, element, N))
                    return true;
            }
            if (visited[element] == 1 && pathVisited[element] == 1)
                return true;
        }
        pathVisited[curr] = 0;
        return false;
    }

    public void toposort(ArrayList<Integer> adj[], int visit[], Stack<Integer> st, int curr) {
        visit[curr] = 1;

        for (int i = 0; i < adj[curr].size(); i++) {
            int element = adj[curr].get(i);
            if (visit[element] == 0) {
                toposort(adj, visit, st, element);
            }
        }
        st.push(curr);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> adj[] = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            adj[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        int visited[] = new int[numCourses];
        int pathVisited[] = new int[numCourses];
        boolean cycle = false;
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (isCycle(adj, visited, pathVisited, i, numCourses))
                    cycle = true;
            }
        }

        if (cycle)
            return new int[0];

        Stack<Integer> st = new Stack<Integer>();
        int visit[] = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visit[i] == 0)
                toposort(adj, visit, st, i);
        }

        int ans[] = new int[numCourses];
        int c = 0;
        while (!st.isEmpty()) {
            ans[c++] = st.peek();
            st.pop();
        }
        return ans;

    }
}