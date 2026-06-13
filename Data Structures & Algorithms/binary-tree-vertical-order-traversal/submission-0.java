/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 class Pair{
    TreeNode node;
    int col;
    Pair(TreeNode node, int col){
        this.node= node;
        this.col=col;
    }
 }

class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result= new ArrayList<>();
        if(root==null) return result;
        Queue<Pair> q= new LinkedList<>();
        q.offer(new Pair(root,0));
        Map<Integer,List<Integer>> map= new TreeMap<>();
        while(!q.isEmpty()){
            Pair p= q.poll();
            TreeNode node= p.node;
            int col= p.col;

            map.putIfAbsent(col,new ArrayList<>());
            map.get(col).add(node.val);
            if(node.left!= null){
                q.offer(new Pair(node.left,col-1));
            }
            if(node.right!=null){
                q.offer(new Pair(node.right,col+1));
            }
        }
        for(List<Integer> list:map.values()){
            result.add(list);
        }

        return result;
        
    }
}