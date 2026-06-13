class Solution {
    public int countComponents(int n, int[][] edges) {
        int cnt=0;
        int V=edges.length;
        ArrayList<ArrayList<Integer>> adj =  new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        boolean[] visited= new boolean[n];
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        for(int i=0;i<n;i++){
            if(!visited[i]){
                cnt++;
                dfs(i,adj,visited);
            }
        }
        return cnt;

    }

    public void dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean[] visited){
        visited[node]=true;
        for(int it:adj.get(node)){
            if(!visited[it]){
                dfs(it,adj,visited);
            }
        }
    }
}
